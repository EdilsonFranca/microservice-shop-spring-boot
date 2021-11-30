package com.ms.shop.dto;
import com.ms.shop.model.Shop;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ShopDTO {
    @NotBlank
    private String userIdentifier;

    private Float total;

    private Date date;
    @NotNull
    private List<ItemDTO> items;

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
