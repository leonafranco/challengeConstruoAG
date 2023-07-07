package com.challenge.ChallengeConstruoAG.resources;


import com.challenge.ChallengeConstruoAG.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1, "Leonardo Franco", "leonardomf96@gmail.com", "123456789");
        return ResponseEntity.ok().body(u);
    }
}
