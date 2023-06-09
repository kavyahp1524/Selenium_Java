package Assesment;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.MenuKeyEvent;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class apna {
	
	WebDriver driver;
	String url="https://apna.co";
	
	@BeforeTest
	public void tc1() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(5000);
	}
	//@Test(enabled =true,priority=0)
	public void tc2() throws InterruptedException{//verifying and getting web title in console 
		String exp="Search Jobs Online | Hire Candidates | Post a Job for Free | apna.co";
		String act=driver.getTitle();
		Thread.sleep(5000);
		Assert.assertEquals(exp,act);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(5000);
	    
		List<WebElement>links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++) {
	    System.out.println(links.get(i).getText());}
		Thread.sleep(6000);
        
	}
	//@Test(enabled=true,priority=1)
		public void actions() throws InterruptedException{
			Thread.sleep(5000);
			Actions act=new Actions(driver);  
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
		    Thread.sleep(6000);
	}
	
	//@Test(enabled=true,priority=2)
	public void dropdown() throws InterruptedException, AWTException{//verifying search for a job slot using robot action
		driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[2]")).click();
		 Robot rc=new Robot();
		    rc.keyPress(MenuKeyEvent.VK_DOWN);
		    rc.keyPress(MenuKeyEvent.VK_ENTER);
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[4]")).click();
		    rc.keyPress(MenuKeyEvent.VK_DOWN);
		    rc.keyPress(MenuKeyEvent.VK_ENTER);
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[6]")).click();
		    rc.keyPress(MenuKeyEvent.VK_DOWN);
		    rc.keyPress(MenuKeyEvent.VK_ENTER);
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//button[@class='Button__ButtonBase-sc-16usg3d-0 gajCau SearchJob__SearchButton-sc-1dfoa9d-4 enTfWh']")).click();
		    Thread.sleep(5000);
	}
	
	//@Test(enabled=true,priority=3)
	public void contextclick() throws InterruptedException, AWTException{//redirecting to home page using context click method 
	    
		Actions act=new Actions(driver);
	    act.contextClick().build().perform();
	    Thread.sleep(5000);
	    
	    Robot rc=new Robot();
	    rc.keyPress(MenuKeyEvent.VK_DOWN);
	    rc.keyPress(MenuKeyEvent.VK_ENTER);
	    Thread.sleep(5000);
	}
	
	//@Test(enabled=true,priority=4)
	public void tabhandling() throws InterruptedException, AWTException{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_UP).build().perform();    
	    Thread.sleep(5000);
	    WebElement web= driver.findElement(By.xpath("(//div[@class='JobTypesSection__ArrowIconContainer-sc-1lzepzq-3 igPCqu'])[1]"));
	    act.contextClick(web).build().perform();
	    Thread.sleep(5000);
	    
	    Robot rc=new Robot();//open new tab
	    rc.keyPress(MenuKeyEvent.VK_DOWN);
	    rc.keyPress(MenuKeyEvent.VK_ENTER);
	    Thread.sleep(6000);
	    
	    ArrayList<String> tabs1= new ArrayList<String>(driver.getWindowHandles());//switching parent tab to child tab1.
		driver.switchTo().window(tabs1.get(1));
		Thread.sleep(5000);
		ArrayList<String> tabs2= new ArrayList<String>(driver.getWindowHandles());//switching back to parent tab.
		driver.switchTo().window(tabs2.get(0));  
		Thread.sleep(5000);
		}
		    
		    
		  //@Test(enabled=true,priority=5)
			public void tabhadlingandsedkeys() throws InterruptedException, AWTException{
			  WebElement web2= driver.findElement(By.xpath("(//div[@class='JobTypesSection__ArrowIconContainer-sc-1lzepzq-3 igPCqu'])[2]"));
			  Actions act=new Actions(driver); 
			  act.contextClick(web2).build().perform();
			  Thread.sleep(5000);
			  
			  Robot rc=new Robot(); //open new tab
			  rc.keyPress(MenuKeyEvent.VK_DOWN);
			  rc.keyPress(MenuKeyEvent.VK_ENTER);
			  Thread.sleep(5000);
			  ArrayList<String> tab1= new ArrayList<String>(driver.getWindowHandles());//switching parent tab to child tab2
			  driver.switchTo().window(tab1.get(2));
			  Thread.sleep(5000);
				
			driver.findElement(By.xpath("(//div[@class='styles__Container-sc-1eqgvmq-0 fQVZBI'])[1]")).click();
		    Thread.sleep(5000);
		    
		    //validating if apply button is enabled or not
		    
		    WebElement app=driver.findElement(By.xpath("(//a[@class='styles__ApplyButtonContainer-sc-15yd6lj-15 eqZGPP'])[1]"));
		    Boolean bn=app.isDisplayed();
			System.out.println(bn);
			app.click();
		    Thread.sleep(5000);
		    
		    //validating login slot using boolean.
		    WebElement web=driver.findElement(By.xpath("//div[@class='styles__Content-sc-87lsob-3 vyxHN']"));
			Boolean bn1=web.isDisplayed();
			System.out.println(bn1);
			System.out.println(web.getText());
			Thread.sleep(5000);
		    
			//sending keys to login
		    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("apna");
			Thread.sleep(5000);
		    driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1234567890");
			Thread.sleep(5000);
		    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
			Thread.sleep(5000);
		    driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(5000);
			WebElement k=driver.findElement(By.xpath("//span[@class='styles__MobileErrorText-sc-87lsob-13 fUssxW']"));
			Thread.sleep(5000);
			System.out.println(k.getText());
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='styles__CloseIconWrapper-sc-87lsob-2 jHNtCr']")).click();
			Thread.sleep(5000);
			
			//close childtab2 and switching to childtab1 to close that tab and switching to parent tab
			driver.close();
			ArrayList<String> tab2= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tab2.get(1));
			Thread.sleep(5000);
			driver.close();
			ArrayList<String> tab3= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tab3.get(0));
			Thread.sleep(5000);

		
	}
	//@Test(enabled=true,priority=6)
	public void windowhandling() throws InterruptedException, AWTException, IOException{
		
		WebElement web1= driver.findElement(By.xpath("(//div[@class='JobTypesSection__ArrowIconContainer-sc-1lzepzq-3 igPCqu'])[3]"));
		Actions act=new Actions(driver);
		act.contextClick(web1).build().perform();
	    Thread.sleep(5000);
	    Robot rc=new Robot();    //open new window
	    rc.keyPress(MenuKeyEvent.VK_DOWN);
	    Thread.sleep(5000);
	    rc.keyPress(MenuKeyEvent.VK_DOWN);
	    rc.keyPress(MenuKeyEvent.VK_ENTER);
	    Thread.sleep(5000);  

	    ArrayList<String> window1= new ArrayList<String>(driver.getWindowHandles()); //redirect to parent window
		driver.switchTo().window(window1.get(1));
		driver.close();  //closing a child window
		Thread.sleep(5000);
		
		ArrayList<String> window2= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(window2.get(0));//switch back to parent tab
		Thread.sleep(5000);
		
		WebElement web2= driver.findElement(By.xpath("(//div[@class='JobTypesSection__ArrowIconContainer-sc-1lzepzq-3 igPCqu'])[4]"));
		act.contextClick(web2).build().perform();
	    Thread.sleep(5000);
	    rc.keyPress(MenuKeyEvent.VK_DOWN);
	    Thread.sleep(5000);
	    rc.keyPress(MenuKeyEvent.VK_DOWN);
	    rc.keyPress(MenuKeyEvent.VK_ENTER);
	    Thread.sleep(5000); 
	    
	    File kav=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //screenshot
		FileUtils.copyFile(kav,new File("C:/Users/user/Desktop/selenium/shree.png"));
	    Thread.sleep(5000); 
	    
	    ArrayList<String> window3= new ArrayList<String>(driver.getWindowHandles());//redirect to parent window
		driver.switchTo().window(window3.get(1));
		driver.close(); //closing a child window
		Thread.sleep(5000);
		
		ArrayList<String> window4= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(window4.get(0));
		Thread.sleep(5000);
		act.sendKeys(Keys.PAGE_UP).build().perform();    
	    act.sendKeys(Keys.PAGE_UP).build().perform();    
	    act.sendKeys(Keys.PAGE_UP).build().perform(); 
	    act.sendKeys(Keys.PAGE_UP).build().perform(); 
		Thread.sleep(5000);

	
	}
	//@Test(enabled=true,priority=8)
	public void composite() throws InterruptedException {
	    Thread.sleep(5000);
	
	    driver.findElement(By.xpath("//button[@class='Button-sc-1wu2ect-0 Header__EmployerLoginButton-sc-1eoq01k-3 hJgOPG jpzszW']")).click();
	    Thread.sleep(7000);
	
	    ArrayList<String> tab3= new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tab3.get(1));
	    Thread.sleep(5000);
	
	    WebElement q=driver.findElement(By.xpath("//input[@id='number']"));
	    Actions ac=new Actions(driver);
	    ac.moveToElement(q).click().keyDown(Keys.SHIFT).sendKeys("9061234567").doubleClick().build().perform();
	    Thread.sleep(5000);
	    
	    driver.close();
	    
	    ArrayList<String> tab2= new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tab2.get(0));
	    Thread.sleep(5000);}
	
	@Test(enabled=true,priority=9)
	public void Javascript() throws InterruptedException, IOException{
	
	JavascriptExecutor jse=((JavascriptExecutor)driver);
	jse.executeScript("document.getElementById('banner-read-more-link').click()");
    Thread.sleep(10000);
    
    ArrayList<String> tab1= new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tab1.get(1));
    Thread.sleep(5000);
    jse.executeScript("window.close()");
    Thread.sleep(5000);
    ArrayList<String> tab2= new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tab2.get(0));
	}
	//@AfterTest(enabled=true)
	public void end() {
		driver.quit();
	}

}
