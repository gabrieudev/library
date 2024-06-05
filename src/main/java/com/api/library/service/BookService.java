package com.api.library.service;

import com.api.library.dto.BookDTO;
import com.api.library.exception.ObjectNotFoundException;
import com.api.library.model.Book;
import com.api.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                () -> new ObjectNotFoundException("Book not found with this id: " + id)
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
     * @throws ObjectNotFoundException if id is not found
     */
    public BookDTO update(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Book not found with this id: " + id)
        );
        mappingService.toModel(bookDTO, book);
        Book updatedBook = bookRepository.save(book);
        return mappingService.toDto(updatedBook);
    }

    /**
     * Deletes a book by its id
     *
     * @param id the book's id
     * @throws ObjectNotFoundException if id is not found
     */
    public void delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Book not found with this id: " + id)
        );
        bookRepository.delete(book);
    }

    /**
     * Retrieves all the books
     *
     * @return the List of books
     */
    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream().map(
                book -> mappingService.toDto(book)
        ).toList();
    }

}

