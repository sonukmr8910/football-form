package com.form.footballform.models;

import java.time.LocalDateTime;

public class Response<T> {
    private final LocalDateTime dateTime;
    private final int httpStatusCode;
    private final String message;
    private final String errorMessage;
    private final T data;

    public Response(ResponseBuilder<T> builder) {
        this.dateTime = builder.dateTime;
        this.httpStatusCode = builder.httpStatusCode;
        this.message = builder.message;
        this.errorMessage = builder.errorMessage;
        this.data = builder.data;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "dateTime=" + dateTime +
                ", httpStatus=" + httpStatusCode +
                ", message='" + message + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", data=" + data +
                '}';
    }

    public static class ResponseBuilder<T> {
        private final LocalDateTime dateTime;
        private int httpStatusCode;
        private String message;
        private String errorMessage;
        private T data;

        public ResponseBuilder() {
            this.dateTime = LocalDateTime.now();
        }

        public Response<T> build() {
            return new Response<>(this);
        }

        public ResponseBuilder<T> setHttpStatusCode(int httpStatusCode) {
            this.httpStatusCode = httpStatusCode;
            return this;
        }

        public ResponseBuilder<T> setMessage(String message) {
            this.message = message;
            return this;
        }

        public ResponseBuilder<T> setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public ResponseBuilder<T> setData(T data) {
            this.data = data;
            return this;
        }
    }
}
