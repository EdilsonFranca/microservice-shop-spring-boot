package com.ms.shop.service;

import com.ms.shop.dto.UserDTO;
import com.ms.shop.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {
    public UserDTO getUserByCpf(String cpf, String key) {
        try {
            String url = "http://localhost:8080/user/cpf/" + cpf;

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            builder.queryParam("key", key);

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(builder.toUriString());
            ResponseEntity<UserDTO> response = restTemplate.getForEntity(builder.toUriString(), UserDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException();
        }
    }
}
