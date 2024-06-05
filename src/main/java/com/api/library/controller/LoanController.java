package com.api.library.controller;

import com.api.library.dto.LoanDTO;
import com.api.library.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody LoanDTO loanDTO) {
        loanService.save(loanDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<LoanDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanDTO> update(@PathVariable("id") Long id, @Valid @RequestBody LoanDTO loanDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.update(id, loanDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        loanService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

