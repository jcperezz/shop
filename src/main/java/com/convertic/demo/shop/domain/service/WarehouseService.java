package com.convertic.demo.shop.domain.service;

import org.springframework.data.domain.Page;

import com.convertic.demo.shop.domain.exception.NotResourceException;
import com.convertic.demo.shop.domain.model.WarehouseEntity;

public interface WarehouseService {

	Page<WarehouseEntity> findAllPaginated(int pageNumber, int rowPerPage);

	WarehouseEntity findById(final Long id) throws NotResourceException;

	void withdraw(final WarehouseEntity target, Long quantity) throws NotResourceException;
	
	boolean existsAvailable(WarehouseEntity target, Long quantity) throws NotResourceException;

}
