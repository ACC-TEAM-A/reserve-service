package com.eureka.reserveserivce.service;

import com.eureka.reserveserivce.domain.Reserve;
import com.eureka.reserveserivce.feign.FindConcertFeignClient;
import com.eureka.reserveserivce.feign.FindUserFeignClient;
import com.eureka.reserveserivce.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReserveService {
    private final ReserveRepository reserveRepository;
    private final FindConcertFeignClient findConcertFeignClient;
    private final FindUserFeignClient findUserFeignClient;

    // 예약 생성
    public Reserve createReserve(String account, String title) {
        Long userId = Objects.requireNonNull(findUserFeignClient.getUser(account).getBody()).getId();
        Long concertId = Objects.requireNonNull(findConcertFeignClient.getAllConcerts(title).getBody()).getId();
        return reserveRepository.save(
                Reserve.builder()
                        .userId(userId)
                        .concertId(concertId)
                        .status("test")
                        .build());
    }

    // 예약 조회
    public List<Reserve> getReserves() {
        return reserveRepository.findAll();
    }
}
