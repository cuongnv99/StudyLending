package com.devglan.exception.user;

import com.devglan.dto.ApiError;
import com.devglan.exception.BusinessErrorCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ApiError> userIdCannotConverter(MethodArgumentTypeMismatchException exception ,  WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add("Failed to convert value of type java.lang.String to required type org.bson.types.ObjectId");
    ApiError apiError = new ApiError(new Date(),"UserId canNot conveter ", details, BusinessErrorCode.UsserCanNotConverter,
        HttpStatus.BAD_REQUEST,request.getDescription(false));
    return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
  }


  @ExceptionHandler(value = UserNotFoundException.class)
  public ResponseEntity<ApiError> userNotFoundException(UserNotFoundException exception , WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(exception.getMessage());
    ApiError apiError = new ApiError(new Date(),"user not found ", details, BusinessErrorCode.UserNotFound,
        HttpStatus.NOT_FOUND,request.getDescription(false));
    return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
  }


}
