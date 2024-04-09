package com.eureka.reserveserivce.feign;

import com.eureka.reserveserivce.dto.SignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "userservice", url = "http://10.0.3.238:8082")
public interface FindUserFeignClient {
    @GetMapping("/user/get")
    ResponseEntity<SignResponse> getUser(@RequestParam String account);

}
