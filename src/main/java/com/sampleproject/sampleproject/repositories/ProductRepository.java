package com.sampleproject.sampleproject.repositories;

import com.sampleproject.sampleproject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findFirstById(Long id);
}
