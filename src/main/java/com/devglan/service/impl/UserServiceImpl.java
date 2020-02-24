package com.devglan.service.impl;

import com.devglan.exception.user.UserNotFoundException;
import com.devglan.model.User;
import com.devglan.repo.UserRepo;
import com.devglan.service.UserService;
import com.devglan.utils.SearchUser;
import java.util.List;
import java.util.function.LongSupplier;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepo userRepo;
  @Autowired
  private MongoTemplate mongoTemplate;


  public Page<User> findAll() {
    Pageable pageable = PageRequest.of(0, 10);
    Query query = new Query()
        .with(pageable)
        .with(Sort.by(Order.asc("age")))
        .with(Sort.by(Order.asc("age"))).with(Sort.by(Order.asc("age")))
        .with(Sort.by(Order.asc("age"))).with(Sort.by(Order.asc("age")));
    LongSupplier longSupplier = new LongSupplier() {
      @Override
      public long getAsLong() {
        return 15;
      }
    };
    List<User> filteredPatients = mongoTemplate.find(query, User.class, "user");
    Page<User> userPage = PageableExecutionUtils.getPage(filteredPatients, pageable, longSupplier);
    return userPage;
  }

  @Override
  public void delete(ObjectId id) {
    findById(id);
    Query query = new Query();
    query.addCriteria(Criteria.where("id").is(id));
    mongoTemplate.remove(query, User.class);
  }


  @Override
  public User findByUserName(String username) {
    Query query = new Query();
    query.addCriteria(Criteria.where("username").is(username));
    return mongoTemplate.findOne(query, User.class);
  }


  @Override
  public User findById(ObjectId id) {
    Query query = new Query();
    query.addCriteria(Criteria.where("id").is(id));
    User user = mongoTemplate.findOne(query, User.class);
    if (user == null) {
      throw new UserNotFoundException("User with " + id + "is not found");
    }
    return user;
  }

  @Override
  public List<User> searchUser(SearchUser searchUser) {
    Criteria criteria = new Criteria();
    if (searchUser.getUsername() != null) {
      criteria = criteria.where("username").regex(searchUser.getUsername());
    }
    if (searchUser.getAge() != null) {
      criteria = criteria.where("age").gt(searchUser.getAge());
    }
    if (searchUser.getSalary() != null) {
      criteria = criteria.where("salary").gt(searchUser.getSalary());
    }

    Query query = new Query(criteria);
    if (searchUser.isSort()) {
      if (searchUser.getSortAge() != null) {
        query.with(Sort.by(Order.asc("age")));
      }
      if (searchUser.getSalary() != null) {
        query.with(Sort.by(Order.asc("salary")));
      }
      if (searchUser.getSortName() != null) {
        query.with(Sort.by(Order.asc("username")));
      }
    } else {
      if (searchUser.getSortAge() != null) {
        query.with(Sort.by(Order.desc("age")));
      }
      if (searchUser.getSalary() != null) {
        query.with(Sort.by(Order.desc("salary")));
      }
      if (searchUser.getSortName() != null) {
        query.with(Sort.by(Order.desc("username")));
      }
    }
    List<User> list = mongoTemplate.find(query, User.class);
    return list;
  }

  @Override
  public List<User> saveAll(List<User> list) {
    return userRepo.saveAll(list);
  }

  @Override
  public void deleteMutiple(List<ObjectId> list) {
    userRepo.deleteByIdIn(list);

  }


  @Override
  public User addNewUser(User user) {
    mongoTemplate.save(user);
    return user;
  }


}




