package com.devglan.controller;

import com.devglan.model.Book;
import com.devglan.service.BookService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

  @Autowired
  BookService bookService;

  @PostMapping(value = "/create")
  public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
    Book outPut = bookService.createBook(book);
    return new ResponseEntity<>(outPut, HttpStatus.CREATED);
  }

  @PutMapping(value = "/update")
  public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book) {
    Book outPut = bookService.updateBook(book);
    return new ResponseEntity<>(outPut, HttpStatus.OK);
  }

  @DeleteMapping(value = "/delete/{uid}")
  public ResponseEntity<Book> deleteBook(@PathVariable("uid") Integer uid) {
    Book outPut = bookService.deleteBook(uid);
    return new ResponseEntity<>(outPut, HttpStatus.OK);
  }

  @GetMapping(value = "")
  public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> books = bookService.getAllBook();
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  @GetMapping(value = "/id/{uid}")
  public ResponseEntity<Book> findBookById(@PathVariable("uid") Integer uid) {
    Book book = bookService.findByUid(uid);
    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  @GetMapping(value = "/code/{code}")
  public ResponseEntity<Book> findBookByCode(@PathVariable("code") String code) {
    Book book = bookService.findByCode(code);
    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  @GetMapping(value = "/name/{name}")
  public ResponseEntity<List<Book>> findBookByName(@PathVariable("name") String name) {
    List<Book> books = bookService.findByName(name);
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  @GetMapping(value = "/category/{category}")
  public ResponseEntity<List<Book>> findBookByCategory(@PathVariable("category") String category) {
    List<Book> books = bookService.findByCategory(category);
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  @GetMapping(value = "/author/{author}")
  public ResponseEntity<List<Book>> findBookByAuthor(@PathVariable("author") String author) {
    List<Book> books = bookService.findByAuthor(author);
    return new ResponseEntity<>(books, HttpStatus.OK);
  }
}
