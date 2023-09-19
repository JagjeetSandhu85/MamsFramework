package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create Object of properties class - java.util
		Properties p = new Properties();
		
		//Step 3: load the document into properties class
		p.load(fis);
		
		//Step 4: provide the key and read the value
		String BROWSER = p.getProperty("browser");
		System.out.println(BROWSER);
		
		String USERNAME = p.getProperty("name");
		System.out.println(USERNAME);
		
		System.out.println("hI");
	}

}
