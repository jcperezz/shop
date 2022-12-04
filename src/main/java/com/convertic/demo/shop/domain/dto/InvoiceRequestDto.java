package com.convertic.demo.shop.domain.dto;

import java.util.List;

public class InvoiceRequestDto {

	private Long cityId;
	private String address;
	private List<InvoiceDetailRequestDto> details;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<InvoiceDetailRequestDto> getDetails() {
		return details;
	}

	public void setDetails(List<InvoiceDetailRequestDto> details) {
		this.details = details;
	}

}
