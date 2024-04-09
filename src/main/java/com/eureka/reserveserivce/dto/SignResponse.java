package com.eureka.reserveserivce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {
    private Long id;

    private String account;

    private String nickname;

    private String name;

    private String email;

    private List<Authority> roles = new ArrayList<>();

    private String token;
}