package com.convertic.demo.shop.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.convertic.demo.shop.domain.exception.NotResourceException;
import com.convertic.demo.shop.domain.model.CityEntity;
import com.convertic.demo.shop.domain.service.CityService;

@RestController
@RequestMapping(path = "/cities")
public class CityController {
	
	private final CityService service;
	
	
	public CityController(@Autowired final CityService service) {
		super();
		this.service = service;
	}



	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CityEntity>> getAll(){
		
//		if(pageNumber < 0) {
//			throw new IllegalArgumentException("La pagina debe ser mayor a cero");
//		}
		
		final Page<CityEntity> result = service.findAllPaginated(0, 1000);
		
		return ResponseEntity.ok(result.getContent());
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CityEntity> getById(@PathVariable(value = "id") final Long id) {
		
		try {
			
			final CityEntity city = service.findById(id);
			return ResponseEntity.ok(city);
			
			
		} catch (NotResourceException e) {
			// Lanzo el codigo de error 404
			return ResponseEntity.notFound().build();
		}
		
	}

}
