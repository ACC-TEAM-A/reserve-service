package com.eureka.reserveserivce.constant;

import lombok.Getter;

@Getter
public enum Event {
    TICKET("콘서트명");

    private String name;    // 어떤 콘서트인지 식별

    Event(String name) {
        this.name = name;
    }
}
