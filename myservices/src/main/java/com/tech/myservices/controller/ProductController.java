package com.tech.myservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.myservices.dto.APIResponse;
import com.tech.myservices.entity.Product;
import com.tech.myservices.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping
	private APIResponse<List<Product>> getProducts() {
		List<Product> allProducts = service.findAllProducts();
		APIResponse apiResponse = APIResponse.builder().recordCount(allProducts.size()).response(allProducts).build();
		return apiResponse;
	}

	@GetMapping("/{field}")
	// this methods
	private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
		List<Product> allProducts = service.findProductsWithSorting(field);
		return new APIResponse<>(allProducts.size(), allProducts);
	}

	@GetMapping("/pagination/{offset}/{pageSize}")
	private APIResponse<Page<Product>> getProductwithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Product> products = service.findProductsWithPagination(offset, pageSize);

		return new APIResponse<>(products.getSize(), products);
	}
	@GetMapping("/paginationsorting/{offset}/{pageSize}/{field}")
	private APIResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field)
	{
		Page<Product> product=service.findProductsWithPaginationAndSorting(offset, pageSize, field);
		return new APIResponse<>(product.getSize(),product);
	}
}
