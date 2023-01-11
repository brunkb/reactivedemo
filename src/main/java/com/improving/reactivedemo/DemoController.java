package com.improving.reactivedemo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class DemoController {

    private SomeService someService;

    public DemoController(SomeService someService) {
        this.someService = someService;
    }

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


    @PostMapping(value = "/domorestuff/{uuid}")
    public Mono<Integer> doStuffWithServiceCall(@RequestBody byte[] profileAvatar, @PathVariable String uuid) {

        return virusCheckProfileAvatar(profileAvatar).map(profileResponse -> someService.updateProfile(profileAvatar, uuid, profileResponse));
    }

    private Mono<ProfileResponse> virusCheckProfileAvatar(byte[] profileAvatar) {

        return Mono.just(new ProfileResponse(profileAvatar));
    }

}
