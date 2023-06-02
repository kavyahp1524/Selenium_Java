package shree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mxplayer {//assigning web url using string
	WebDriver driver;
	String mxurl="https://www.mxplayer.in";
	
	@BeforeTest
	public void tc1() throws InterruptedException{
		WebDriverManager.chromedriver().setup();//pre requisite
		driver=new ChromeDriver();
		driver.manage().window().maximize();//maximizing the opened web
		driver.get(mxurl);//launching web browser
		Thread.sleep(5000);
	}
	@Test(enabled =false)
	public void tc2() throws InterruptedException{//verifying and getting web title in console 
		String exp="MX Player - Play Music Videos, Watch Movies, TV Shows, Web Series, Short Films & More";
		String act=driver.getTitle();
		Assert.assertEquals(exp, act);
		System.out.println(driver.getTitle());
		Thread.sleep(5000);

	}

	@Test(enabled = false)
	public void tc3() throws InterruptedException {//verifying 
		WebElement lclick=driver.findElement(By.className("login-button"));
		if (lclick.isDisplayed()==true) {
			lclick.click();	
			Thread.sleep(5000);
		}
	}
	
	@Test(enabled = false)
	public void tc4() throws InterruptedException {
		Thread.sleep(5000);
		WebElement lpage=driver.findElement(By.cssSelector("div.modal-content"));
		if (lpage.isDisplayed()==true) {
			System.out.println(lpage.getText());
			Thread.sleep(10000);
			}
		}

	@Test (enabled = false)
	public void tc5() throws InterruptedException {
		WebElement lskip=driver.findElement(By.className("skip-now"));
		if (lskip.isDisplayed()==true) {
			lskip.click();
			Thread.sleep(5000);
		}
	}
	
	
	@Test (enabled=false)
	public void tc6() throws InterruptedException {
		WebElement lnumber=driver.findElement(By.className("phone-input"));
		if (lnumber.isDisplayed()==true) {
			lnumber.sendKeys("7019060912");
			Thread.sleep(5000);
			
		}
	}
	@Test (enabled=false)
	public void tc7() throws InterruptedException {
		WebElement lnext=driver.findElement(By.className("submit"));
		if (lnext.isDisplayed()==true) {
			lnext.click();
			Thread.sleep(5000);
			
		}
	}
	@Test(enabled = false)
	public void tc8() throws InterruptedException {
		WebElement lotp=driver.findElement(By.className("enter-otp"));
		if (lotp.isDisplayed()==true) {
			System.out.println(lotp.getText());
			Thread.sleep(5000);
			
		}
	}
	@Test(enabled=false)
	public void tc9() throws InterruptedException {
		WebElement lotpfill=driver.findElement(By.className("otp-field"));
		if (lotpfill.isDisplayed()==true) 
		{				Thread.sleep(5000);

			WebElement lotpfill0=driver.findElement(By.xpath("//input[@data-index='0']"));
			if (lotpfill0.isDisplayed()==true) {
				lotpfill0.sendKeys("1");
				Thread.sleep(1000);}
			
			WebElement lotpfill1=driver.findElement(By.xpath("//input[@data-index='1']"));
			if (lotpfill1.isDisplayed()==true) {
				lotpfill1.sendKeys("1");
				Thread.sleep(1000);}
				
				WebElement lotpfill2=driver.findElement(By.xpath("//input[@data-index='2']"));
				if (lotpfill2.isDisplayed()==true) {
					lotpfill2.sendKeys("6");
					Thread.sleep(1000);}
					
					WebElement lotpfill3=driver.findElement(By.xpath("//input[@data-index='3']"));
					if (lotpfill3.isDisplayed()==true) {
						lotpfill3.sendKeys("9");
						Thread.sleep(10000);
						}
					}
	}
	
	@Test(enabled = false)
	public void tc10() throws InterruptedException {
		Thread.sleep(5000);
		WebElement lloginb=driver.findElement(By.cssSelector("button.submit"));
		if (lloginb.isDisplayed()==true) {
			lloginb.getText();
			
		}
	}
	@Test(enabled=false)
	public void tc11() {
		WebElement glog=driver.findElement(By.cssSelector("div.google"));
		glog.getText();
	}
	
	@Test(enabled=true)
	public void tc12() { 
		WebElement search=driver.findElement(By.cssSelector("svg.hc_search"));
		if(search.isDisplayed()==true) {
			search.click();
		}
	}
	@Test(enabled=true)
	public void tc13() { 
		WebElement searchm=driver.findElement(By.cssSelector("div.sc_input"));
		if(searchm.isDisplayed()==true) {
			searchm.sendKeys("kgf");
		}
	}
	
}
