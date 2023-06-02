package RS_pro;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rahulshetty {
	WebDriver wd;
	String url = "https://rahulshettyacademy.com/AutomationPractice/";
	
	@BeforeTest
	public void BT() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get(url);
		Thread.sleep(5000);
	}
	
	@Test(enabled = true, priority = 0)
	public void Radio_Button_Example() throws InterruptedException {
		
		
		WebDriverWait w = new WebDriverWait(wd,10);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='radioButton'])[1]"))).click();
	           
		
		//wd.findElement(By.xpath("(//*[@class='radioButton'])[1]")).click();
		//Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='radioButton'])[2]")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='radioButton'])[3]")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='radioButton'])[1]")).click();
		Thread.sleep(3000);
	}
	//@Test(enabled = true, priority = 1)
	public void Suggession_Class_Example() throws InterruptedException, AWTException {
		
		 wd.findElement(By.xpath("//*[@class='inputs ui-autocomplete-input']")).sendKeys("India");
		 Thread.sleep(3000);
		
		 Robot rc=new Robot();
		 rc.keyPress(MenuKeyEvent.VK_DOWN);
		 Thread.sleep(3000);
		 rc.keyPress(MenuKeyEvent.VK_DOWN);
		 Thread.sleep(3000);
		 rc.keyPress(MenuKeyEvent.VK_ENTER);
		
	}
	//@Test(enabled = true, priority = 2)
	public void Dropdown_Example() throws InterruptedException {
		
		WebElement Dp = wd.findElement(By.xpath("//*[@id='dropdown-class-example']"));
		Thread.sleep(3000);
		
		Select dp = new Select(Dp);
		dp.selectByValue("option1");
		Thread.sleep(3000);
		dp.selectByValue("option2");
		Thread.sleep(3000);
		dp.selectByValue("option3");
		Thread.sleep(3000);
	}
	
	//@Test(enabled = true, priority = 3)
	public void Checkbox_Example() throws InterruptedException {
		
		wd.findElement(By.xpath("//*[@id='checkBoxOption1']")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@id='checkBoxOption1']")).click();
		Thread.sleep(3000);
		
		wd.findElement(By.xpath("//*[@id='checkBoxOption2']")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@id='checkBoxOption2']")).click();
		Thread.sleep(3000);
		
		wd.findElement(By.xpath("//*[@id='checkBoxOption3']")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@id='checkBoxOption3']")).click();
		Thread.sleep(3000);
		
		wd.findElement(By.xpath("//*[@id='checkBoxOption1']")).click();
		Thread.sleep(5000);
	}

	//@Test(enabled = true, priority = 4)
	public void Switch_Window_Example() throws InterruptedException {
		
		wd.findElement(By.xpath("//*[@id='openwindow']")).click();
		Thread.sleep(8000);
		
		ArrayList<String> window= new ArrayList<String>(wd.getWindowHandles()); //redirect to parent window
		wd.switchTo().window(window.get(1));
		wd.close();  //closing a child window
		Thread.sleep(5000);
		
		ArrayList<String> w= new ArrayList<String>(wd.getWindowHandles());
		wd.switchTo().window(w.get(0));
		Thread.sleep(5000);

	}
	
	//@Test(enabled = true, priority = 5)
	public void Switch_Tab_Example() throws InterruptedException {
		
		wd.findElement(By.xpath("//*[@id='opentab']")).click();
		Thread.sleep(5000);
		ArrayList<String> Tab= new ArrayList<String>(wd.getWindowHandles()); //redirect to parent window
		wd.switchTo().window(Tab.get(1));
		wd.close();  //closing a child window
		Thread.sleep(5000);
		
		ArrayList<String> t= new ArrayList<String>(wd.getWindowHandles());
		wd.switchTo().window(t.get(0));
		Thread.sleep(5000);
	}
	
	//@Test(enabled = true, priority = 6)
	public void Switch_To_Alert_Example() throws InterruptedException {
		wd.findElement(By.xpath("//*[@id='name']")).sendKeys("Kavyashree");
		Thread.sleep(5000);
		
		wd.findElement(By.xpath("//*[@id='alertbtn']")).click();
		Thread.sleep(5000);
		wd.switchTo().alert().accept();
		
		wd.findElement(By.xpath("//*[@id='confirmbtn']")).click();
		Thread.sleep(5000);
		wd.switchTo().alert().dismiss();
		Thread.sleep(3000);
		
	}

	//@Test(enabled = true, priority = 7)
	public void	Page_down() {
		
		Actions pd = new Actions(wd);
		pd.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	//@Test(enabled = true, priority = 8)
	public void	Element_Displayed_Example() throws InterruptedException {
		
		wd.findElement(By.xpath("//*[@id='hide-textbox']")).click();
		Thread.sleep(3000);
		
		WebElement ds = wd.findElement(By.xpath("//*[@id='show-textbox']"));
		if(ds.isEnabled()==true) {
			ds.click();
		}
		
		Thread.sleep(3000);
		
		WebElement ds1 = wd.findElement(By.xpath("//*[@id='displayed-text']"));
		if(ds1.isDisplayed()==true) {
			ds1.sendKeys("Ok");
		}
		
		Thread.sleep(3000);
	}
	
	//@Test(enabled = true, priority = 9)
	public void Web_Table_Fixed_header() throws AWTException, InterruptedException {
		
		wd.findElement(By.xpath("//*[@class='tableFixHead']")).click();
		Thread.sleep(5000);
		
		Robot du = new Robot();
		du.keyPress(MenuKeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		
		du.keyPress(MenuKeyEvent.VK_PAGE_UP);
		Thread.sleep(3000);
	}
	
	//@Test(enabled = true, priority = 10)
	public void	Page_down1() throws InterruptedException {
		
		Actions pd = new Actions(wd);
		
		pd.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);
	}
	
	//@Test(enabled = true, priority = 11)
	public void	Mouse_Hover_Example() throws InterruptedException, AWTException {
		
		WebElement m = wd.findElement(By.xpath("//*[@id='mousehover']"));
		Thread.sleep(5000);
		Actions mo = new Actions(wd);
		Thread.sleep(5000);
		mo.moveToElement(m).build().perform();

		Thread.sleep(5000);

		Robot du = new Robot();
		du.keyPress(MenuKeyEvent.VK_DOWN);
		mo.click().build().perform();
		Thread.sleep(3000);

		
	}
	
	//@Test(enabled = true, priority = 12)
	public void	Page_down2() {
		
		Actions pd = new Actions(wd);
		pd.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	//@Test(enabled = true, priority = 13)
	public void	Mouse_Hover_Example2() throws InterruptedException, AWTException {
		
		WebElement m = wd.findElement(By.xpath("//*[@id='mousehover']"));
		Thread.sleep(3000);
		Actions mo = new Actions(wd);
		Thread.sleep(3000);
		mo.moveToElement(m).build().perform();

		Thread.sleep(3000);

		Robot du = new Robot();
		du.keyPress(MenuKeyEvent.VK_DOWN);
		Thread.sleep(3000);
		du.keyPress(MenuKeyEvent.VK_DOWN);
		mo.click().build().perform();
		Thread.sleep(3000);
	}
	
	
	//@Test(enabled = true, priority = 14)
	public void Home() throws AWTException, InterruptedException {
		
		wd.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		Thread.sleep(5000);
	
		Actions act=new Actions(wd);
	    act.contextClick().build().perform();
	    Thread.sleep(5000);
	    Robot rc=new Robot();
	    rc.keyPress(MenuKeyEvent.VK_DOWN);
	    rc.keyPress(MenuKeyEvent.VK_ENTER);
	    Thread.sleep(5000);
	}
	
	@AfterTest(enabled=true)
	
	public void end() {
		wd.quit();
	}
}