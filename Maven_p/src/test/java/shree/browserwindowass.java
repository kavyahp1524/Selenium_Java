package shree;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserwindowass {
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
	
    WebElement k=driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.home-content div.home-body div.category-cards div.card.mt-4.top-card:nth-child(3) div:nth-child(1) > div.card-body"));
	k.click();
	Thread.sleep(5000);
	
	act.sendKeys(Keys.PAGE_DOWN).build().perform();//downing webpage/scrolling
    Thread.sleep(6000);
	
    WebElement br=driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]"));
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

