package HRM.TestComponents;

import java.io.IOException;
import org.testng.annotations.Test;
import orangeHRM.pageobjects.ManageNewUser;
import orangeHRM.pageobjects.LogOut;
public class TestCase2 extends TestCase1{
	
	@Test(enabled=true, priority=1) 
	public void ManageAddingNewUser() throws InterruptedException, IOException {
		
		launchApplication();
		
		ManageNewUser manageNewUser = new ManageNewUser(wd);
		manageNewUser.HRAdminManageUserRole();
	
		LogOut logout = new LogOut(wd);
		logout.logoutApplication();
		
	}
	
	
}
