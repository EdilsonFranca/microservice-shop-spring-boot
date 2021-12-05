package com.ms.shop.service;

import com.ms.shop.dto.UserDTO;
import com.ms.shop.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {

    @Value("${USER_API_URL}")
    private String userApiURL;

    public UserDTO getUserByCpf(String cpf, String key) {
        try {
            String url = userApiURL + cpf;

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
