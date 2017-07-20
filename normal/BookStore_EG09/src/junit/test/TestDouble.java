package junit.test;

import java.math.BigDecimal;

import org.junit.Test;

public class TestDouble {
	
	@Test
	public void testDouble(){
		/*double a = 1;
		double b = 0.9;*/
		
		//System.out.println(a-b);
		
		BigDecimal a = new BigDecimal("1");
		BigDecimal b = new BigDecimal("0.9");
		
		BigDecimal c = a.subtract(b);
		
		System.out.println(c.doubleValue());
	}

	@Test
	public void testInt() {
		
		//int a = 1;
		
		BigDecimal a = new BigDecimal(1);
		 
		for(int i=1 ; i<=120 ; i++){
			
			a = a.multiply(new BigDecimal(i));
			
		}
		
		System.out.println(a);
		
	}

}
