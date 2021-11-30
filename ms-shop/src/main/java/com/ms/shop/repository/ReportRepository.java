package com.ms.shop.repository;

import com.ms.shop.dto.ShopReportDTO;
import com.ms.shop.model.Shop;

import java.util.Date;
import java.util.List;

public interface ReportRepository {
    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);
}