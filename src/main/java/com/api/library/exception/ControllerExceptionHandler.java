package com.api.library.exception;

import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ProblemDetail handleObjectNotFoundException(LibraryException e) {
        return e.toProblemDetail();
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ProblemDetail handleBusinessRuleException(LibraryException e) {
        return e.toProblemDetail();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail handleAccessDeniedException(AccessDeniedException e) {

        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pd.setTitle("Access denied");
        pd.setDetail(e.getMessage());

        return pd;

    }

    @ExceptionHandler(BadCredentialsException.class)
    public ProblemDetail handleBadCredentialsException(BadCredentialsException e) {

        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pd.setTitle("Bad credentials");
        pd.setDetail(e.getMessage());

        return pd;

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDataIntegrityViolationException(DataIntegrityViolationException e) {

        var pd = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pd.setTitle("Data integrity violation");
        pd.setDetail(e.getMessage());

        return pd;

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pd.setTitle("Your request parameters didn't validate");
        pd.setDetail(Objects.requireNonNull(e.getFieldError()).getDefaultMessage());

        return pd;

    }

}
