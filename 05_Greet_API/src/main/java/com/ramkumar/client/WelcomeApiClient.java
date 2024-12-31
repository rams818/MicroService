package com.ramkumar.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="WELCOME-SERVICE")
public interface WelcomeApiClient {

    @GetMapping("/welcome")
    public String invokeWelcomeMsg();
}
