package com.ms.shop.service;

import com.ms.shop.converter.DTOConverter;
import com.ms.shop.dto.*;
import com.ms.shop.model.Shop;
import com.ms.shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public List<ShopDTO> getAll() {
        List<Shop> shops = shopRepository.findAll();
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier) {
        List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO) {
        List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO findById(long ProductId) {
        Optional<Shop> shop = shopRepository.findById(ProductId);
        if (shop.isPresent()) {
            return ShopDTO.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO , String key) {
        UserDTO userDTO = userService.getUserByCpf(shopDTO.getUserIdentifier(), key);
        if (userDTO == null) {
            return null;
        }

        if (!validateProducts(shopDTO.getItems())) {
            return null;
        }

        shopDTO.setTotal(shopDTO.getItems()
                .stream()
                .map(x -> x.getPrice())
                .reduce((float) 0, Float::sum));
        Shop shop = Shop.convert(shopDTO);
        shop.setDate(new Date());
        shop = shopRepository.save(shop);
        return ShopDTO.convert(shop);
    }

    public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {
        List<Shop> shops = shopRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
        return shopRepository.getReportByDate(dataInicio, dataFim);
    }

    private boolean validateProducts(List<ItemDTO> items) {
        for (ItemDTO item : items) {
            ProductDTO productDTO = productService.getProductByIdentifier(item.getProductIdentifier());

            if (productDTO == null) {
                return false;
            }
            item.setPrice(productDTO.getPreco());
        }
        return true;
    }
}
