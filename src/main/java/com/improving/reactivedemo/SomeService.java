package com.improving.reactivedemo;

import org.springframework.stereotype.Service;

@Service
public class SomeService {

    public Integer updateProfile(byte[] profileAvatar, String uuid, ProfileResponse profileResponse) {


        if ("CLEAN".equalsIgnoreCase(profileResponse.getVirusScanStatus())) {
            return 1;
        }
        return 0;
    }
}