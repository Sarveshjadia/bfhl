package com.bfhl.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {
    @JsonProperty("is_success")
    private boolean isSuccess;

    @JsonProperty("error_message")
    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.isSuccess = false;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
