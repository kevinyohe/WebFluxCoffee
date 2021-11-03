package com.example.pluralsitewebflux;

import com.example.pluralsitewebflux.model.Product;
import com.example.pluralsitewebflux.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class PluralsiteWebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(PluralsiteWebFluxApplication.class, args);
    }



    @Bean
    CommandLineRunner init(ProductRepository repository){
        return args -> {
            Flux<Product> productFlux = Flux.just(
                    new Product(null, "Big Latte", 2.99),
                    new Product(null, "Big decaf", 2.99),
                    new Product(null, "Green Tea", 1.99),
                    new Product(null, "Mocha Latte", 2.89))
                    .flatMap(repository::save);
            productFlux
                    .thenMany(repository.findAll())
                    .subscribe(System.out::println);
        };
    }
}
