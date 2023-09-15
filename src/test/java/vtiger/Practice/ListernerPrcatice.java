package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class ListernerPrcatice {
	
	@Test
	public void demo()
	{
		Assert.fail();
		System.out.println("HI");
	}
	
	@Test(dependsOnMethods = "demo" )
	public void demo1()
	{
		System.out.println("hello");
		
	}

}
