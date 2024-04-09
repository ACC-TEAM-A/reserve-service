package com.eureka.reserveserivce.controller;

import com.eureka.reserveserivce.constant.Event;
import com.eureka.reserveserivce.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventScheduler {   // 1초마다 도는 대기열 동기화 스케줄러 구성
    private final TicketService ticketService;

    @Scheduled(fixedDelay = 1000)
    private void concertEventScheduler(){
        if(ticketService.validEnd()){
            log.info("===== 선착순 티켓팅이 종료되었습니다. =====");
            return;
        }
        ticketService.publish(Event.TICKET);
        ticketService.getOrder(Event.TICKET);
    }
}
