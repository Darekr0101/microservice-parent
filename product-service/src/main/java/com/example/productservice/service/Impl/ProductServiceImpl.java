package com.example.productservice.service.Impl;

import com.example.productservice.dto.CreateProductRequest;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void createProduct(CreateProductRequest createProductRequest) {
        Product product =  Product.builder()
                .name(createProductRequest.getName())
                .price(createProductRequest.getPrice())
                .description(createProductRequest.getDescription())
                .build();
         productRepository.save(product);
         log.info("Product {} is saved",product.getId());
    }

    @Override
    public List<ProductDTO> getAllproducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product p : products){
            ProductDTO a = new ProductDTO();
            BeanUtils.copyProperties(p,a);
            productDTOS.add(a);
        }
        return  productDTOS;
    }


}
