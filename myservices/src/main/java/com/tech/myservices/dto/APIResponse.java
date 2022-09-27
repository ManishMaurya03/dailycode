package com.tech.myservices.dto;

import java.util.List;

import com.tech.myservices.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse<T> {

	private int recordCount;
	private List<Product> response;

}