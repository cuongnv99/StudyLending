package com.devglan.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchUser {

  private String username;
  private Long salary;
  private Integer age;
  private boolean sort;
  private String sortName;
  private Long sortSalary;
  private Integer sortAge;

}
