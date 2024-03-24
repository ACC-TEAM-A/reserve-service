package com.eureka.reserveserivce.constant;

import lombok.Getter;

@Getter
public enum Event {
    TICKET("티켓");

    private String name;

    Event(String name) {
        this.name = name;
    }
}
