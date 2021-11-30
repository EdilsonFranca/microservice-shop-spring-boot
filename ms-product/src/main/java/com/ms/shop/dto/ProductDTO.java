package com.ms.shop.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ms.shop.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Float preco;
    @NotNull
    private CategoryDTO category;

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductIdentifier( product.getProductIdentifier());
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setDescricao(product.getDescricao());

        if (product.getCategory() != null) {
            productDTO.setCategory(CategoryDTO.convert(product.getCategory()));
        }

        return productDTO;
    }
}
