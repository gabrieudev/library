package com.api.library.repository;

import com.api.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(
            value = "SELECT b " +
                    "FROM Book b " +
                    "WHERE b.author.name = :name"
    )
    Page<Book> findAllByAuthor(@Param("name") String name, Pageable pageable);

    @Query(
            value = "SELECT b.* " +
                    "FROM tb_books b " +
                    "JOIN tb_books_categories bc " +
                    "ON b.id = bc.book_id " +
                    "WHERE bc.category_id = :categoryId;",
            nativeQuery = true
    )
    Page<Book> findAllByCategory(@Param("categoryId") Long categoryId, Pageable pageable);

    @Query(
            value = "SELECT b.* " +
                    "FROM tb_books b " +
                    "JOIN tb_reviews r " +
                    "ON b.id = r.book_id " +
                    "GROUP BY b.id " +
                    "ORDER BY AVG(r.rating) DESC",
            nativeQuery = true
    )
    Page<Book> findBestRated(Pageable pageable);

    @Query(
            value = "SELECT b.* " +
                    "FROM tb_books b " +
                    "JOIN tb_loans l " +
                    "ON b.id = l.book_id " +
                    "GROUP BY b.id " +
                    "ORDER BY COUNT(*) DESC",
            nativeQuery = true
    )
    Page<Book> findMostBorrowed(Pageable pageable);

}
