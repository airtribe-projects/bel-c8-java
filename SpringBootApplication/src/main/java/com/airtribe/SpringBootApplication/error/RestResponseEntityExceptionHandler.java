package com.airtribe.SpringBootApplication.error;

import com.airtribe.SpringBootApplication.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(LearnerNotFoundException.class)
  @ResponseBody
  public ErrorMessage handleResourceNotFound(LearnerNotFoundException ex) {
    return new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage(), ex.getStackTrace());
  }
}
