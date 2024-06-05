package com.api.library.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class LoanDTO {

    private Long id;

    @NotNull
    private BookDTO book;

    @NotNull
    private UserDTO user;

    @NotNull
    private Date loanDate;

    @NotNull
    private Date returnDate;

}
