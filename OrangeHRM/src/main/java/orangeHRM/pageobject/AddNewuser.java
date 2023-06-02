package orangeHRM.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import orangeHRM.AbstractComponents.*;

public class AddNewuser extends AbstractComponent{
		
		WebDriver driver;
		
		public AddNewuser (WebDriver wd) {
			
			super(wd);
			this.driver=wd;	
			PageFactory.initElements(driver, this);
		} 
		
		@FindBy(xpath="//*[@id='selectedEmployee_value']")
		WebElement EName;
		
		@FindBy(xpath="//*[@id='user_name']")
		WebElement UserName;
		
		@FindBy(xpath="//*[@id='password']")
		WebElement password;
		
		@FindBy(xpath="//*[@id='confirmpassword']")
		WebElement Confirm;
		
		@FindBy(xpath="//*[@class='name']")
		WebElement name;
		
		
		
		By HRAdministration = By.xpath("(//span[contains(text(),'HR Administration')])[1]");
	
		By usernameforwait = By.xpath("//*[contains(text(),'Username ')]");
		By addUser = By.xpath("//i[contains(text(),'add')]");
		
		By eName = By.xpath("//*[@id='selectedEmployee_value']");
		By selectEname = By.xpath("(//*[@class='angucomplete-title'])[1]");
		By Username = By.xpath("//*[@id='user_name']");
		By SelectRole = By.xpath("(//*[contains(text(),'arrow_drop_down')])[4]");
		By SelectRoleName = By.xpath("(//*[contains(text(),'Asset Manager')])[2]");
		By Password = By.xpath("//*[@id='password']");
		By ConfirmPassword = By.xpath("//*[@id='confirmpassword']");
		
		By Save = By.xpath("//*[@id='modal-save-button']");
		By Saveuser = By.xpath("//*[@id='modal-save-button']");
		
		By Name = By.xpath("//*[@class='name']");
		
		By DropDown = By.xpath("//*[contains(text(),'more_horiz')]");
		By SelectAll = By.xpath("//*[@id='systemUserDiv']//tr[2]//td[1]");
		By DeleteSelected = By.xpath("//*[contains(text(),'Delete Selected')]");
		By Yes = By.xpath("//*[contains(text(),'Yes, Delete')]");
		
		
		public void HRAdmin() {
			
			waitForElementToAppearAndClick(HRAdministration);
			waitForElementToAppear(usernameforwait);
			waitForElementToAppearAndClick(addUser);
		}	
			
		public void UserDetails(String EmployeName,String userName,String PassWord,String confirmPassWord) throws InterruptedException {
			
			waitForElementToAppear(eName);
			EName.sendKeys(EmployeName);
			
			waitForElementToAppearAndClick(selectEname);
			
			waitForElementToAppear(Username);
			UserName.sendKeys(userName);
			
			waitForElementToAppearAndClick(SelectRole);
			waitForElementToAppearAndClick(SelectRoleName);
			
			waitForElementToAppear(Password);
			password.sendKeys(PassWord);
			waitForElementToAppear(ConfirmPassword);
			Confirm.sendKeys(confirmPassWord);

			waitForElementToAppearAndClick(Save);
			Thread.sleep(10000);
			waitForElementToAppearAndClick(Saveuser);
		}
		
		public void Verifying() {
			
			waitForElementToAppear(Name);
			String a = name.getText();
			System.out.print(a);
		    String b = "Aaliyah Haq";
		    if(a.equals(b)) {
		    	System.out.print( true);
		    }else {
		    	System.out.print(false);
		    }    
		}
		
		public void DeleteUser() {
			waitForElementToAppearAndClick(HRAdministration);
			
			waitForElementToAppear(usernameforwait);
			waitForElementToAppearAndClick(SelectAll);
			waitForElementToAppearAndClick(DropDown);
			waitForElementToAppearAndClick(DeleteSelected);
			waitForElementToAppearAndClick(Yes);
			
		}
		
	}
