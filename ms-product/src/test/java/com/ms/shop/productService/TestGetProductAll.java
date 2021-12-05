package com.ms.shop.productService;

import com.ms.shop.dto.CategoryDTO;
import com.ms.shop.dto.ProductDTO;
import com.ms.shop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestGetProductAll {
    @Mock
    private ProductService productService;

    @Test
    public void CaseListWithTwoRecord() throws Exception{
        List<ProductDTO> products = createListWithTwoRecord();
        Mockito.when(productService.getAll()).thenReturn(products);
        List<ProductDTO> listTest = productService.getAll();
        assertTrue(listTest.size() == 2);
    }

    private List<ProductDTO> createListWithTwoRecord(){
        ProductDTO product1   = new ProductDTO();
        ProductDTO product2   = new ProductDTO();

        CategoryDTO category = new CategoryDTO(1L, "Eletrônico");

        product1.setProductIdentifier("tv");
        product1.setNome("TV");
        product1.setPreco(1000F);
        product1.setDescricao("Uma TV");
        product1.setCategory(category);

        product2.setProductIdentifier("video-game");
        product2.setNome("Video Game");
        product2.setPreco(1200F);
        product2.setDescricao("Video Game");
        product2.setCategory(category);

        List<ProductDTO> listProduct = new ArrayList<>();
        listProduct.add(product1);
        listProduct.add(product2);
        return listProduct;
    }
}
