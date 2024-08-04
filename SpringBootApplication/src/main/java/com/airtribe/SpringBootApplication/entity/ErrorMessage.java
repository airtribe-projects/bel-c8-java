package com.airtribe.SpringBootApplication.entity;

import org.springframework.http.HttpStatus;


public class ErrorMessage {
  private String message;

  private HttpStatus httpStatus;

  private StackTraceElement[] stackTrace;

  public ErrorMessage(HttpStatus httpStatus, String message, StackTraceElement[] stackTrace) {
    this.httpStatus = httpStatus;
    this.message = message;
    this.stackTrace = stackTrace;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }
}
