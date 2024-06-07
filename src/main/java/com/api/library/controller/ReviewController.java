package com.api.library.controller;

import com.api.library.dto.ReviewDTO;
import com.api.library.service.ReviewService;
import com.api.library.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<Void> save(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody ReviewDTO reviewDTO
    ) {
        if (tokenService.notBelongs(jwt, reviewDTO.getUser().getId())) {
            throw new AccessDeniedException("You don't have access to this");
        }
        reviewService.save(reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<ReviewDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<List<ReviewDTO>> getAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAll(pageable).getContent());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<ReviewDTO> update(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable("id") Long id,
            @Valid @RequestBody ReviewDTO reviewDTO
    ) {
        if (tokenService.notBelongs(jwt, reviewDTO.getUser().getId())) {
            throw new AccessDeniedException("You don't have access to this");
        }
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.update(id, reviewDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<Void> delete(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable("id") Long id
    ) {
        ReviewDTO reviewDTO = reviewService.getById(id);
        if (tokenService.notBelongs(jwt, reviewDTO.getUser().getId())) {
            throw new AccessDeniedException("You don't have access to this");
        }
        reviewService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/by-book/{bookId}")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<List<ReviewDTO>> getByBook(
            @PathVariable("bookId") Long bookId,
            Pageable pageable
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getByBook(bookId, pageable).getContent());
    }

    @GetMapping("/by-user/{userId}")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<List<ReviewDTO>> getByUser(
            @PathVariable("userId") UUID userId,
            Pageable pageable
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getByUser(userId, pageable).getContent());
    }

}

