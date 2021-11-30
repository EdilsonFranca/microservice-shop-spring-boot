package com.ms.shop.converter;

import com.ms.shop.dto.ItemDTO;
import com.ms.shop.dto.ShopDTO;
import com.ms.shop.model.Shop;

import java.util.stream.Collectors;

public class DTOConverter {

    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setDate(shop.getDate());

        shopDTO.setItems(shop
                .getItems()
                .stream()
                .map(ItemDTO::convert)
                .collect(Collectors.toList()));

        return shopDTO;
    }
}
