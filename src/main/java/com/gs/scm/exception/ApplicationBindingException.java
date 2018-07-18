package com.gs.scm.exception;

import org.springframework.validation.FieldError;

import java.util.List;

public class ApplicationBindingException extends Exception {

    ExceptionConstant exceptionConstant;
    List<FieldError> fieldErrors;

    public ApplicationBindingException() {
        super();
    }

    public ApplicationBindingException(String message) {
        super(message);
    }

    public ApplicationBindingException(ExceptionConstant exceptionConstant) {
        this.exceptionConstant = exceptionConstant;
    }

    public ApplicationBindingException(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public ExceptionConstant getExceptionConstant() {
        return exceptionConstant;
    }

    public void setExceptionConstant(ExceptionConstant exceptionConstant) {
        this.exceptionConstant = exceptionConstant;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
