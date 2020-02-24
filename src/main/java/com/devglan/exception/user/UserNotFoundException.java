package com.devglan.exception.user;

import com.devglan.exception.BusinessErrorCode;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserBusinessException {
  private static final long serialVersionUID = -3520685461510855926L;

  public UserNotFoundException(String message) {
    super(message, BusinessErrorCode.UserNotFound, HttpStatus.NOT_FOUND);
  }
}
