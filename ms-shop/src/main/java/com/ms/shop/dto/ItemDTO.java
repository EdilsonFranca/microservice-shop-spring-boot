package com.ms.shop.dto;

import com.ms.shop.model.Item;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ItemDTO {
    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float price;

    public static ItemDTO convert(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }
}