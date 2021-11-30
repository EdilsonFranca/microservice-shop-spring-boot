package com.ms.shop.controller;

import com.ms.shop.service.ShopService;
import com.ms.shop.dto.ShopDTO;
import com.ms.shop.dto.ShopReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shopping")
    public List<ShopDTO> getShops() {
        return shopService.getAll();
    }

    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public List<ShopDTO> getShops(@PathVariable String userIdentifier) {
        return shopService.getByUser(userIdentifier);
    }

    @GetMapping("/shopping/shopByDate")
    public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {
        return shopService.getByDate(shopDTO);
    }

    @GetMapping("/shopping/{id}")
    public ShopDTO findById(@PathVariable Long id) {
        return shopService.findById(id);
    }

    @PostMapping("/shopping")
    public ShopDTO newShop(
            @RequestHeader(name = "key", required=true) String key,
            @RequestBody ShopDTO shopDTO) {
        return shopService.save(shopDTO, key);
    }

    @GetMapping("/shopping/search")
    public List<ShopDTO> getShopsByFilter(
            @RequestParam(name = "dataInicio", required=true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
            @RequestParam(name = "dataFim", required=false)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim,
            @RequestParam(name = "valorMinimo", required=false) Float valorMinimo) {
        return shopService.getShopsByFilter(dataInicio, dataFim, valorMinimo);
    }

    @GetMapping("/shopping/report")
    public ShopReportDTO getReportByDate(
            @RequestParam(name = "dataInicio", required=true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
            @RequestParam(name = "dataFim", required=true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim) {
        return shopService.getReportByDate(dataInicio, dataFim);
    }
}
