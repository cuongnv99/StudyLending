package com.devglan.exception.user;

import com.devglan.exception.BusinessErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class UserBusinessException extends RuntimeException {
  private static final long serialVersionUID = 2237164598124433306L;
  protected BusinessErrorCode businessErrorQueryCode;
  protected HttpStatus httpStatus;

  public UserBusinessException(String message, BusinessErrorCode businessErrorQueryCode,
      HttpStatus httpStatus) {
    super(message);
    this.businessErrorQueryCode = businessErrorQueryCode;
    this.httpStatus = httpStatus;
  }

  public UserBusinessException(String message) {
    super(message);
    this.businessErrorQueryCode = BusinessErrorCode.UserNotFound;
    this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
  }
}
