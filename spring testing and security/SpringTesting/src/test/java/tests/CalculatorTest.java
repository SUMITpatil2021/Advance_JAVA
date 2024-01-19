package tests;




import org.junit.jupiter.api.*;
import apps.Calculator;
public class CalculatorTest {	
    public static void setUpClass() {
		System.out.println("test cases begin now...");// code executed before all test methods
    }    
   
    public void setUp() {
        System.out.println("test case beins...");
    }     
    
    public void testAdd() {
    	Calculator calculator = new Calculator();
        int a = 1234;
        int b = 5678;
        int actual = calculator.add(a, b);
     
        int expected = 6912;
     
        System.out.println("in test add");
        Assertions.assertEquals(expected, actual);
    }
     
    
    public void testSubtract() {
    	Calculator calculator = new Calculator();
        int a = 1234;
        int b = 5678;
        int actual = calculator.subtract(a, b);
     
        int expected = 1234-5678;
     
        System.out.println("in test subtract");
        Assertions.assertEquals(expected, actual);
    }
     
   
    public void tearDown() {
       System.out.println("test case ends...");
    }
     
    
    public static void tearDownClass() {
        System.out.println("All test cases finished");
    }
}
