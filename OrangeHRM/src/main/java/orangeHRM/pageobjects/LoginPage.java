package orangeHRM.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import orangeHRM.AbstractComponents.AbstractComponent;


public class LoginPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LoginPage(WebDriver wd) {
		
		super(wd);
		//initialization
		this.driver=wd;
		PageFactory.initElements(driver, this);
	}
	
	
	//PageFactory
	
	@FindBy(xpath="//*[@name='txtUsername']")
	WebElement userName;
	
	@FindBy(xpath="//*[@name='txtPassword']")
	WebElement userPassword;

	@FindBy(xpath="//*[@type='submit']")
	WebElement submit;
	
	By Login = By.xpath("//*[@type='submit']");
	
	
	public void loginApplication(String name, String password) {
		
		userName.sendKeys(name);
		userPassword.sendKeys(password);
		waitForElementToAppear(Login);
		submit.click();
		}
	
	public void loginByNewUser(String name, String password) {
		userName.sendKeys(name);
		userPassword.sendKeys(password);
		waitForElementToAppear(Login);
		submit.click();
		
	}
		
}
