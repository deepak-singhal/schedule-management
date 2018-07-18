package com.gs.scm.exception;


import java.sql.Timestamp;

public class ExceptionResponseObject{
    String message;
    Integer errorCode;
    Timestamp timestamp;

    public String getMessage() {
        return message;
    }

    public ExceptionResponseObject setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public ExceptionResponseObject setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public ExceptionResponseObject setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}