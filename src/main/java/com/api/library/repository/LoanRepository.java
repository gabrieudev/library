package com.api.library.repository;

import com.api.library.model.Loan;
import com.api.library.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Page<Loan> findByUser(User user, Pageable pageable);
}
