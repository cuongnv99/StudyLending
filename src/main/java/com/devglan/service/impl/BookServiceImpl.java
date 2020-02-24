package com.devglan.service.impl;

import com.devglan.exception.book.BookNotFoundException;
import com.devglan.model.Book;
import com.devglan.repo.BookRepo;
import com.devglan.service.BookService;
import com.devglan.utils.ValidParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BookServiceImpl implements BookService {

  @Autowired
  BookRepo bookRepo;

  @Override
  public List<Book> getAllBook() {
    List<Book> outPut = bookRepo.findAll();
//    outPut = bookRepo.findAll();
    if (outPut.isEmpty()) {
      throw new BookNotFoundException("Don't have any book");
    }
    return outPut;
  }

  @Override
  public Book findByUid(Integer uid) {
    ValidParam.validBookId(uid);
//    Book outPut = null;
    Book outPut = bookRepo.findByUid(uid);
    if (outPut == null) {
      throw new BookNotFoundException("Book with id is " + uid + " Not Found");
    }
    return outPut;
  }

  @Override
  public Book findByCode(String code) {
    Book outPut = null;
    outPut = bookRepo.findByCode(code);
    if (outPut == null) {
      throw new BookNotFoundException("Book with code is " + code + " Not Found");
    }
    return outPut;
  }

  @Override
  public List<Book> findByName(String name) {
    List<Book> outPuts = null;
    outPuts = (List<Book>) bookRepo.findByName(name);
    if (outPuts.isEmpty()) {
      throw new BookNotFoundException("Book with name is " + name + " Not Found");
    }
    return outPuts;
  }

  @Override
  public List<Book> findByCategory(String category) {
    List<Book> outPuts = null;
    outPuts = (List<Book>) bookRepo.findByCategory(category);
    if (outPuts.isEmpty()) {
      throw new BookNotFoundException("Book with category is " + category + " Not Found");
    }
    return outPuts;
  }

  @Override
  public List<Book> findByAuthor(String author) {
    List<Book> outPuts = null;
    outPuts = (List<Book>) bookRepo.findByAuthor(author);
    if (outPuts.isEmpty()) {
      throw new BookNotFoundException("Book with author is " + author + " Not Found");
    }
    return outPuts;
  }


  @Override
  public Book createBook(Book book) {
//    ValidParam.checkUniqueBookId(bookRepo.getListUid(), book.getUid());
//    ValidParam.checkUniqueCode(bookRepo.getListCode(), book.getCode());
//    ValidParam.validBookId(book.getUid());
    bookRepo.save(book);
    return book;
  }

  @Override
  public Book updateBook(Book book) {
    Book outPut = bookRepo.findByUid(book.getUid());
    if (outPut == null) {
      throw new BookNotFoundException("Book with id is " + book.getUid() + " Not Found");
    }
    List<String> outPuts = bookRepo.getListCode();
    outPuts.remove(book.getCode());
    ValidParam.checkUniqueCode(outPuts, book.getCode());
    return bookRepo.save(book);
  }

  @Override
  public Book deleteBook(Integer uid) {
    Book outPut = bookRepo.findByUid(uid);
    if (outPut == null) {
      throw new BookNotFoundException("Book with id is " + uid + " Not Found");
    }
    bookRepo.delete(outPut);
    return outPut;
  }
}
