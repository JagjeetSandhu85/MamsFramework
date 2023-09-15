package vtiger.Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrgWithIndustryUsingGU {
	
	public static void main(String[] args) throws Throwable {
		
		//Create Objects of all Utility Classes
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		WebDriver driver = null;
		
		//Step 1: Read All the Data required QCO-SOEAJD-M2 - sh0bha 10am to 12pm -JDBC
		
		 /*read Data from Property file*/
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		 /*read Data from ExcelFile*/
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readDataFromExcel("Organizations", 4, 3);
				
		//Step 2: Launch the browser - //Run Time Polymorphism - driver
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new FirefoxDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("edge"))
	    {
	    	WebDriverManager.edgedriver().setup();
	    	driver = new EdgeDriver();
	    }
	    else
	    {
	    	System.out.println("Invalid Browser name");
	    }
	    
	    
	    wUtil.maximiseWindow(driver);
		wUtil.waitForpageLoad(driver);
		driver.get(URL);
		
		//Step 2: Login To Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD); 
		
//		lp.getUserNameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		
		//Step 3: Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 4: Click On create Organization Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImage();
		
		//Step 5: Create Organization with mandatory Information
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRYTYPE);
		
		//Step 8: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgheader();
		
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(orgHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step 9: Logout of App
		hp.logoutOfApp(driver);
		
		//Step 10: Close the browser
		driver.quit();
		
	}

}
