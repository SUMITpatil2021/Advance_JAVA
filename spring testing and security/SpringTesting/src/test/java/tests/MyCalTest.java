package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import apps.Calculator;

class MyCalTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("set up before all tests");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("set up after all tests");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("set up before each test");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("set up after each tests");
	}

	@Test
	void testAdd() {
		Calculator calculator = new Calculator();
        int a = 1234;
        int b = 5678;
        int actual = calculator.add(a, b);
     
        int expected = a+b;
     
        System.out.println("in test add");
        //Assertions.
        Assertions.assertEquals(expected, actual);
	}

	@Test
	void testSubtract() {
		Calculator calculator = new Calculator();
        int a = 1234;
        int b = 5678;
        int actual = calculator.subtract(a, b);
     
        int expected = 1234-5678;
     
        System.out.println("in test subtract");
        Assertions.assertEquals(expected, actual);
	}

}
