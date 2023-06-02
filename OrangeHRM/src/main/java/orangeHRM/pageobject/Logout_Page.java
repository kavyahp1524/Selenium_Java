package orangeHRM.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import orangeHRM.AbstractComponents.*;

public class Logout_Page extends Wait_For_Element {
		
		WebDriver driver;
		
		public Logout_Page(WebDriver driver) {
			
			super(driver);
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//PageFactory
		
		//@FindBy(xpath="//*[contains(text(),'Log Out')]")
		//WebElement Logout;
		
		By Logout = By.xpath("//*[contains(text(),'Log Out')]");
		
		public void logoutApplication() {
			wait_For_Element_ToAppear_And_Click(Logout);
		}
			
	}

