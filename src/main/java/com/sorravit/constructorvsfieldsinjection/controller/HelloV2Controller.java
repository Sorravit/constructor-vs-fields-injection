package com.sorravit.constructorvsfieldsinjection.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloV2Controller {
    @GetMapping("v2/hello")
    public String hello() {
        log.error("Some one is coming let say Hi!!!");
        log.warn("Never mind that guy is not important");
        return "Hello from the other side";
    }
}
