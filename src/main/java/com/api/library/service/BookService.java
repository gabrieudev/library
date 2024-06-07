package com.api.library.service;

import com.api.library.dto.BookDTO;
import com.api.library.exception.EntityNotFoundException;
import com.api.library.model.Book;
import com.api.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MappingService mappingService;

    /**
     * Retrieves a book by its id
     *
     * @param id the book's id
     * @return the book's DTO
     */
    public BookDTO getById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Book not found with this id: " + id)
        );
        return mappingService.toDto(book);
    }

    /**
     * Saves a book
     *
     * @param bookDTO the book's DTO
     */
    public void save(BookDTO bookDTO) {
        Book book = mappingService.toModel(bookDTO);
        bookRepository.save(book);
    }

    /**
     * Updates a book
     *
     * @param id the book's id
     * @param bookDTO the book's DTO
     * @return the updated book's DTO
     * @throws EntityNotFoundException if id is not found
     */
    public BookDTO update(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Book not found with this id: " + id)
        );
        mappingService.toModel(bookDTO, book);
        Book updatedBook = bookRepository.save(book);
        return mappingService.toDto(updatedBook);
    }

    /**
     * Deletes a book by its id
     *
     * @param id the book's id
     * @throws EntityNotFoundException if id is not found
     */
    public void delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Book not found with this id: " + id)
        );
        bookRepository.delete(book);
    }

    /**
     * Retrieves the books
     *
     * @return the Page of books
     */
    public Page<BookDTO> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map(
                book -> mappingService.toDto(book)
        );
    }

    /**
     * retrieves the book by its author's name
     *
     * @param name the author's name
     * @return the Page of books
     */
    public Page<BookDTO> getAllByAuthor(String name, Pageable pageable) {
        return bookRepository.findAllByAuthor(name, pageable).map(
                book -> mappingService.toDto(book)
        );
    }

    /**
     * retrieves all the books by its category
     *
     * @param categoryId the category's id
     * @return the Page of books
     */
    public Page<BookDTO> getAllByCategory(Long categoryId, Pageable pageable) {
        return bookRepository.findAllByCategory(categoryId, pageable).map(
                book -> mappingService.toDto(book)
        );
    }

}

