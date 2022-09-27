package com.tech.myservices.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tech.myservices.entity.Product;
import com.tech.myservices.repository.ProductRepository;

@Service
public class ProductService {

	 @Autowired
	    private ProductRepository repository;

    @PostConstruct
	    public void initDB() {
	        List<Product> products = IntStream.rangeClosed(1, 200)
	                .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
	                .collect(Collectors.toList());
	        repository.saveAll(products);
	    }
    
    
    public List<Product> findAllProducts()
    {
    	return repository.findAll();
    }
    
    public List<Product> findProductsWithSorting(String fieldName)
    {
    	return repository.findAll(Sort.by(fieldName).ascending());
    }
    
}
