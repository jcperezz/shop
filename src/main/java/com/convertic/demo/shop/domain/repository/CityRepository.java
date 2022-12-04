package com.convertic.demo.shop.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.convertic.demo.shop.domain.model.CityEntity;

@Repository
public interface CityRepository extends PagingAndSortingRepository<CityEntity, Long> {

}
