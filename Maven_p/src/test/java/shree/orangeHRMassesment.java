package shree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHRMassesment {
	WebDriver driver;
	String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";//

@BeforeTest //launching and getting website
public  void tc1() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();//launching the browser
	driver.get(url);//initiating a url
	driver.manage().window().maximize();//used to maximize the web.  
	Thread.sleep(5000);
}
@Test
public void tc2() throws InterruptedException {//sending keys to particular element
	WebElement web=driver.findElement(By.name("username"));
	Thread.sleep(5000);
	Actions action = new Actions(driver);
	action.sendKeys(web,"Admin").build().perform();
	Thread.sleep(5000);
	
	WebElement web1=driver.findElement(By.name("password"));
	Thread.sleep(5000);
	action.sendKeys(web1,"admin123").build().perform();
	Thread.sleep(5000);

	WebElement web2=driver.findElement(By.className("oxd-button"));
	Thread.sleep(5000);
	action.click(web2).build().perform();
	Thread.sleep(5000);
	
	WebElement web3=driver.findElement(By.className("oxd-userdropdown"));
	Thread.sleep(5000);
	action.click(web3).build().perform();
	Thread.sleep(5000);
	
	WebElement web4=driver.findElement(By.linkText("Logout"));
	Thread.sleep(5000);
	action.click(web4).build().perform();
	Thread.sleep(5000);
	}
}
