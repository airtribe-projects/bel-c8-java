package com.airtribe.SpringBootApplication.error;

public class LearnerNotFoundException extends Exception {
  public LearnerNotFoundException() {
    super();
  }

  public LearnerNotFoundException(String message) {
    super(message);
  }

  public LearnerNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public LearnerNotFoundException(Throwable cause) {
    super(cause);
  }

  protected LearnerNotFoundException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
