package com.knowit.SpringBootAssociation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.knowit.SpringBootAssociation.*")
public class SpringBootAssociationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssociationApplication.class, args);
	}

}
