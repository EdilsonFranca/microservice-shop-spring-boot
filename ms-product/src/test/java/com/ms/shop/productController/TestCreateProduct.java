package com.ms.shop.productController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.shop.dto.CategoryDTO;
import com.ms.shop.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestCreateProduct {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void CaseCreateProduct() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ProductDTO obj = createObject();
        mockMvc.perform(post("/product").
                        contentType("application/json").
                        content(objectMapper.writeValueAsString(obj)).
                        headers(headers)).
                andExpect(status().isOk());
    }

    private ProductDTO createObject(){
        ProductDTO product   = new ProductDTO();
        CategoryDTO category = new CategoryDTO(1L, "Eletrônico");

        product.setProductIdentifier("tv teste");
        product.setNome("TV");
        product.setPreco(1000F);
        product.setDescricao("Uma TV de teste");
        product.setCategory(category);
        return product;
    }
}
