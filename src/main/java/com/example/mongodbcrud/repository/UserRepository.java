package com.example.mongodbcrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodbcrud.model.User;

public interface UserRepository extends MongoRepository<User, Long>{

}
