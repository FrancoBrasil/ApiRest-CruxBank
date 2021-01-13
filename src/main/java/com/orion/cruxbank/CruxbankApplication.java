package com.orion.cruxbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class CruxbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruxbankApplication.class, args);
	}

}
