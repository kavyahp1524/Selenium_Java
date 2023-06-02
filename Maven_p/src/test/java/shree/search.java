package shree;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class search {
	WebDriver driver;
	String url1="https://www.amazon.in";
	String url2="https://www.facebook.com";
	String url3="https://mail.google.com";
	@BeforeTest
	public void tc0() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();//launching the browser
		    driver.get(url1);//initiating a url
		    driver.manage().window().maximize();//used to maximize the web. 
		    Thread.sleep(5000);

}
	@Test
	public void tc1() {
		WebElement q=driver.findElement(By.id("twotabsearchtextbox"));
		Actions ac=new Actions(driver);
		ac.moveToElement(q).click().keyDown(Keys.SHIFT).sendKeys("sparks").doubleClick().build().perform();
	}

	}



