package com.api.library.controller;

import com.api.library.dto.LoanDTO;
import com.api.library.dto.UpdatePasswordRequest;
import com.api.library.dto.UserDTO;
import com.api.library.service.TokenService;
import com.api.library.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody UserDTO userDTO) {
        userService.register(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @PutMapping("/update-password")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<Object> updatePassword(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody UpdatePasswordRequest updatePasswordRequest
    ) {
        if (tokenService.notBelongs(jwt, updatePasswordRequest.email())) {
            throw new AccessDeniedException("You don't have access to this");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Password updated successfully");
    }

    @GetMapping("/check/{userId}/{verificationId}")
    public ResponseEntity<Object> check(
            @PathVariable("userId") UUID userId,
            @PathVariable("verificationId") UUID verificationId
    ) {
        userService.check(userId, verificationId);
        return ResponseEntity.status(HttpStatus.OK).body("E-mail verified successfully");
    }

    @GetMapping("/{email}/loan-history")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<List<LoanDTO>> getLoans(
            @AuthenticationPrincipal Jwt jwt,
            Pageable pageable,
            @PathVariable("email") String email
    ) {
        if (tokenService.notBelongs(jwt, email)) {
            throw new AccessDeniedException("You don't have access to this");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.getLoans(email, pageable).getContent());
    }

}
