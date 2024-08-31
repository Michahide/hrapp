package com.hrdku.user.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Iterable<Users> findAll() {
        return usersRepository.findAll();
    }

    public Users findOne(int id) {
        return usersRepository.findById(id).get();
    }

    public Iterable<Users> findByName(String name){
        return usersRepository.findUsersByName(name);
    }

    public Users create(Users users) {
        return usersRepository.save(users);
    }

    public Users update(Users users) {
        Users result = findOne(users.getId());

        result.setName(users.getName());
        result.setEmail(users.getEmail());
        result.setPassword(users.getPassword());
        result.setRole(users.getRole());
        result.setStatus(users.getStatus());

        return result;
    }

    public void removeOne(int id) {
        usersRepository.deleteById(id);
    }
}
