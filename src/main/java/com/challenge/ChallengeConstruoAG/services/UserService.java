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
    public User insert(User u) {
        return repository.save(u);
    }

    public User update(Integer id, User u){
        try {
            User user = repository.getReferenceById(id);
            user.setName(u.getName());
            user.setEmail(u.getEmail());
            user.setPassword(u.getPassword());
            repository.save(user);
            return user;
        }catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
