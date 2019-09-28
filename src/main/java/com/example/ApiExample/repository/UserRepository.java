package com.example.ApiExample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiExample.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
