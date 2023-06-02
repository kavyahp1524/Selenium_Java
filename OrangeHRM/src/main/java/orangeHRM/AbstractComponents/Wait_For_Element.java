package orangeHRM.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wait_For_Element {
	
	WebDriver driver;
	public Wait_For_Element(WebDriver driver) {
		 
		this.driver=driver;
	}

	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait =new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
public void wait_For_Element_ToAppear_And_Click(By findBy) {
		
		WebDriverWait wait =new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy)).click();
		
	}
public void wait_For_Element_ToAppear_And_sendkeys(By findBy, String avi) {
	
	WebDriverWait wait =new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy)).sendKeys(avi);
}

}