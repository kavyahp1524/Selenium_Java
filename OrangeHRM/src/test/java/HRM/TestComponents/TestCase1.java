package HRM.TestComponents;

import java.io.IOException;
import org.testng.annotations.Test;

import orangeHRM.pageobjects.LoginPage;
import orangeHRM.pageobjects.AddNewuser;
import orangeHRM.pageobjects.LogOut;
public class TestCase1 extends LoginTest{
	
	@Test(enabled=true, priority=0) 
	public void AddingNewUser() throws InterruptedException, IOException {
			
		LoginPage loginpage =  launchApplication();
		
		//Navigating to User Add Page
		AddNewuser HrAdministration = new AddNewuser(wd);
		HrAdministration.HRAdmin();
				
		//User details
		HrAdministration.UserDetails("a", "Kavyashree", "Kavya@1524", "Kavya@1524");
				
		//Logout page
		LogOut logout = new LogOut(wd);
		logout.logoutApplication();

		loginpage.loginByNewUser("Kavyashree", "Kavya@1524");
		
		// Verifying UserName
		HrAdministration.Verifying();
	    
		// Deleting Added User
		logout.logoutApplication();
		loginpage.loginApplication("Admin","cU@L6YXm3o");
		HrAdministration.DeleteUser();
		logout.logoutApplication();
			
	}
	
	
}
