package com.eureka.reserveserivce.feign;

import com.eureka.reserveserivce.dto.ConcertResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "concertservice", url = "http://43.201.88.125:8083")
public interface FindConcertFeignClient {
    @GetMapping("/concert/title") // 예시 URL, 실제 URL에 맞게 변경 필요
    ResponseEntity<ConcertResponse> getAllConcerts(@RequestParam(value = "title") String title);
}
