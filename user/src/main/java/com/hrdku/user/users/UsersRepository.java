package com.hrdku.user.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jakarta.websocket.server.PathParam;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    @Query("SELECT user FROM Users user WHERE (user.name like %:name% or user.email like %:name%)")
    public Iterable<Users> findUsersByName(@PathParam("name") String name);
}
