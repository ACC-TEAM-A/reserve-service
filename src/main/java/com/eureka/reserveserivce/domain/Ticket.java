package com.eureka.reserveserivce.domain;

import com.eureka.reserveserivce.constant.Event;
import lombok.Getter;

import java.util.UUID;


@Getter
public class Ticket {
    private Event event;
    private String code;

    public Ticket(Event event) {
        this.event = event;
        this.code = UUID.randomUUID().toString();
    }
}
