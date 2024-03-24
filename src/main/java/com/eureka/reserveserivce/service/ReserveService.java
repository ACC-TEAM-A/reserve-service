package com.eureka.reserveserivce.service;

import com.eureka.reserveserivce.domain.Reserve;
import com.eureka.reserveserivce.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReserveService {
    private final ReserveRepository reserveRepository;

    // 예약 생성
    public Reserve createReserve() {
        return reserveRepository.save(Reserve.builder().status("test").build());
    }

    // 예약 조회
    public List<Reserve> getReserves() {
        return reserveRepository.findAll();
    }
}
