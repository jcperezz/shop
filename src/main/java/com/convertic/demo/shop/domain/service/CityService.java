package com.convertic.demo.shop.domain.service;

import org.springframework.data.domain.Page;

import com.convertic.demo.shop.domain.exception.NotResourceException;
import com.convertic.demo.shop.domain.model.CityEntity;

public interface CityService {
	
	Page<CityEntity> findAllPaginated(int pageNumber, int rowPerPage);
	
	CityEntity findById(final Long id) throws NotResourceException;

}
