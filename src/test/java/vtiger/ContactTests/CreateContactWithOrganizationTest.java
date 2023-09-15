package vtiger.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void createContactWithOrgTest() throws Throwable {

		/* read Data from ExcelFile */
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 3);

		// Step 3: Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("clicked on organizations Link");

		// Step 4: Click On create Organization Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImage();
		Reporter.log("clicked on organizations look up Image");

		// Step 5: Create Organization with mandatory Information
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		Reporter.log("organization created");

	
		// Step 8: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgheader();

		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		
		//Step 9: Click on Contacts Link
		hp.clickOnContactLink();
		Reporter.log("clicked on conatcts Link");
		
		//Step 10: Click on Create Contact Look Up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("clicked on contacts look up Image");
		
		//Step 11: create Contact using the organization
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, ORGNAME, driver);
		Reporter.log("contact Created");
		
		//Step 12: Validate for Contacts
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader);
		
	
		
		
	}
	
	@Test
	public void demo()
	{
		System.out.println("demo");
	}

}
