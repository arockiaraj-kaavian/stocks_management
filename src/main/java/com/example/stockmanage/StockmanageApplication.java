package com.example.stockmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockmanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockmanageApplication.class, args);
		System.out.println("Manage stocks to prevent sales interuption");
	}

}
