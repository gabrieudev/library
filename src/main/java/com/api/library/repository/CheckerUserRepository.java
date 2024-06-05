package com.api.library.repository;

import com.api.library.model.CheckerUser;
import com.api.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CheckerUserRepository extends JpaRepository<CheckerUser, UUID> {
    Optional<CheckerUser> findByUser(User user);
}
