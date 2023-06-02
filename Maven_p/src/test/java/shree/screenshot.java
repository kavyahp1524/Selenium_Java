package shree;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshot {
		WebDriver driver;
		String url1 ="https://www.rahulshettyacademy.com/practice-project";

	@BeforeTest //launching and getting website
	public  void tc1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();//launching the browser
		driver.get(url1);//initiating a url
		driver.manage().window().maximize();//used to maximize the web. 
		Thread.sleep(5000);
	}

	@Test(enabled= true)
	public void tc() throws InterruptedException, AWTException, IOException {
		File kav=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(kav, new File("C:/Users/user/Desktop/selenium/shre.png"));
		
	}

}
