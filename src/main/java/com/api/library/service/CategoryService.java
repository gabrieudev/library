package com.api.library.service;

import com.api.library.dto.CategoryDTO;
import com.api.library.exception.ObjectNotFoundException;
import com.api.library.model.Category;
import com.api.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MappingService mappingService;

    /**
     * Retrieves a category by its id
     *
     * @param id the category's id
     * @return the category's DTO
     */
    public CategoryDTO getById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Category not found with this id: " + id)
        );
        return mappingService.toDto(category);
    }

    /**
     * Saves a category
     *
     * @param categoryDTO the category's DTO
     */
    public void save(CategoryDTO categoryDTO) {
        Category category = mappingService.toModel(categoryDTO);
        categoryRepository.save(category);
    }

    /**
     * Updates a category
     *
     * @param id the category's id
     * @param categoryDTO the category's DTO
     * @return the updated category's DTO
     * @throws ObjectNotFoundException if id is not found
     */
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Category not found with this id: " + id)
        );
        mappingService.toModel(categoryDTO, category);
        Category updatedCategory = categoryRepository.save(category);
        return mappingService.toDto(updatedCategory);
    }

    /**
     * Deletes a category by its id
     *
     * @param id the category's id
     * @throws ObjectNotFoundException if id is not found
     */
    public void delete(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Category not found with this id: " + id)
        );
        categoryRepository.delete(category);
    }

    /**
     * Retrieves all the categories
     *
     * @return the List of categories
     */
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll().stream().map(
                category -> mappingService.toDto(category)
        ).toList();
    }

}

