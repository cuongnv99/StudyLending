package com.devglan.repo;

import com.devglan.model.User;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, Integer> {

  User findByUsername(String username);
  void deleteByIdIn(List<ObjectId> list);

}

