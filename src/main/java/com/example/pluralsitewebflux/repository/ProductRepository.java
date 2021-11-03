package com.example.pluralsitewebflux.repository;

import com.example.pluralsitewebflux.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
