package com.example.demo.repository;

import com.example.demo.model.product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<product,Integer> {
}
