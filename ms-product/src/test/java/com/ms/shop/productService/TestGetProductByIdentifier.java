package com.ms.shop.productService;

import com.ms.shop.dto.CategoryDTO;
import com.ms.shop.dto.ProductDTO;
import com.ms.shop.exception.advice.ProductControllerAdvice;
import com.ms.shop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestGetProductByIdentifier {

    @Mock
    private ProductService productService;

    @Test
    public void CaseFindByProductIdentifier() throws ProductControllerAdvice {
        ProductDTO product = createObject();
        Mockito.when(productService.findByProductIdentifier("tv")).thenReturn(product);
        ProductDTO productDto = productService.findByProductIdentifier("tv");
        assertTrue(productDto.getProductIdentifier() != null);
    }

    private ProductDTO createObject(){
        ProductDTO product   = new ProductDTO();
        CategoryDTO category = new CategoryDTO(1L, "Eletrônico");

        product.setProductIdentifier("tv");
        product.setNome("TV");
        product.setPreco(1000F);
        product.setDescricao("Uma TV");
        product.setCategory(category);
        return product;
    }
}
