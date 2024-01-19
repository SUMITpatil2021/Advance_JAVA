package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo.*")
public class SpringWebTesting1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringWebTesting1Application.class, args);
		String [] beans = ctx.getBeanDefinitionNames();
		for(String s : beans)
			System.out.println(s);
	}

}
