package com.devglan;

import com.devglan.model.User;
import com.devglan.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner init(UserRepo userRepo) {
    return args -> {
      User user1 = new User();
      user1.setFirstName("cuong");
      user1.setLastName("cuong");
      user1.setSalary(12345);
      user1.setAge(23);
      user1.setUsername("cuong");
      user1.setPassword("cuong");
      userRepo.save(user1);
    };
  }

}
