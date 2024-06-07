package com.api.library.service;

import com.api.library.dto.ReviewDTO;
import com.api.library.exception.EntityNotFoundException;
import com.api.library.model.Review;
import com.api.library.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MappingService mappingService;

    /**
     * Retrieves a review by its id
     *
     * @param id the review's id
     * @return the review's DTO
     */
    public ReviewDTO getById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Review not found with this id: " + id)
        );
        return mappingService.toDto(review);
    }

    /**
     * Saves a review
     *
     * @param reviewDTO the review's DTO
     */
    public void save(ReviewDTO reviewDTO) {
        Review review = mappingService.toModel(reviewDTO);
        reviewRepository.save(review);
    }

    /**
     * Updates a review
     *
     * @param id the review's id
     * @param reviewDTO the review's DTO
     * @return the updated review's DTO
     * @throws EntityNotFoundException if id is not found
     */
    public ReviewDTO update(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Review not found with this id: " + id)
        );
        mappingService.toModel(reviewDTO, review);
        Review updatedReview = reviewRepository.save(review);
        return mappingService.toDto(updatedReview);
    }

    /**
     * Deletes a review by its id
     *
     * @param id the review's id
     * @throws EntityNotFoundException if id is not found
     */
    public void delete(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Review not found with this id: " + id)
        );
        reviewRepository.delete(review);
    }

    /**
     * Retrieves the reviews
     *
     * @return the Page of reviews
     */
    public Page<ReviewDTO> getAll(Pageable pageable) {
        return reviewRepository.findAll(pageable).map(
                review -> mappingService.toDto(review)
        );
    }

}

