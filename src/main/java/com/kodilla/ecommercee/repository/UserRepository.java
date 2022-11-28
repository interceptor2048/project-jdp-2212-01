package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.User;
import org.springframework.data.repository.CrudRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long taskId);
=======

public interface UserRepository extends CrudRepository<User, Long> {
>>>>>>> c577fa7d24b92b4f44c054f13fa8565434fbc3c3
}
