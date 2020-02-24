package com.devglan.repo;

import com.devglan.model.Book;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends MongoRepository<Book, Integer> {

  Book findByUid(Integer id);

  Book findByCode(String code);

  List<Book> findByName(String name);

  List<Book> findByCategory(String category);

  List<Book> findByAuthor(String author);

  List<Book> findAll();

  @Query("SELECT b.uid FROM Book b")
  List<Integer> getListUid();

  @Query("SELECT b.code FROM Book b")
  List<String> getListCode();
}
