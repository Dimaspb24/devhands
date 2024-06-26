package com.bogdanov.devhands.repository;

import com.bogdanov.devhands.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitleLike(String filter);

}
