package shree;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eg {
	WebDriver driver;
	String url1 ="https://demoqa.com";

@BeforeTest //launching and getting website
public  void tc1() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();//launching the browser
	driver.get(url1);//initiating a url
	driver.manage().window().maximize();//used to maximize the web. 
	Thread.sleep(5000);
}

@Test(enabled= true)
public void tc3() throws InterruptedException, AWTException {
	Thread.sleep(5000);
	Actions act=new Actions(driver);
    
	act.sendKeys(Keys.PAGE_DOWN).build().perform();//downing webpage/scrolling
    Thread.sleep(6000);
	
    WebElement k=driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][3]"));
	k.click();
	Thread.sleep(5000);
	
	act.sendKeys(Keys.PAGE_DOWN).build().perform();//downing webpage/scrolling
    Thread.sleep(3000);
	
    WebElement br=driver.findElement(By.cssSelector("li#item-0"));
	br.click();
	WebElement nw = driver.findElement(By.id("tabButton"));
	nw.click();
	Thread.sleep(3000);
	
	ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));
	driver.get("https://www.facebook.com");
	Thread.sleep(5000);
	
	ArrayList<String> tabs1= new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs1.get(0));
	WebElement nw1=driver.findElement(By.id("tabButton"));
	nw1.click();
	Thread.sleep(5000);

	ArrayList<String> tabs2= new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs2.get(2));
	driver.get("https://mail.google.com/mail/u/0/#inbox");
	Thread.sleep(5000);
	
	ArrayList<String> tabs3= new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs2.get(0));
	driver.get("https://www.youtube.com");
}


}
