package com.improving.reactivedemo;

import reactor.core.publisher.Mono;

public class ProfileResponse {

    private byte[] profileAvatar;

    public ProfileResponse() {

    }

    public ProfileResponse(byte[] profileAvatar) {
        this.profileAvatar = profileAvatar;
    }

    public String getVirusScanStatus() {

        return "CLEAN";
    }

}
