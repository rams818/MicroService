package com.ramkumar.controller;

import com.ramkumar.client.WelcomeApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

    @Autowired
    private WelcomeApiClient welcomeApiClient;

    @GetMapping("/greet")
    public String greetMessage(){
        String welcomeMsg = welcomeApiClient.invokeWelcomeMsg();
        return "Good Morning "+ welcomeMsg;
    }
}
