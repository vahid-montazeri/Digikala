package com.example.digikala.repository;

import com.example.digikala.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    List<Product> findAllByInStock(boolean inStock);

    @Query(value = "select * from tbl_product where in_stock = :inStock", nativeQuery = true)
    List<Product> findAllByInStock(@Param("inStock") boolean inStock);

}
