package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	UserRepository urepo;
	
	@InjectMocks
	UserService uservice;
	
	User u;
	
	@BeforeEach
	public void setup() {
			u = new User();
			u.setId(1);
			u.setName("Bakul"); 			
	}
	
	@Test
	public void testGetAll() {
		User u1 = new User();
		u1.setId(3);
		u1.setName("Amit");
		
		BDDMockito.when(urepo.findAll()).thenReturn(List.of(u,u1));
		
		List<User> ulist = uservice.getAll();
		
		assertThat(ulist).isNotNull();
		assertThat(ulist.size()).isEqualTo(2);
		
	}
	
	
}
