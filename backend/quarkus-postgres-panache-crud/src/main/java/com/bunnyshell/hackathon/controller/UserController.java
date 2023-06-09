package com.bunnyshell.hackathon.controller;


import java.util.List;

import com.bunnyshell.hackathon.model.User;
import com.bunnyshell.hackathon.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/api/users")
public class UserController {

  private final UserRepository userRepository;

  @Inject
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GET
  public List<User> getUsers() {
    return userRepository.listAll();
  }


  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public User getUser
      (@PathParam("id") Long id) {
    return userRepository.findById(id);
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateUser
      (@PathParam("id") Long id, User user) {

    User entity = userRepository.findById(id);
    if (entity == null) {
      throw new NotFoundException();
    }
    // map all fields from the person parameter to the existing entity
    entity.setEmailId(user.getEmailId());
    entity.setFirstName(user.getFirstName());
    entity.setLastName(user.getLastName());
    userRepository.persist(entity);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  @POST
  @Transactional
  public Response addUser(User user) {
    userRepository.persist(user);
    return Response.status(Response.Status.CREATED).build();
  }

  @DELETE
  @Path("/{id}")
  @Transactional
  public void deleteUser(@PathParam("id") Long id) {
    User user = userRepository.findById(id);
    userRepository.delete(user);
  }
}