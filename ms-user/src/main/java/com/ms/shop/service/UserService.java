package com.ms.shop.service;

import com.ms.shop.converter.DTOConverter;
import com.ms.shop.dto.UserDTO;
import com.ms.shop.exception.UserNotFoundException;
import com.ms.shop.exception.advice.UserControllerAdvice;
import com.ms.shop.model.User;
import com.ms.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        return userRepository.findAll()
                             .stream()
                             .map(UserDTO::convert)
                             .collect(Collectors.toList());
    }

    public UserDTO findById(long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return UserDTO.convert(user.get());
        }
         throw new UserNotFoundException();
    }

    public UserDTO save(UserDTO userDTO) {
        userDTO.setKey(UUID.randomUUID().toString());
        userDTO.setDataCadastro(new Date());
        User user = userRepository.save(User.convert(userDTO));
        return DTOConverter.convert(user);
    }

    public UserDTO delete(long userId) throws UserNotFoundException{
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        throw new UserNotFoundException();
    }

    public UserDTO findByCpf(String cpf, String key) throws UserNotFoundException{
        User user = userRepository.findByCpfAndKey(cpf, key);
        if (user != null) {
            return UserDTO.convert(user);
        }
        throw new UserNotFoundException();
    }

    public List<UserDTO> queryByName(String name) {
        return userRepository.queryByNomeLike(name)
                             .stream()
                             .map(UserDTO::convert)
                             .collect(Collectors.toList());
    }
}
