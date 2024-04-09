package com.eureka.reserveserivce.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ConcertResponse {
    private Long id;
    private String title;
    private Date startDate;
    private Date endDate;
    private String price;
    private Genre genre;
    private String description;
    private String runningTime;

    public ConcertResponse(Long id, String title, Date startDate, Date endDate, String price, Genre genre, // 변경된 부분
                           String description, String runningTime) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.genre = genre;
        this.description = description;
        this.runningTime = runningTime;
    }

}
