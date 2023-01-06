package com.improving.reactivedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {

    @GetMapping("/testme")
    public Mono<String> testMe() {
        return Mono.just("this is a test string");
    }

    @GetMapping("/getdetails")
    public Mono<Details> getTestArgsFromHttpBin() {

        return WebClient.create().get()
                .uri("http://httpbin.org/anything?data=test")
                .retrieve()
                .bodyToMono(Details.class);
    }

    @GetMapping("/justgetdata")
    public Mono<String> getTestDataFromHttpBin() {
        return getTestArgsFromHttpBin().map(details -> details.getArgs().getData());
    }
}
