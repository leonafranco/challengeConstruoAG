package com.challenge.ChallengeConstruoAG.resources;


import com.challenge.ChallengeConstruoAG.entities.Order;
import com.challenge.ChallengeConstruoAG.entities.User;
import com.challenge.ChallengeConstruoAG.services.OrderService;
import com.challenge.ChallengeConstruoAG.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderResources {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id) {
        Order o = service.findById(id);
        return ResponseEntity.ok().body(o);
    }

    @PostMapping()
    public ResponseEntity<Order> insert(@RequestBody Order u) {
        u = service.insert(u);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(uri).body(u);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Order> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
