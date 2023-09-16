package com.ritesh.springboot.demo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.ritesh.springboot.demo.json.Greeting;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ApplicationContext appContext;

	@Test
	void contextLoads() {
	}

	@Test
	void testNoUnquieGreeting() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> appContext.getBean(Greeting.class));
	
	}

}
