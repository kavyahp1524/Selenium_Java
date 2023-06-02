package orangeHRM.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import orangeHRM.AbstractComponents.AbstractComponent;


public class LogOut extends AbstractComponent{
	
	WebDriver driver;
	
	public LogOut(WebDriver wd) {
		
		super(wd);
		//initialization
		this.driver=wd;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	
	@FindBy(xpath="//*[contains(text(),'Log Out')]")
	WebElement submit;
	
	By Logout = By.xpath("//*[contains(text(),'Log Out')]");
	
	public void logoutApplication() {
		waitForElementToAppear(Logout);
		submit.click();
		
	}
		
}
