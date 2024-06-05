package com.api.library.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

}
