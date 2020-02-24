package com.devglan.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document(collection = "author")
@NoArgsConstructor
@AllArgsConstructor
public class Author {

  @Id
  @GeneratedValue
  private Integer id;

  @Field
  private String name;

}
