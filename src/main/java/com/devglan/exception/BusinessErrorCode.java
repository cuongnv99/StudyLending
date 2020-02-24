package com.devglan.exception;

public enum BusinessErrorCode {
  UserNotFound(40404),
  BookNotFound(40405),
  UsserCanNotConverter(90909),
  InvalidParam(40000),
  InteralServer(500000),
  DuplicateCode(500001),
  DuplicateBookId(500002);

  private final int id;

  BusinessErrorCode(int id) {
    this.id = id;
  }

  public int getValue() {
    return id;
  }
}
