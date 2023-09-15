package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void test()
	{
		System.out.println("Hi started");
		
		Assert.assertEquals("a", "b");
	
		System.out.println("Hello Im here");
	}

	@Test
	public void test2()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		//pass - 10 SA - 8 SA
	
		System.out.println("Step 2");
	
		sa.assertTrue(false);//fail
		System.out.println("Step 3");
		
		sa.assertEquals(1, 2);//fail
		System.out.println("Step 4");
		
		Assert.assertEquals(false, true);
		
		System.out.println("Step 5");
		
		sa.assertAll();
		

	}
}
