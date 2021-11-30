package com.ms.shop.controller;

import com.ms.shop.dto.UserDTO;
import com.ms.shop.exception.advice.UserControllerAdvice;
import com.ms.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public UserDTO findById(@PathVariable Long id) throws UserControllerAdvice {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public UserDTO newUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/user/cpf/{cpf}")
    UserDTO findByCpf(
            @RequestParam(name="key", required=true) String key,
            @PathVariable String cpf) throws UserControllerAdvice {
        return userService.findByCpf(cpf, key);
    }

    @DeleteMapping("/user/{id}")
    public UserDTO delete(@PathVariable Long id) throws UserControllerAdvice {
        return userService.delete(id);
    }

    @GetMapping("/user/search")
    public List<UserDTO> queryByName(@RequestParam(name="nome", required = true) String nome) {
        return userService.queryByName(nome);
    }
}
