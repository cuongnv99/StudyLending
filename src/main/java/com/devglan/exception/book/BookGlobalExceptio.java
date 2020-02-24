package com.devglan.exception.book;

import com.devglan.dto.ApiError;
import com.devglan.exception.BusinessErrorCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BookGlobalExceptio {
  @ExceptionHandler(value = BookNotFoundException.class)
  public ResponseEntity<ApiError> bookNotFoundException(BookNotFoundException exception, WebRequest wr) {
    List<String> details = new ArrayList<>();
    details.add(exception.getMessage());
    ApiError apiError = new ApiError(new Date(),"Book Not Found", details,BusinessErrorCode.BookNotFound,
        exception.getHttpStatus(),wr.getDescription(false));
    return new ResponseEntity<ApiError>(apiError, exception.getHttpStatus());
  }

  @ExceptionHandler(value = DuplicateBookIdException.class)
  public ResponseEntity<ApiError> duplicateBookIdException(DuplicateBookIdException exception,WebRequest wr) {
    List<String> details = new ArrayList<>();
    details.add(exception.getMessage());
    ApiError apiError = new ApiError(new Date(),"Duplicate BookId Exception", details, exception.getBusinessErrorQueryCode(),
        exception.getHttpStatus(),wr.getDescription(false));
    return new ResponseEntity<ApiError>(apiError, exception.getHttpStatus());
  }

  @ExceptionHandler(value = DuplicateCodeException.class)
  public ResponseEntity<ApiError> duplicateCodeException(DuplicateCodeException exception,WebRequest wr) {
    List<String> details = new ArrayList<>();
    details.add(exception.getMessage());
    ApiError apiError = new ApiError(new Date(),"Duplicate Code Exception", details, exception.getBusinessErrorQueryCode(),
        exception.getHttpStatus(),wr.getDescription(false));
    return new ResponseEntity<ApiError>(apiError, exception.getHttpStatus());
  }

//  @Override
//  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//      HttpHeaders headers, HttpStatus status, WebRequest request) {
//    List<String> details = new ArrayList<>();
//    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
//      details.add(error.getDefaultMessage());
//    }
//    ApiError apiError = new ApiError(new Date(),"Validation Failed", details,request.getDescription(false));
//    apiError.setBusinessQueryErrorCode(BusinessErrorCode.InvalidParam);
//    apiError.setHttpStatus(HttpStatus.BAD_REQUEST);
//    return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);
//  }


}
