package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controllers.GreetController;
import com.example.demo.services.GreetingService;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetControllerTest {

	@Autowired
	MockMvc mock;
	
	@MockBean
	private GreetingService grservice;
	
	@Test
	void greetTest() throws Exception
	{
		Mockito.when(grservice.greet()).thenReturn("Hello World");
		mock.perform(MockMvcRequestBuilders.get("/greet")).andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello World")));
	}
}
