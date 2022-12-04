package com.convertic.demo.shop.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.convertic.demo.shop.domain.exception.NotResourceException;
import com.convertic.demo.shop.domain.model.CityEntity;
import com.convertic.demo.shop.domain.repository.CityRepository;
import com.convertic.demo.shop.domain.service.CityService;

@Component
public class CityServiceImpl implements CityService {
	
	
	private final CityRepository repository;
	
	
	public CityServiceImpl(@Autowired CityRepository repository) {
		super();
		this.repository = repository;
	}


	public Page<CityEntity> findAllPaginated(int pageNumber, int rowPerPage) {
		return repository.findAll(PageRequest.of(pageNumber, rowPerPage));
	}
	
	public CityEntity findById(final Long id) throws NotResourceException {
		return repository.findById(id).orElseThrow( () -> new NotResourceException("No existe la city con id "+id));
	}
	

}
