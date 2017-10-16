package com.sangchual.paytm.softwarechallenges.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/greeting/helloworld/v1")
    public String sayHelloWorld() {
        return new HelloWorld().getGreeting() ;
    }
}
