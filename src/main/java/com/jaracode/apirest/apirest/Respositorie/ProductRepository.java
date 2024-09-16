package com.jaracode.apirest.apirest.Respositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaracode.apirest.apirest.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
