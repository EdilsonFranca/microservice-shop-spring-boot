package com.ms.shop.model;

import com.ms.shop.dto.ItemDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Item {
    private String productIdentifier;
    private Float price;

    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductIdentifier(itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());

        return item;
    }
}