package com.community.productcommunity;

import com.community.productcommunity.model.Product;
import com.community.productcommunity.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProductCommunityBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCommunityBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedProducts(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() == 0) {
                productRepository.saveAll(List.of(
                        new Product("Product A", "PROD_A"),
                        new Product("Product B", "PROD_B"),
                        new Product("Product C", "PROD_C")
                ));
                System.out.println("Seeded default products");
            }
        };
    }
}
