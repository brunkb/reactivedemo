package com.improving.reactivedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {

    @GetMapping("/testme")
    public Mono<String> testMe() {
        return Mono.just("this is a test string");
    }
}
