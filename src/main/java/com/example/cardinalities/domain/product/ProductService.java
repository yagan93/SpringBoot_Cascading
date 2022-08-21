package com.example.cardinalities.domain.product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
}
