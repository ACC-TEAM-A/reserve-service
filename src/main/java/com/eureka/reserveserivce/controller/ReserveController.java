package com.eureka.reserveserivce.controller;

import com.eureka.reserveserivce.domain.Reserve;
import com.eureka.reserveserivce.service.ReserveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class ReserveController {
    private final ReserveService reserveService;

    // 예약 생성
    @PostMapping("")
    public Reserve createReserve() {
        return reserveService.createReserve();
    }

    // 예약 조회
    @GetMapping("")
    public List<Reserve> getReserves() {
        return reserveService.getReserves();
    }
}
