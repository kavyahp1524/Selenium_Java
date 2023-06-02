package OrangeHR;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.protocol.RequestDefaultHeaders;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRM {
	
   WebDriver wd;
   String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
   
   @BeforeTest
   public void Launching() {
	   
	   WebDriverManager.chromedriver().setup();
	   wd = new ChromeDriver();
	   wd.manage().window().maximize();
	   wd.get(url);
	   wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   }
   
   @Test(enabled=true, priority =0)
   public void Validation() throws InterruptedException {
	   
	  
	   String exp = "OrangeHRM";
	   String act = wd.getTitle();
	   Assert.assertEquals(act, exp);
	   
	   Thread.sleep(3000);
	   System.out.println(wd.getTitle());
	   
	   //finding links in orangehrm page
	   
	   List<WebElement> links = wd.findElements(By.tagName("a"));
       System.out.println(links.size());
       for(int i=0;i<links.size();i++) {
    	   System.out.println(links.get(i).getText());
       }
       
       Thread.sleep(5000);
       
   }
   
   @Test(enabled=true, priority = 1, dataProvider = "dp")
   public void login(String a, String b) throws InterruptedException {
	   
	   wd.findElement(By.xpath("//*[@name='username']")).sendKeys(a);
	   Thread.sleep(1000);
	   wd.findElement(By.xpath("//*[@name='password']")).sendKeys(b);
	   Thread.sleep(1000);
	   wd.findElement(By.xpath("//*[@type='submit']")).click();
	   Thread.sleep(5000);
	
   }

   @DataProvider
   public Object[][] dp(){
	   
	   return new Object[][] { //new Object[] {"Adm","admin@123"}, 
		                       //new Object[] {"Admin","admin"},  
		                       new Object[] {"Admin","admin123"}};
   }
   
   @Test(enabled=true, priority = 2)
   public void Scrolling() throws AWTException, InterruptedException {
	   Thread.sleep(3000);
	   Robot rc = new Robot();
	   rc.keyPress(MenuKeyEvent.VK_DOWN);
	   Thread.sleep(5000);
   }
   
   @Test(enabled=true, priority = 3)
   public void Composite_action() throws InterruptedException {
	   
	   Thread.sleep(5000);
	   WebElement k = wd.findElement(By.xpath("//*[@placeholder='Search']"));
	   
	   Actions a =new Actions(wd);
	   Thread.sleep(5000);
	   a.moveToElement(k).click().sendKeys("Admin").doubleClick().build().perform();
	   Thread.sleep(5000);
   }

   
   
  @Test(enabled = true,priority = 4)
   public void Tab_handling() throws InterruptedException, AWTException {
	   WebElement k = wd.findElement(By.className("oxd-main-menu-item--name"));
	   Thread.sleep(5000);
	   
	   Actions a =new Actions(wd);
	   a.contextClick(k).build().perform();
	   
	   Robot rc = new Robot();
	   rc.keyPress(MenuKeyEvent.VK_DOWN);
	   rc.keyPress(MenuKeyEvent.VK_ENTER);
	   Thread.sleep(8000);
	  
	   ArrayList<String> Tab= new ArrayList<String>(wd.getWindowHandles()); //redirect to parent window
	   wd.switchTo().window(Tab.get(1));
	   Thread.sleep(5000);
	   wd.close();
	   Thread.sleep(5000);
	   
	   ArrayList<String> Tab1 = new ArrayList<String>(wd.getWindowHandles());
	   wd.switchTo().window(Tab1.get(0));
	   Thread.sleep(6000);

   }
   
   @Test(enabled =true,priority = 5)
   public void Window_handling() throws InterruptedException, AWTException {
	   
	   WebElement k = wd.findElement(By.className("oxd-main-menu-item--name"));
	   Thread.sleep(6000);
	   
	   Actions a = new Actions(wd);
	   a.contextClick(k).build().perform();
	   
	   Robot rc =new Robot();
	   rc.keyPress(MenuKeyEvent.VK_DOWN);
	   rc.keyPress(MenuKeyEvent.VK_DOWN);
	   rc.keyPress(MenuKeyEvent.VK_ENTER);
	   Thread.sleep(8000);
	   
	   ArrayList<String> W = new ArrayList<String>(wd.getWindowHandles());
	   wd.switchTo().window(W.get(1));
	   Thread.sleep(5000);
	   wd.close();
	   Thread.sleep(5000);

	   ArrayList<String> W1 = new ArrayList<String>(wd.getWindowHandles());
	   wd.switchTo().window(W1.get(0));
	   Thread.sleep(5000);
	   
   }
   
   @Test(enabled=true, priority = 6)
   public void Screen_shot() throws IOException, InterruptedException {
	   
         File kav = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(kav, new File("C:/Users/user/Desktop/selenium/shree.png"));
         Thread.sleep(5000);
   }
   
   @Test(enabled=true,priority = 7)
   public void logout() throws InterruptedException {
	   
	   Thread.sleep(5000);
	   
	   wd.findElement(By.className("oxd-userdropdown-icon")).click();
	   Thread.sleep(3000);
	   
	   WebElement k =wd.findElement(By.xpath("(//*[@class='oxd-userdropdown-link'])[4]"));
	   Thread.sleep(3000);
	   Actions mo = new Actions(wd);
	   mo.moveToElement(k).click().build().perform();
	   Thread.sleep(5000);

   }
	   
   @Test(enabled = true, priority = 8)   
   public void Java_script() throws InterruptedException {
	   
	   wd.findElement(By.className("orangehrm-login-forgot-header")).click();
	   Thread.sleep(5000);
	   
	   JavascriptExecutor jse =((JavascriptExecutor)wd);
	   jse.executeScript("document.getElementsByName('username').values='Admin'");
	   
   }
   
  //@AfterTest
   public void end() {
	   wd.quit();
   }
    
}

