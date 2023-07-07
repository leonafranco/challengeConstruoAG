package com.challenge.ChallengeConstruoAG.resources;


import com.challenge.ChallengeConstruoAG.entities.User;

import com.challenge.ChallengeConstruoAG.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserResources {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {

        User u = service.findById(id);
        return ResponseEntity.ok().body(u);
    }


    @PostMapping()
    public ResponseEntity<User> insert(@RequestBody User u) {
        u = service.insert(u);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(uri).body(u);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User u) {
        u = service.update(id, u);
        return ResponseEntity.ok().body(u);
    }
}
