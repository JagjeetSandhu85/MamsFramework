package vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustry {
	
	public static void main(String[] args) throws InterruptedException {
		
		Random ran = new Random();
		int random = ran.nextInt(1000);
			
		//Step 1: Launch The Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step 2: Login To Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: Navigate to Organizations Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4: Click On create Organization Look Up Image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5: Create Organization with mandatory Information
		String OrgName = "Infosys"+random;
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		//Step 6: Select 'Chemicals' in industry Drop down
		WebElement dropDown = driver.findElement(By.name("industry"));
		Select sel = new Select(dropDown);
		sel.selectByValue("Chemicals");
		
		//Step 7: Save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(OrgName))
		{
			System.out.println("PASS");
			System.out.println(orgHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step 9: Logout of App
		WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step 10: Close the browser
		driver.quit();
		
	}

}
