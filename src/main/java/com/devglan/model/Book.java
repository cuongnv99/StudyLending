package com.devglan.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "book")
public class Book {

  @Id
  Integer uid;

  @Field
  String code;

  @Field
  String name;

  @Field
  String description;

  @Field
  String category;

  @Field
  String publisher;

  @Field
  String createUser;

  @Field
  Date createDate;

  @Field
  String updateUser;

  @Field
  Date updateDate;

  @Field
  @DBRef(db = "author")
  private List<Author> author;
}
