package com.improving.reactivedemo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SomeService {

    public Mono<Integer> updateProfile(byte[] profileAvatar, String uuid, ProfileResponse profileResponse) {
    // Note:  It's a little more correct for this service to return a Mono<Integer> since it would be where a web
        // request would take place, or a call to a database, which I just simulate below.

        if ("CLEAN".equalsIgnoreCase(profileResponse.getVirusScanStatus())) {
            return Mono.just(1);
        }
        return Mono.just(0);
    }
}