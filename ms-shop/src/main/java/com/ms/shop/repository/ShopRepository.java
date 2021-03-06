package com.ms.shop.repository;

import java.util.Date;
import java.util.List;

import com.ms.shop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>,ReportRepository {
    public List<Shop> findAllByUserIdentifier(String userIdentifier);
    public List<Shop> findAllByTotalGreaterThan(Float total);
    public List<Shop> findAllByDateGreaterThan(Date date);
}
