package com.tech.myservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MyservicesApplication {
// test
	public static void main(String[] args) {
		SpringApplication.run(MyservicesApplication.class, args);
		System.out.println("hello world Mac");
	}

}
