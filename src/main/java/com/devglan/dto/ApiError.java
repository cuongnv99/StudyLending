package com.devglan.dto;

import com.devglan.exception.BusinessErrorCode;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
  private Date timestamp;
  String message;
  List<String> details;
  BusinessErrorCode businessQueryErrorCode;
  HttpStatus httpStatus;
  String path;

  public ApiError(Date timestamp,String message, List<String> details,String path) {
    super();
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
    this.path = path;
  }
}
