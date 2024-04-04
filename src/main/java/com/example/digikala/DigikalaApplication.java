package com.example.digikala;

import com.example.digikala.entity.Category;
import com.example.digikala.entity.Product;
import com.example.digikala.repository.CategoryRepository;
import com.example.digikala.repository.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Locale;
import java.util.Random;

@SpringBootApplication
@EnableJpaAuditing
public class DigikalaApplication implements ApplicationRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DigikalaApplication(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DigikalaApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Faker faker = new Faker(new Locale("fa_IR"));

        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setName(faker.book().title());
            product.setPrice(new Random().nextDouble(10000, 99999));
            product.setInStock(true);

            Category category = new Category();
            category.setTitle(faker.book().genre());

            categoryRepository.saveAndFlush(category);

            product.setCategory(category);
            productRepository.saveAndFlush(product);

        }


    }
}
