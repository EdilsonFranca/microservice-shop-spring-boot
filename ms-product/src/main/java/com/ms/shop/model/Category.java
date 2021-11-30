package com.ms.shop.model;

import javax.persistence.*;

import com.ms.shop.dto.CategoryDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public static Category convert(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setNome(categoryDTO.getNome());
        return category;
    }
}
