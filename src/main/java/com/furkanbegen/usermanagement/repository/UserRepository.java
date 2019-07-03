package com.furkanbegen.usermanagement.repository;

import com.furkanbegen.usermanagement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {


}
