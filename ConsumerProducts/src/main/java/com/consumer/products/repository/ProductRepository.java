package com.consumer.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumer.products.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
