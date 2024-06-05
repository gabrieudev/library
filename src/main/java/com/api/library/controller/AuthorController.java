package com.api.library.controller;

import com.api.library.dto.AuthorDTO;
import com.api.library.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AuthorDTO authorDTO) {
        authorService.save(authorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable("id") Long id, @Valid @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.update(id, authorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        authorService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
