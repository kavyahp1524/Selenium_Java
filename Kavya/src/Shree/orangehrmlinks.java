package Shree;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class orangehrmlinks {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Moolyaed\\Selenium\\selenium-java-4.8.0\\Chromedriver\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice");
		driver.manage().window().maximize();//used to maximize the web. 
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);//adding 5000sec timeunit to wait for loading particular web. 
		
		System.out.println(driver.getTitle());//to get web name in console. 
		System.out.println(driver.getCurrentUrl());//to get web url in console.
Thread.sleep(5000);
		List<WebElement>links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
		}
				
	}

}
