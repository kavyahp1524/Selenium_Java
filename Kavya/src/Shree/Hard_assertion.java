package Shree;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Hard_assertion {

		public static void main(String[]args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","D:\\Moolyaed\\Selenium\\selenium-java-4.8.0\\Chromedriver\\chromedriver.exe");	
			WebDriver driver = new ChromeDriver();
			String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().window().maximize();//used to maximize the web. 
			String exp_title="OrangeHRM";
			String act_title=driver.getTitle();
			Assert.assertEquals(act_title, exp_title);
	
		}
		

}
