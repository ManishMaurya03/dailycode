package com.tech.myservices.java8;

import java.util.function.Consumer;

public class ConsumerFunctionalinterfaceTest {

	public static void main(String[] args) {
		Consumer<Integer> test = t -> System.out.println("prining:" + t);

		test.accept(10);
	}

}
