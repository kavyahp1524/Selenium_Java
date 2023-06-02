package HRM.TestComponents;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
		protected WebDriver wd;
       
		@BeforeSuite()
		public WebDriver initialization() throws IOException {
			
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();		  
			wd.manage().window().maximize();
			wd.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			return wd;
		}
	
		@AfterSuite
		public void Quit() {
			wd.quit();
		}

}



