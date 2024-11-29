package com.example.semestralna_praca_vaii.facade.dto.error;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorDto {

    private String message;

    private int statusCode;

    private String timeStamp;

    private List<String> errors;

    public ErrorDto(String message, int statusCode, List<String> errors) {
        this.message = message;
        this.statusCode = statusCode;
        this.timeStamp = LocalDateTime.now().toString();
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public java.util.List<String> getErrors() {
        return errors;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
                "message='" + message + '\'' +
                ", statusCode=" + statusCode +
                ", timeStamp='" + timeStamp + '\'' +
                ", errors=" + errors +
                '}';
    }
}
