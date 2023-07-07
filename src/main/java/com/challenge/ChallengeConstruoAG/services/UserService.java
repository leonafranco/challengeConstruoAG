package com.challenge.ChallengeConstruoAG.services;

import com.challenge.ChallengeConstruoAG.entities.User;
import com.challenge.ChallengeConstruoAG.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> u = repository.findById(id);
        return u.get();
    }

}
