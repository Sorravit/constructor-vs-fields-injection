package com.sorravit.constructorvsfieldsinjection.controller;

import com.sorravit.constructorvsfieldsinjection.common.APIVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(APIVersion.V1 + "/hello")
    public String hello() {
        return "Hello from this side";
    }
}
