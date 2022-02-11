package com.mudzingwa.sec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mudzingwa.sec.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
