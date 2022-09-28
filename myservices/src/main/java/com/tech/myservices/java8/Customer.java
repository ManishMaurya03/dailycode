package com.tech.myservices.java8;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
	private int id;
	private String name;
	private String email;
	private List<String> phoneNumbers;

}
