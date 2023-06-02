package defination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefination {
	WebDriver wd;
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@Given("I want to Launch OrangeHRM page")
	public void i_want_to_launch_orange_hrm_page() {
		 WebDriverManager.chromedriver().setup();
		   wd = new ChromeDriver();
		   wd.manage().window().maximize();
		   wd.get(url);
		   wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Given("Validate the outcomes and Finding links in that page")
	public void validate_the_outcomes_and_finding_links_in_that_page() throws InterruptedException {
		 String exp = "OrangeHRM";
		   String act = wd.getTitle();
		   Assert.assertEquals(act, exp);
		   Thread.sleep(3000);
		   System.out.println(wd.getTitle());
		   
		   //finding links in orangehrm page
		   
		   List<WebElement> links = wd.findElements(By.tagName("a"));
	       System.out.println(links.size());
	       for(int i=0;i<links.size();i++) {
	    	   System.out.println(links.get(i).getText());
	       }
	       
	       Thread.sleep(5000);
	}
	
	@When("I want to login to OrangeHRM page")
	public void i_want_to_login_to_orange_hrm_page() throws InterruptedException {
		 wd.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		   Thread.sleep(1000);
		   wd.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		   Thread.sleep(1000);
		   wd.findElement(By.xpath("//*[@type='submit']")).click();
		   Thread.sleep(5000);
		   
	}
	
	
	@When("Logout from the page")
	public void logout_from_the_page() throws InterruptedException {
		Thread.sleep(5000);
		   
		   wd.findElement(By.className("oxd-userdropdown-icon")).click();
		   Thread.sleep(3000);
		   
		   WebElement k =wd.findElement(By.xpath("(//*[@class='oxd-userdropdown-link'])[4]"));
		   Thread.sleep(3000);
		   Actions mo = new Actions(wd);
		   mo.moveToElement(k).click().build().perform();
		   Thread.sleep(5000);
	}


}
