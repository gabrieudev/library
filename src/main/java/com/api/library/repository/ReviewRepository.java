package com.api.library.repository;

import com.api.library.model.Book;
import com.api.library.model.Review;
import com.api.library.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByUser(User user, Pageable pageable);
    Page<Review> findByBook(Book book, Pageable pageable);
}
