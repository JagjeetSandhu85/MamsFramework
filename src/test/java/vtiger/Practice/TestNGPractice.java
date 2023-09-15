package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void createCustomer() //fail
	{
		
		System.out.println("create");
	}
	
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	
	@Test(dependsOnMethods = {"createCustomer","modifyCustomer"})
	public void deleteCustomer()
	{
		System.out.println("delete");
	}
	

	
}
