package com.example.productservice.service;

import com.example.productservice.dto.CreateProductRequest;
import com.example.productservice.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void createProduct(CreateProductRequest createProductRequest);

    List<ProductDTO> getAllproducts();
}
