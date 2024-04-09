package com.eureka.reserveserivce.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "reserve")
public class Reserve extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "concert_id")
    private Long concertId;

    @Column(name = "status")
    private String status;

    @Builder
    public Reserve(Long userId, Long concertId, String status) {
        this.userId = userId;
        this.concertId = getConcertId();
        this.status = status;
    }
}
