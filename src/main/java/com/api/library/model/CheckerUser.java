package com.api.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "tb_checker_users")
public class CheckerUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "checker_user_id")
    private UUID id;

    @Column(name = "expiresAt", nullable = false)
    private Instant expiresAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
