package com.api.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class BookDTO {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String isbn;

    @NotNull
    private AuthorDTO author;

    @NotNull
    private CategoryDTO category;

    @NotNull
    private Date publishedDate;

}
