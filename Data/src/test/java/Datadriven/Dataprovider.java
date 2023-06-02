package Datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider {
	WebDriver wd;
	String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get(url);
	}

	@Test(dataProvider = "dp")
	public void tc1(String n,String s) throws InterruptedException{
		
	      Thread.sleep(5000);	
		  wd.findElement(By.name("username")).sendKeys(n);
	      wd.findElement(By.name("password")).sendKeys(s);
	      wd.findElement(By.xpath("//*[@type='submit']")).click();
	      Thread.sleep(3000);
	      wd.findElement(By.xpath("//*[@class='oxd-userdropdown-img']")).click();
	      Thread.sleep(3000);
	      wd.findElement(By.linkText("Logout")).click();
	      
	}
	
	@DataProvider
	public Object[][] dp() {
		
		return new Object[][] {new Object[] {"Admin", "admin123"},new Object[] {"kavya", "admin123"}}; 
	 
 }
}
