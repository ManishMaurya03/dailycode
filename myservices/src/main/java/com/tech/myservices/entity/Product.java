package com.tech.myservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int quantity;
	private long price;

	public Product(String name, int quantity, long price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
}
