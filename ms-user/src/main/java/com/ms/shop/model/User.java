package com.ms.shop.model;
import javax.persistence.*;
import java.util.Date;

import com.ms.shop.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    @Column(name = "key_app")
    private String key;
    private Date dataCadastro;

    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setNome(userDTO.getNome());
        user.setEndereco(userDTO.getEndereco());
        user.setCpf(userDTO.getCpf());
        user.setKey(userDTO.getKey());
        user.setEmail(userDTO.getEmail());
        user.setTelefone(userDTO.getTelefone());
        user.setDataCadastro(userDTO.getDataCadastro());
        return user;
    }
}