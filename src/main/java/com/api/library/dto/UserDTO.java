package com.api.library.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDTO {

    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private Set<String> roles;

    private Instant createdAt;

    private Instant updatedAt;

    private boolean isChecked;

}
