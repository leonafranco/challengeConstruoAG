package com.challenge.ChallengeConstruoAG.services;

import com.challenge.ChallengeConstruoAG.entities.Product;
import com.challenge.ChallengeConstruoAG.entities.User;
import com.challenge.ChallengeConstruoAG.repositories.ProductRepository;
import com.challenge.ChallengeConstruoAG.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Integer id) {
        Optional<Product> p = repository.findById(id);
        return p.get();
    }

    public Product insert(Product u) {
        return repository.save(u);
    }

    public Product update(Integer id, Product u){
        try {
            Product product = repository.getReferenceById(id);
            product.setName(u.getName());
            product.setPrice(u.getPrice());
            product.setType(u.getType());
            repository.save(product);
            return product;
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
