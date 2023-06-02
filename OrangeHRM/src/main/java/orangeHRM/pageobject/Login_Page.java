package orangeHRM.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import orangeHRM.AbstractComponents.*;

public class Login_Page extends Wait_For_Element{
		
		WebDriver driver;
		
		public Login_Page(WebDriver wd) {
			
			super(wd);
			//initialization
			this.driver=wd;
			PageFactory.initElements(driver, this);
		}
		
		public void goTo() {
			driver.get("https://lakshmishahr-trials79.orangehrmlive.com/auth/seamlessLogin");
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
			wait_For_Element_ToAppear_And_Click(Login);
		}
		
		public void loginByNewUser(String name, String password) {
			userName.sendKeys(name);
			userPassword.sendKeys(password);
			wait_For_Element_ToAppear_And_Click(Login);
			
		}
			
	}


