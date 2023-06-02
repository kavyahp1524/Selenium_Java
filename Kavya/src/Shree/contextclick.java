package Shree;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class contextclick {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Moolyaed\\Selenium\\selenium-java-4.8.0\\Chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		String url ="https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		WebElement web =driver.findElement(By.linkText("Gmail"));
	    Actions act=new Actions(driver);
	    act.contextClick(web).build().perform();
	}

}
