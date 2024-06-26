package com.eureka.reserveserivce.service;



import com.eureka.reserveserivce.constant.Event;
import com.eureka.reserveserivce.domain.EventCount;
import com.eureka.reserveserivce.domain.Ticket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketService {
    private final RedisTemplate<String,Object> redisTemplate;
    private static final long FIRST_ELEMENT = 0;
    private static final long LAST_ELEMENT = -1;
    private static final long PUBLISH_SIZE = 10;
    private static final long LAST_INDEX = 1;
    private EventCount eventCount;

    public void setEventCount(Event event, int queue){
        this.eventCount = new EventCount(event, queue);
    }
    public void addQueue(Event event){
        final String people = Thread.currentThread().getName();
        final long now = System.currentTimeMillis();

        redisTemplate.opsForZSet().add(event.toString(), people, (int) now);
        log.info("대기열에 추가 - {} ({}초)", people, now);
    }

    public void getOrder(Event event){
        final long start = FIRST_ELEMENT;
        final long end = LAST_ELEMENT;

        Set<Object> queue = redisTemplate.opsForZSet().range(event.toString(), start, end);

        for (Object people : queue) {
            Long rank = redisTemplate.opsForZSet().rank(event.toString(), people);
            log.info("'{}'님의 현재 대기열은 {}명 남았습니다.", people, rank);
        }
    }

    public void publish(Event event){
        final long start = FIRST_ELEMENT;
        final long end = PUBLISH_SIZE - LAST_INDEX;

        Set<Object> queue = redisTemplate.opsForZSet().range(event.toString(), start, end);
        for (Object people : queue) {
            final Ticket ticket = new Ticket(event);
            log.info("'{}'님의 {} 티켓이 발급되었습니다 ({})",people, ticket.getEvent().getName(), ticket.getCode());
            redisTemplate.opsForZSet().remove(event.toString(), people);
            this.eventCount.decrease();
        }
    }
    public boolean validEnd(){
        return this.eventCount != null
                ? this.eventCount.end()
                : false;
    }

    public long getSize(Event event){
        return redisTemplate.opsForZSet().size(event.toString());
    }
}
