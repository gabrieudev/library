package com.api.library.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String biography;

}
