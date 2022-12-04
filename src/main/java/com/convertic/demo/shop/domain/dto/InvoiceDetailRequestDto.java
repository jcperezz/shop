package com.convertic.demo.shop.domain.dto;

public class InvoiceDetailRequestDto {

	private Long idWarehouse;
	private Long quantity;

	public Long getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(Long idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
