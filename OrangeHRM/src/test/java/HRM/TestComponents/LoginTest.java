package HRM.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import orangeHRM.pageobjects.LoginPage;

public class LoginTest extends BaseTest {
	
	public LoginPage launchApplication() throws IOException {
		
		// Fetching Values From Global Properties
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+"//src//main//resources//orangeHRM//resources//GlobalData.properties");
		prop.load(fis);
		String URL = prop.getProperty("url");
		String userName = prop.getProperty("username");
		String Password = prop.getProperty("password");
		
		wd.get(URL);	//Navigating on an URL	
		
		LoginPage loginpage = new LoginPage(wd);
		loginpage.loginApplication(userName,Password);
		return loginpage;
	}
	

}
