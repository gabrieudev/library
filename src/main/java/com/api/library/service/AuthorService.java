package com.api.library.service;

import com.api.library.dto.AuthorDTO;
import com.api.library.exception.EntityNotFoundException;
import com.api.library.model.Author;
import com.api.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private MappingService mappingService;

    /**
     * retrieves an author by its id
     *
     * @param id the author's id
     * @return the author's DTO
     */
    public AuthorDTO getById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Author not found with this id: " + id)
        );
        return mappingService.toDto(author);
    }

    /**
     * saves an author
     *
     * @param authorDTO the author's DTO
     */
    public void save(AuthorDTO authorDTO) {
        Author author = mappingService.toModel(authorDTO);
        authorRepository.save(author);
    }

    /**
     * updates an author
     *
     * @param id the author's id
     * @param authorDTO the author's DTO
     * @return the updated author's DTO
     * @throws EntityNotFoundException if id is not found
     */
    public AuthorDTO update(Long id, AuthorDTO authorDTO) {
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Author not found with this id: " + id)
        );
        mappingService.toModel(authorDTO, author);
        Author updatedAuthor = authorRepository.save(author);
        return mappingService.toDto(updatedAuthor);
    }

    /**
     * deletes an author by its id
     *
     * @param id the author's id
     * @throws EntityNotFoundException if id is not found
     */
    public void delete(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Author not found with this id: " + id)
        );
        authorRepository.delete(author);
    }

    /**
     * retrieves the authors
     *
     * @return the Page of authors
     */
    public Page<AuthorDTO> getAll(Pageable pageable) {
        return authorRepository.findAll(pageable).map(
                author -> mappingService.toDto(author)
        );
    }

}
