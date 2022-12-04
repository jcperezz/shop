package com.convertic.demo.shop.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.convertic.demo.shop.domain.exception.NotResourceException;
import com.convertic.demo.shop.domain.model.WarehouseEntity;
import com.convertic.demo.shop.domain.repository.WarehouseRepository;
import com.convertic.demo.shop.domain.service.WarehouseService;

@Component
public class WarehouseServiceImpl implements WarehouseService {

	private final WarehouseRepository repository;

	public WarehouseServiceImpl(@Autowired final WarehouseRepository repository) {
		super();
		this.repository = repository;
	}

	public Page<WarehouseEntity> findAllPaginated(int pageNumber, int rowPerPage) {
		return repository.findAll(PageRequest.of(pageNumber, rowPerPage));
	}

	public WarehouseEntity findById(final Long id) throws NotResourceException {
		return repository.findById(id)
				.orElseThrow(() -> new NotResourceException("No existe el warehouse con id " + id));
	}

	public void withdraw(final WarehouseEntity target, Long quantity) throws NotResourceException {

		if (existsAvailable(target, quantity)) {

			final WarehouseEntity foundEntity = findById(target.getId());
			foundEntity.setAvailable(foundEntity.getAvailable() - quantity);

			repository.save(foundEntity);

		} else {
			// TODO
		}

	}

	public boolean existsAvailable(WarehouseEntity target, Long quantity) throws NotResourceException {
		final WarehouseEntity foundEntity = findById(target.getId());

		if (foundEntity.getAvailable().compareTo(quantity) >= 0) {
			return true;
		}

		return false;

	}

}
