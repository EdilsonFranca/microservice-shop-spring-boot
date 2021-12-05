package com.ms.shop.productController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestGetProductIdentifier {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void CaseFindTheProduct() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(get("/product/?productIdentifier=tv").
                        contentType("application/json").
                        headers(headers)).
                andExpect(status().isOk());
    }

    @Test
    public void CaseNotFindTheProduct() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(get("/product/teste").
                        contentType("application/json").
                        headers(headers)).
                andExpect(status().is(404));
    }
}
