package com.devglan.controller;

import com.devglan.model.User;
import com.devglan.repo.UserRepo;
import com.devglan.service.UserService;
import com.devglan.utils.SearchUser;
import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepo userRepo;
  @Autowired
  private UserService userService;

  @PostMapping
  public User addNewUsers(@RequestBody User user) {
    user.setPassword("123456");
    return userService.addNewUser(user);
  }

  @PostMapping("/addmutil")
  public List<User> addmutilNewUsers(@RequestBody List<User> users) {
    for (User user:users){
      user.setPassword("123456");
    }
    return userService.saveAll(users);
  }

  @GetMapping
  public Page<User> listUser() {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  public User getOne(@PathVariable ObjectId id) {
    return userService.findById(id);
  }

  @PutMapping("/{id}")
  public User update(@PathVariable ObjectId id, @Valid @RequestBody User user) {
    User user1 = userService.findById(id);
    user.setId(id);
    BeanUtils.copyProperties(user, user1, "password", "username");
    return userRepo.save(user1);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable ObjectId id) {
    userService.findById(id);
    userService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/deleteAll")
  public ResponseEntity<Boolean> deleteMutil(@RequestBody List<ObjectId> list) {
    userService.deleteMutiple(list);
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @PostMapping("/search")
  public List<User> searchUser(@RequestBody SearchUser searchUser) {
    return userService.searchUser(searchUser);
  }

}
