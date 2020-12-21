package com.fizzbuzz.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.fizzbuzz.ui"})
public class FizzBuzzUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FizzBuzzUiApplication.class, args);
	}

}