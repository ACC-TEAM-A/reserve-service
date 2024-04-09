package com.eureka.reserveserivce.domain;


import com.eureka.reserveserivce.constant.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventCount {
    private Event event;    // 어떤 콘서트인지 식별
    private int limit;  // 좌석 개수 (한도)

    private static final int END = 0;

    public EventCount(Event event, int limit) {
        this.event = event;
        this.limit = limit;
    }

    public synchronized void decrease(){
        this.limit--;
    }

    public boolean end(){
        return this.limit == END;
    }
}
