package shree;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.trace.Span;

public class Dropdown {
		WebDriver driver;
		String url1 ="https://rahulshettyacademy.com/dropdownsPractise";

	@BeforeTest //launching and getting website
	public  void tc1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();//launching the browser
		driver.get(url1);//initiating a url
		driver.manage().window().maximize();//used to maximize the web. 
		Thread.sleep(5000);
	}

	@Test(enabled = true,priority = 0)
	public void tc2() throws InterruptedException 
	{
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Bengaluru (BLR)')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@text='Chennai (MAA)'])[2]")).click();
		Thread.sleep(5000);	
	}
	@Test (enabled = true,priority = 1)
	public void date() throws InterruptedException {
		//Thread.sleep(10000);
		driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
		String month="February 2023";
		String date="18";
		
		Thread.sleep(5000);
		 while(true)
		{
		String text=driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]")).getText();
		
		if(text.equals(month)) {
			break;
		}
		else {
			driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
	}
		 List<WebElement> alldates=driver.findElements(By.xpath("//body[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td/a[1]"));
		 for(WebElement e:alldates)
		 {
		String k=e.getText();
		String l[]=k.split("\n");
		if(l[0].equals(date))
		{e.click();
		break;
		}
		}
	}
	@Test(enabled = true,priority = 2)
	public void returndate() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.name("ctl00$mainContent$view_date2")).click();
		String month="February 2023";
		String date="20";
		Thread.sleep(5000);
		while(true) {
			String text=driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]")).getText();
			if(text.equals(month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("(//a[@class='ui-datepicker-next ui-corner-all'])")).click();
			}
		}
		List <WebElement> alldates=driver.findElements(By.xpath("//body[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td/a[1]"));
		for(WebElement e:alldates) {
			String k=e.getText();
			String l[]=k.split("\n");
			if(l[0].equals(date))
			{e.click();
			break;
			}
		}
		Thread.sleep(6000);
	}
	@Test(enabled = true,priority = 3)
	public void click() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@id='hrefIncChd']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@id='hrefIncInf']")).click();
			}
	@Test(enabled= true,priority = 4,invocationCount = 3)
	public void staticdropdown() throws InterruptedException, AWTException {
		WebElement k= driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select dropdown=new Select(k);
		//dropdown.selectByVisibleText("AED");
		//dropdown.selectByIndex(3);
		dropdown.selectByValue("INR");
		Thread.sleep(5000);
	}
	@Test(enabled = true,priority = 5)
	public void click2() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

	}
	}