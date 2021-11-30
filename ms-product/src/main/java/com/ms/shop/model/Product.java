package com.ms.shop.model;
import com.ms.shop.dto.ProductDTO;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Float  preco;
    private String descricao;
    private String productIdentifier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name="category_id",
            referencedColumnName = "id",
            insertable = true,
            updatable = true
    )
    private Category category;

    public static Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setNome(productDTO.getNome());
        product.setPreco(productDTO.getPreco());
        product.setDescricao(productDTO.getDescricao());
        product.setProductIdentifier(productDTO.getProductIdentifier());

        if (productDTO.getCategory() != null) {
            product.setCategory(Category.convert(productDTO.getCategory()));
        }
        return product;
    }
}