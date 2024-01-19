package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controllers.HomeController;

@SpringBootTest
class SpringWebTesting1ApplicationTests {

	@Autowired
	HomeController hc;
	
	@Test
	void contextLoads() {
		assertThat(hc).isNotNull();
	}

}
