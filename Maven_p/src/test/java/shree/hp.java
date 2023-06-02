package shree;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class hp {
	WebDriver driver;
	String url="https://rahulshettyacademy.com/locatorspractice";//
@BeforeTest
	public  void tc1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();//launching the browser
		driver.get(url);//initiating a url
		driver.manage().window().maximize();//used to maximize the web.
		Thread.sleep(5000);
}
	@Test
	public void tc2() {
		System.out.println(driver.getTitle());
		
	}
	@AfterTest(enabled=true)
	public void tc3() {
		driver.close();
	}
	

}
