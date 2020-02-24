package com.devglan.service;

import com.devglan.model.User;
import com.devglan.utils.SearchUser;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;

public interface UserService {

  User addNewUser(User user);

  Page<User> findAll();

  void delete(ObjectId id);

  User findByUserName(String username);

  User findById(ObjectId id);

  //  User update(User user);

  List<User> searchUser(SearchUser searchUser);

  List<User> saveAll(List<User> list);

  void deleteMutiple(List<ObjectId> list);

}
