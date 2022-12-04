package com.convertic.demo.shop.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.convertic.demo.shop.domain.model.WarehouseEntity;

@Repository
public interface WarehouseRepository extends PagingAndSortingRepository<WarehouseEntity, Long> {

}
