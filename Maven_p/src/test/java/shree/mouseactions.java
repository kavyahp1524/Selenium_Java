package shree;

import java.awt.AWTException;
import java.awt.Menu;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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


public class mouseactions {
	WebDriver driver;
	String url ="https://www.bput.ac.in";
	String url1 ="https://www.google.com/";

@BeforeTest //launching and getting website
public  void tc1() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();//launching the browser
	driver.get(url1);//initiating a url
	driver.manage().window().maximize();//used to maximize the web. 

}
//@Test
public void tc2() throws InterruptedException {
	WebElement web=driver.findElement(By.className("has_child"));
	if(web.isDisplayed()==true) {
		System.out.println(web.getText());}	
	Actions action = new Actions(driver);
	action.moveToElement(web).build().perform();
	Thread.sleep(5000);
	WebElement web1=driver.findElement(By.linkText("History"));
	if(web1.isDisplayed()==true) {
		System.out.println(web1.getText());
		web1.click();}
}
@Test
public void tc3() throws InterruptedException, AWTException {
	WebElement k=driver.findElement(By.linkText("Gmail"));
    Actions act=new Actions(driver);
    act.contextClick(k).build().perform();
    Thread.sleep(5000);
   // act.sendKeys(Keys.PAGE_DOWN).build().perform();//downing webpage/scrolling 
    Robot rc=new Robot();
    rc.keyPress(MenuKeyEvent.VK_DOWN);
    rc.keyPress(MenuKeyEvent.VK_ENTER);
    Thread.sleep(5000);
    rc.keyPress(MenuKeyEvent.VK_CONTROL);
    rc.keyPress(MenuKeyEvent.VK_TAB);
    Thread.sleep(5000); 
    String parent=driver.getWindowHandle(); 
    System.out.println(parent);    //get parent tab id
    Set<String> tabs=driver.getWindowHandles();
    System.out.println(tabs);//getting both parent and child id's
    for(String handes:tabs) {
    	driver.switchTo().window(handes);
    	System.out.println(driver.getTitle());//getting both parent and child tab title

    }
    driver.switchTo().window(parent);
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
}
}
