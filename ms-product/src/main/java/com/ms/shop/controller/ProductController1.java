package com.ms.shop.controller;

import com.ms.shop.dto.ProductDTO;
import com.ms.shop.exception.advice.ProductControllerAdvice;
import com.ms.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController1 {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }

    @GetMapping("/product/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {
        return productService.getProductByCategoryId(categoryId);
    }

    @GetMapping("/product/{productIdentifier}")
    ProductDTO findById(@PathVariable String productIdentifier) throws ProductControllerAdvice {
        return productService.findByProductIdentifier(productIdentifier);
    }

    @PostMapping("/product")
    ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/product/{id}")
    ProductDTO delete(@PathVariable Long id) throws ProductControllerAdvice {
        return productService.delete(id);
    }
}
