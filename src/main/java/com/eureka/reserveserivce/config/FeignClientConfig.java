package com.eureka.reserveserivce.config;

import com.eureka.reserveserivce.ReserveserivceApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = ReserveserivceApplication.class)
public class FeignClientConfig {
}
