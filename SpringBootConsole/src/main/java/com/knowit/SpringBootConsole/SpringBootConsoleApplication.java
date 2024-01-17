package com.knowit.SpringBootConsole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootConsoleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootConsoleApplication.class, args);
		
		Test obj=ctx.getBean(Test.class);
		System.out.println(obj);
//		
//		String [] beanNames=ctx.getBeanDefinitionNames();
//		for(String bean:beanNames)
//		{
//			System.out.println(bean);
//		}
	}

}
