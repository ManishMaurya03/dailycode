package com.tech.myservices.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    
    @Cacheable("product")
    public List<Product> findAllProducts()
    {
    	System.out.println(" inside service class  findAllProducts method: ");
    	return repository.findAll();
    }
    
    public List<Product> findProductsWithSorting(String fieldName)
    {
    	return repository.findAll(Sort.by(fieldName).ascending());
    }
    
    public Page<Product> findProductsWithPagination(int offset,int pageSize){
    	Page<Product> products=repository.findAll(PageRequest.of(offset, pageSize));
    	return products;
    }
    
    public Page<Product> findProductsWithPaginationAndSorting(int offset,int pageSize,String fieldName){
    	Page<Product> products=repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(fieldName)));
    	return products;
    }
}
