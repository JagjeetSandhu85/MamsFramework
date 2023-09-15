package vtiger.Practice;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws Throwable {
		
//		PropertyFileUtility pUtil = new PropertyFileUtility();
//		String value = pUtil.readDataFromPropertyFile("browser");
//		System.out.println(value);
//		
//		String un = pUtil.readDataFromPropertyFile("username");
//		System.out.println(un);
//		
//		ExcelFileUtility eUtil = new ExcelFileUtility();
//		String data = eUtil.readDataFromExcel("Contacts", 1, 2);
//		System.out.println(data);
//		
//		eUtil.writeDataIntoExcel("trialNow", 5, 3, "HarryPotter");
//		System.out.println("Data added");
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		
		System.out.println(jUtil.getSystemDate());
		
	}

}
