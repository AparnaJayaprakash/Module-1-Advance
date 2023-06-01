package com.ust.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.rest.resource.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
