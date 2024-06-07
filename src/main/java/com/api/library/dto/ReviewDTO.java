package com.api.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
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
    @JsonIgnore
    private UserDTO user;

    @NotNull
    @Max(value = 5)
    private int rating;

    private String comment;

    @NotNull
    private Date reviewDate;

}
