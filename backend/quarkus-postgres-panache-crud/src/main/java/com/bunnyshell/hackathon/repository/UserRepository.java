package com.bunnyshell.hackathon.repository;

import com.bunnyshell.hackathon.model.User;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
  public User findById(Long id) {
    return find("id", id).firstResult();
  }
}