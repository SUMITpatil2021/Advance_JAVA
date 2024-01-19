package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import apps.MathUtility;

class MathFunctionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("tests begin .....");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tests end.....");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Individual test begins ....");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Individual test ends....");
	}

	@Test
	void testCheckPrime() {
		//fail("Not yet implemented");
		System.out.println("in test testCheckPrime");
		boolean actual = MathUtility.checkPrime(9);
		boolean expected = true;
		Assertions.assertEquals(actual, expected);
		
		 actual = MathUtility.checkPrime(8);
		expected = true;
		Assertions.assertEquals(actual, expected); 
		
		
	}
	
	@DisplayName("checking function odd")
	@Test
	void testCheckOdd() {
		//fail("Not yet implemented");
		System.out.println("in test testCheckOdd");
		boolean actual = MathUtility.isOdd(10);
		boolean expected = false;
		Assertions.assertEquals(actual, expected);
		
		
		boolean actual1 = MathUtility.isOdd(12);
		boolean expected1= false;
		Assertions.assertEquals(actual1, expected1);
	}
	
	
	
	

}
