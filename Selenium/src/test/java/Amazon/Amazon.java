package Amazon;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
	WebDriver wd;
	String url ="https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_5km84u9k2k_e&adgrpid=61666692631&hvpone=&hvptwo=&hvadid=486447282128&hvpos=&hvnetw=g&hvrand=7255242578040691389&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007773&hvtargid=kwd-304880464215&hydadcr=14450_2154367";
	
	@BeforeTest
	public void Launch_website() {
		
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get(url);
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled = true, priority = 0)
	public void Validation() throws InterruptedException {
		
		String exp = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String act = wd.getTitle();
		Assert.assertEquals(act, exp);
		Thread.sleep(3000);
		
		System.out.println(wd.getTitle());
		System.out.println(wd.getCurrentUrl());
		
		Thread.sleep(3000);
		
		// Finding Links in amazon website
		List<WebElement> links = wd.findElements(By.tagName("*"));
		System.out.println(links.size());
		
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
		}
		
		Thread.sleep(5000);
		
	}
	

}
