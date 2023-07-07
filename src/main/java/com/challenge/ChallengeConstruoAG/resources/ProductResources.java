package com.challenge.ChallengeConstruoAG.resources;


import com.challenge.ChallengeConstruoAG.entities.Order;
import com.challenge.ChallengeConstruoAG.entities.Product;
import com.challenge.ChallengeConstruoAG.entities.User;
import com.challenge.ChallengeConstruoAG.services.OrderService;
import com.challenge.ChallengeConstruoAG.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductResources {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Product p = service.findById(id);
        return ResponseEntity.ok().body(p);
    }

    @PostMapping()
    public ResponseEntity<Product> insert(@RequestBody Product u) {
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
    public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product u) {
        u = service.update(id, u);
        return ResponseEntity.ok().body(u);
    }
}
