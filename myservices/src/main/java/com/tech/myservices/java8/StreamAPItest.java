package com.tech.myservices.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPItest {

	public static void main(String[] args) {
		
		//skip and limit 
		
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		list.stream()
		.skip(2)
		.limit(7)
		.forEach(System.out::println);
		
		// map() and flatmap()
		List<Customer> customers = getAll();
		
		List<String> email=customers.stream().map(customer->customer.getEmail()).collect(Collectors.toList());
		System.out.println(" email \n"+email);
		
	}
	public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }
}
