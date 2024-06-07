package com.api.library.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class ReviewDTO {

    private Long id;

    @NotNull
    private BookDTO book;

    @NotNull
    private UserDTO user;

    @NotNull
    @Size(min = 0, max = 5)
    private double rating;

    private String comment;

    @NotNull
    private Date reviewDate;

}
