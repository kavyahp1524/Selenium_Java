package orangeHRM.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import orangeHRM.AbstractComponents.AbstractComponent;

public class ManageNewUser extends AbstractComponent{

	WebDriver driver;
    
    public  ManageNewUser (WebDriver wd) {
        
        super(wd);
    
        this.driver=wd;    
        PageFactory.initElements(driver, this);

    }
    
    @FindBy(xpath="//*[@id='user_role_name']")
    WebElement userRoleName;
    
    @FindBy(xpath="(//*[@id='toast-container'])")
    WebElement toastMessage;
    
    
    
    By HRAdministration = By.xpath("(//span[contains(text(),'HR Administration')])[1]");
    By Wait =By.xpath("//thead/tr[1]/th[2]");
    By manageuser = By.xpath("//*[contains(text(),'Manage User Roles ')]");
    By AddUserRole = By.xpath("//i[contains(text(),'add')]");
    By Type = By.xpath("(//*[@type='text'])[2]");
    
    By UserRoleName =By.xpath("//*[@id='user_role_name']");
    
    By EmploerAction =By.xpath("//*[@for='checkbox_employee_add']");
    By WorkFlowManagement = By.xpath("//*[@for='checkbox_leave']");
    By Save = By.xpath("//*[@form-name='userRoleForm']");
    By ToastMessage = By.xpath("(//*[@id='toast-container'])");
    
    
    
    By DropDown = By.xpath("//*[contains(text(),'more_horiz')]");
	By SelectAll = By.xpath("//*[contains(text(),'Select All')]");
	By DeleteSelected = By.xpath("//*[contains(text(),'Delete Selected')]");
	By Yes = By.xpath("//*[contains(text(),'Yes, Delete')]");

public void HRAdminManageUserRole() throws InterruptedException {
    
    waitForElementToAppearAndClick(HRAdministration);
    waitForElementToAppear(Wait);

    waitForElementToAppearAndClick(manageuser);
    waitForElementToAppearAndClick(AddUserRole);
    
    waitForElementToAppear(UserRoleName);
    userRoleName.sendKeys("EndToEndTester");
    
    waitForElementToAppearAndClick(EmploerAction);
    waitForElementToAppearAndClick(WorkFlowManagement);
    waitForElementToAppearAndClick(Save);
    waitForElementToAppear(ToastMessage);
    
    String h=toastMessage.getText();
    
    if (h.equals("Successfully Saved")) {
        
        System.out.print("Condition passed\t"+h);
    }else {
        System.out.print("Conditon Not Passed"+h);
    }
    
    
    waitForElementToAppearAndClick(DropDown);
	waitForElementToAppearAndClick(SelectAll);
	waitForElementToAppearAndClick(DropDown);
	waitForElementToAppearAndClick(DeleteSelected);
	waitForElementToAppearAndClick(Yes);
    
}    
}
