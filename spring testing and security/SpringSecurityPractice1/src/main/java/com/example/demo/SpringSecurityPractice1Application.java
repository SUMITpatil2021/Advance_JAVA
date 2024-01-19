package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo.*")
public class SpringSecurityPractice1Application {

	public static void main(String[] args) {
			ApplicationContext ctx = SpringApplication.run(SpringSecurityPractice1Application.class, args);
			/*for(String s:   ctx.getBeanDefinitionNames())
				System.out.println(s);*/
	}

}
