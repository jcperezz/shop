package com.convertic.demo.shop.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sh_invoice")
public class InvoiceEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "created")
	private LocalDate created;

	@ManyToOne(targetEntity = InvoiceEntity.class, fetch = FetchType.EAGER)
	private CityEntity city;

	@Column(name = "total")
	private BigDecimal total;

	@Column(name = "address")
	private String address;

	@OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Set<InvoiceDetailEntity> details;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<InvoiceDetailEntity> getDetails() {
		return details;
	}

	public void setDetails(Set<InvoiceDetailEntity> details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceEntity other = (InvoiceEntity) obj;
		return Objects.equals(id, other.id);
	}

}
