package com.convertic.demo.shop.domain.service.impl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.convertic.demo.shop.domain.dto.InvoiceDetailRequestDto;
import com.convertic.demo.shop.domain.dto.InvoiceRequestDto;
import com.convertic.demo.shop.domain.exception.NotResourceException;
import com.convertic.demo.shop.domain.model.CityEntity;
import com.convertic.demo.shop.domain.model.InvoiceDetailEntity;
import com.convertic.demo.shop.domain.model.InvoiceEntity;
import com.convertic.demo.shop.domain.model.WarehouseEntity;
import com.convertic.demo.shop.domain.repository.InvoiceRepository;
import com.convertic.demo.shop.domain.service.InvoiceService;
import com.convertic.demo.shop.domain.service.WarehouseService;

public class InvoiceServiceImpl implements InvoiceService {

	private final InvoiceRepository repository;
	private final WarehouseService warehouseService;

	public InvoiceServiceImpl(@Autowired final InvoiceRepository repository, @Autowired final WarehouseService warehouseService ) {
		super();
		this.repository = repository;
		this.warehouseService = warehouseService;
	}

	public Page<InvoiceEntity> findAllPaginated(int pageNumber, int rowPerPage) {
		return repository.findAll(PageRequest.of(pageNumber, rowPerPage));
	}
	
	
	public InvoiceEntity collect(final InvoiceRequestDto request) throws NotResourceException {
		
		final InvoiceEntity draftInvoice = validateRequest(request);
		
		Set<InvoiceDetailEntity> details = draftInvoice.getDetails();
		
		for (InvoiceDetailEntity invoiceDetailEntity : details) {
			warehouseService.withdraw(invoiceDetailEntity.getWarehouse(), invoiceDetailEntity.getQuantity());
		}
		
		
				
		return null;
	}

	private InvoiceEntity validateRequest(final InvoiceRequestDto request) throws NotResourceException {
		final InvoiceEntity draftInvoice = new InvoiceEntity();
		draftInvoice.setAddress(request.getAddress());
		
		final CityEntity city = new CityEntity();
		city.setId(request.getCityId());
		
		draftInvoice.setCity(city);
		draftInvoice.setCreated(LocalDate.now());
		
		
		Set<InvoiceDetailEntity> draftDetails = new HashSet<>();
		List<InvoiceDetailRequestDto> requestDetails = request.getDetails();
		
		for (InvoiceDetailRequestDto detailRequestDto : requestDetails) {
			
			final InvoiceDetailEntity detailEntity = new InvoiceDetailEntity();
			detailEntity.setQuantity(detailRequestDto.getQuantity());
			
			
			final WarehouseEntity warehouseEntity = new WarehouseEntity();
			warehouseEntity.setId(detailRequestDto.getIdWarehouse());
			
			warehouseService.existsAvailable(warehouseEntity, detailRequestDto.getQuantity());
			
			detailEntity.setWarehouse(warehouseEntity);
			
			draftDetails.add(detailEntity);
		}
		
		draftInvoice.setDetails(draftDetails);
		return draftInvoice;
	}


}
