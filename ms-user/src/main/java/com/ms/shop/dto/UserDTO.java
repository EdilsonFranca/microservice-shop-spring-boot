package com.ms.shop.dto;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import com.ms.shop.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    private String endereco;
    @NotBlank
    private String email;
    private String telefone;
    private Date dataCadastro;
    private String key;

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        userDTO.setKey(user.getKey());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        return userDTO;
    }
}
