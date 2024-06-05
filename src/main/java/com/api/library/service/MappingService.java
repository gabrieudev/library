package com.api.library.service;

import com.api.library.dto.*;
import com.api.library.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingService {

    @Autowired
    private ModelMapper modelMapper;

    public User toModel(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO toDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public Author toModel(AuthorDTO authorDTO) {
        return modelMapper.map(authorDTO, Author.class);
    }

    public AuthorDTO toDto(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

    public void toModel(AuthorDTO authorDTO, Author author) {
        modelMapper.map(authorDTO, author);
    }

    public Book toModel(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

    public BookDTO toDto(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public void toModel(BookDTO bookDTO, Book book) {
        modelMapper.map(bookDTO, book);
    }

    public Category toModel(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, Category.class);
    }

    public CategoryDTO toDto(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    public void toModel(CategoryDTO categoryDTO, Category category) {
        modelMapper.map(categoryDTO, category);
    }

    public Loan toModel(LoanDTO loanDTO) {
        return modelMapper.map(loanDTO, Loan.class);
    }

    public LoanDTO toDto(Loan loan) {
        return modelMapper.map(loan, LoanDTO.class);
    }

    public void toModel(LoanDTO loanDTO, Loan loan) {
        modelMapper.map(loanDTO, loan);
    }

}
