package com.ms.shop.converter;

import com.ms.shop.dto.CategoryDTO;
import com.ms.shop.model.Product;
import com.ms.shop.dto.ProductDTO;

public class DTOConverter {

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());

        if (product.getCategory() != null) {
            productDTO.setCategory( CategoryDTO.convert(product.getCategory()));
        }
        return productDTO;
    }
}
