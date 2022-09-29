package com.tech.myservices.java8;

import java.util.List;
import java.util.stream.Collectors;

import com.tech.myservices.util.CommonUtil;

public class StreamParallerStreamTest {

	public static void main(String[] args) {
		StreamParallerStreamTest test=new StreamParallerStreamTest();
		test.getNameInUpperCaesWithStream();
	}

	public List<String> getNameInUpperCaesWithStream() {
		List<Customer> customerList = Customer.getAll();

		// stream
		CommonUtil.startTimer();
		List<String> nameInUpperCase = customerList.stream().map(this::upperCaseWithDelay).collect(Collectors.toList());
		CommonUtil.timeTaken();
		System.out.println(" Stream : Name in Uppr Case:" + nameInUpperCase);

		
		  // parallel stream CommonUtil.startTimer(); List<String> nameInUpperCaselist
		CommonUtil.startTimer();
		List<String> nameInUpperCaseList = customerList.parallelStream() .map(this::upperCaseWithDelay).collect(Collectors.toList());
		  CommonUtil.timeTaken();
		  System.out.println(" Parallel Stream Name in Upper Case:" +
				  nameInUpperCaseList);
		
		
		return nameInUpperCase;//nameInUpperCaseList;
	}

	public String upperCaseWithDelay(Customer name) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return name.getName().toUpperCase();
	}
}
