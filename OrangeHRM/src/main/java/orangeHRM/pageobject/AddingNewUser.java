package orangeHRM.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import orangeHRM.AbstractComponents.AbstractComponent;


public class AddingNewUser extends AbstractComponent{
	
	WebDriver driver;
	
	public AddingNewUser(WebDriver wd) {
		
		super(wd);
		//initialization
		this.driver=wd;	
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="(//span[contains(text(),'HR Administration')])[1]")
	WebElement HRAdmini;
	
	@FindBy(xpath="//i[contains(text(),'add')]")
	WebElement Add;
	
	@FindBy(xpath="//*[@id='selectedEmployee_value']")
	WebElement EName;
	
	@FindBy(xpath="//*[@id='selectedEmployee_dropdown']//div[@class='angucomplete-row angucomplete-selected-row']")
	WebElement Select;
	
	@FindBy(xpath="//*[@id='user_name']")
	WebElement UserName;
	
	@FindBy(xpath="(//*[@type='button'])[6]")
	WebElement Selectrole;
	
	@FindBy(xpath="//a//span[contains(text(),'Asset Manager')]")
	WebElement SelectroleName;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='confirmpassword']")
	WebElement Confirm;
	
	@FindBy(xpath="//*[@id='modal-save-button']")
	WebElement save;
	
	@FindBy(xpath="//*[@class='btn btn-secondary']")
	WebElement saveUser;
	
	@FindBy(xpath="//*[contains(text(),'more_horiz')]")
	WebElement Dropdown;
	
	@FindBy(xpath="//*[contains(text(),'Select All')]")
	WebElement selectAll;
	
	@FindBy(xpath="//*[contains(text(),'Adella Lopez')]")
	WebElement name;
	
	@FindBy(xpath="//*[contains(text(),'Delete Selected')]")
	WebElement deleteSelected;
	
	@FindBy(xpath="//*[contains(text(),'Yes, Delete')]")
	WebElement yes;
	
	
	By HRAdministration = By.xpath("(//span[contains(text(),'HR Administration')])[1]");
	
	By Regions = By.xpath("//*[contains(text(),'Regions ')]");
	By addUser = By.xpath("//i[contains(text(),'add')]");
	
	By eName = By.xpath("//*[@id='selectedEmployee_value']");
	By selectEname = By.xpath("//*[@id='selectedEmployee_dropdown']//div[@class='angucomplete-row angucomplete-selected-row']");
	By Username = By.xpath("//*[@id='user_name']");
	By SelectRole = By.xpath("(//*[@type='button'])[6]");
	By SelectRoleName = By.xpath("//a//span[contains(text(),'Asset Manager')]");
	By Password = By.xpath("//*[@id='password']");
	By ConfirmPassword = By.xpath("//*[@id='confirmpassword']");
	
	By footer = By.xpath("(//*[@class='modal-footer'])[2]");
	By Save = By.xpath("//*[@id='modal-save-button']");
	By Modify = By.xpath("//h5[contains(text(),'Modify Region')]");
	By Saveuser = By.xpath("//*[@class='btn btn-secondary']");
	
	By Name = By.xpath("//*[contains(text(),'Adella Lopez')]");
	
	By DropDown = By.xpath("//*[contains(text(),'more_horiz')]");
	By SelectAll = By.xpath("//*[contains(text(),'Select All')]");
	By DeleteSelected = By.xpath("//*[contains(text(),'Delete Selected')]");
	By AreYouSure = By.xpath("//*[contains(text(),'Are you sure?')]");
	By Yes = By.xpath("//*[contains(text(),'Yes, Delete')]");
	
	
	public void HRAdmin() {
		
		waitForElementToAppearAndClick(HRAdministration);
		
		
		waitForElementToAppear(Regions);
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
		Thread.sleep(5000);
		
		
	}
	
	public void SaveUser() {
		waitForElementToAppear(Modify);
		waitForElementToAppear(Saveuser);
		saveUser.click();
	}	
	
	public void Verifying() {
		
		waitForElementToAppear(Name);
		String a = name.getText();
		System.out.print(a);
	    String b = "Adella Lopez";
	    if(a==b) {
	    	System.out.print(true);
	    }else {
	    	System.out.print(false);
	    }    
	}
	
	public void DeleteUser() {
		waitForElementToAppearAndClick(HRAdministration);
		
		
		waitForElementToAppear(Regions);
		waitForElementToAppearAndClick(DropDown);
	
		waitForElementToAppearAndClick(SelectAll);
		
		waitForElementToAppearAndClick(DropDown);
		waitForElementToAppearAndClick(DeleteSelected);
		
		waitForElementToAppear(AreYouSure);
		waitForElementToAppearAndClick(Yes);
		
		
	}
	
}






