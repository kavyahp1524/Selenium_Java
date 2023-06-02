package Datadriven;

	
	import java.io.File;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class extent {	
	    
	    ExtentReports extent;
	    WebDriver wd;
	    ExtentTest logger;
	    
	    
	    @BeforeTest
	    public void BT()
	    {
	    
	    extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/kavya.html",true);//i try to save the html file in the test output folder by the name of moolya
	    extent.loadConfig(new File(System.getProperty("user.dir")+"//src//test//java//extent.java")); //i try to load load configurations to the html file by saving it in the src/test/java folder.
	    
	    
	    WebDriverManager.chromedriver().setup();
	     wd = new ChromeDriver();
	     
	    }
	    
	    
	  @Test
	  public void Login() throws InterruptedException 
	  
	  {
	      
	      
	      logger = extent.startTest("madhu");// this indicates that logger will have a influence on the test
	      
	      wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	      logger.log(LogStatus.PASS, "web page has opened");// in the report we will have a record of the steps performed
	    
	      Thread.sleep(3000);
	      
	      String title = wd.getTitle();
	      logger.log(LogStatus.PASS, title);
	      
	      Assert.assertEquals("madhu", "madhu");
	      logger.log(LogStatus.PASS, "Assert Passed");
	      
	      Thread.sleep(3000);
	      
	      wd.findElement(By.name("username")).sendKeys("Admin");
	      logger.log(LogStatus.PASS, "username is entered");
	      
	       wd.findElement(By.name("password")).sendKeys("admin123");
	      logger.log(LogStatus.PASS, "password is entered");
	      
	      Thread.sleep(3000);
	      
	      wd.findElement(By.xpath("//*[@type='submit']")).click();
	      logger.log(LogStatus.PASS, "login successful");
	  }
	  
	      @Test(dependsOnMethods = "Login")
	      public void Logout() throws InterruptedException
	      {
	          
	          Thread.sleep(3000);
	          
	          wd.findElement(By.xpath("//*[@class='oxd-userdropdown-img']")).click();
	          logger.log(LogStatus.PASS, "clicking on the dropdown");
	         
	          Thread.sleep(3000);
	          
	          wd.findElement(By.linkText("Logout")).click();
	          logger.log(LogStatus.PASS, "Logged out");
	      }
	      
	      @AfterTest
	      public void AT()
	      {
	          wd.close();
	          extent.endTest(logger);// this will end the logger function
	          
	          extent.flush(); //this will flush all the logged data in to the html report
	          
	          extent.close(); //this will give an end to the report
	      }
	      
	      
	}   
	 
	

