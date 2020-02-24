package com.devglan.service;

import com.devglan.model.Book;
import java.util.List;

public interface BookService {

  List<Book> getAllBook();

  Book findByUid(Integer uid);

  Book findByCode(String code);

  List<Book> findByName(String name);

  List<Book> findByCategory(String category);

  List<Book> findByAuthor(String author);


  Book createBook(Book book);

  Book updateBook(Book book);

  Book deleteBook(Integer uid);
}
