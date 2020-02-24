package com.devglan.utils;

import com.devglan.exception.book.DuplicateBookIdException;
import com.devglan.exception.book.DuplicateCodeException;
import com.devglan.exception.book.ValidParamException;
import java.util.List;

public class ValidParam {

  public static void checkUniqueCode(List<String> codes, String code) {
    if (codes.contains(code)) {
      throw new DuplicateCodeException("Code should be unique");
    }
  }

  public static void checkUniqueBookId(List<Integer> bookIds, int bookId) {
    if (bookIds.contains(bookId)) {
      throw new DuplicateBookIdException("BookId should be unique");
    }
  }

  public static void validBookId(int bookId) {
    if (bookId < 1) {
      throw new ValidParamException("Book id should be greater than 1");
    }
  }
}
