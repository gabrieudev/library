package com.api.library.controller;

import com.api.library.dto.BookDTO;
import com.api.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Void> save(@Valid @RequestBody BookDTO bookDTO) {
        bookService.save(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<BookDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<List<BookDTO>> getAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAll(pageable).getContent());
    }

    @GetMapping("/by-author/{name}")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<List<BookDTO>> getAllByAuthor(
            Pageable pageable,
            @PathVariable("name") String name
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getByAuthor(name, pageable).getContent());
    }

    @GetMapping("/by-category/{categoryId}")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<List<BookDTO>> getAllByCategory(
            Pageable pageable,
            @PathVariable("categoryId") Long categoryId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getByCategory(categoryId, pageable).getContent());
    }

    @GetMapping("/best-rated")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<List<BookDTO>> getBestRated(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBestRated(pageable).getContent());
    }

    @GetMapping("/most-borrowed")
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<List<BookDTO>> getMostBorrowed(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getMostBorrowed(pageable).getContent());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<BookDTO> update(@PathVariable("id") Long id, @Valid @RequestBody BookDTO bookDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.update(id, bookDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

