package com.api.library.dto;

public record UserLoginResponse(String token, Long expiresIn) {
}
