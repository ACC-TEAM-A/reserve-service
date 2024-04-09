package com.eureka.reserveserivce.service;

import com.eureka.reserveserivce.constant.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class TicketServiceTest {
    @Autowired
    private TicketService ticketService;

    @Test
    void 선착순티켓팅_100명에게_티켓_30개_제공() throws InterruptedException {
        final Event ticketEvent = Event.TICKET;
        final int people = 100;
        final int limitCount = 30;
        final CountDownLatch countDownLatch = new CountDownLatch(people);

        ticketService.setEventCount(ticketEvent, limitCount);

        List<Thread> workers = Stream
                .generate(() -> new Thread(new AddQueueWorker(countDownLatch, ticketEvent)))
                .limit(people)
                .toList();
        workers.forEach(Thread::start);
        countDownLatch.await();
        Thread.sleep(5000); // 기프티콘 발급 스케줄러 작업 시간

        final long failEventPeople = ticketService.getSize(ticketEvent);
        assertEquals(people - limitCount, failEventPeople); // output : 70 = 100 - 30
    }

    private class AddQueueWorker implements Runnable{
        private final CountDownLatch countDownLatch;
        private final Event event;

        public AddQueueWorker(CountDownLatch countDownLatch, Event event) {
            this.countDownLatch = countDownLatch;
            this.event = event;
        }

        @Override
        public void run() {
            ticketService.addQueue(event);
            countDownLatch.countDown();
        }
    }
}
