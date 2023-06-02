package Datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.tool.XMLBeanXSTCHarness;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class method {
	WebDriver wd;
	String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeTest
	public void bt() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.get(url);
		wd.manage().window().maximize();
		Thread.sleep(5000);
		
	}
   
	@Test
    public void tc1() throws InvalidFormatException, IOException, InterruptedException {
		
		File xl= new File("C://Users//user//Downloads//Untitled spreadsheet.xlsx/");
	    FileInputStream xs = new FileInputStream(xl);
	    XSSFWorkbook book = new XSSFWorkbook(xs);
	    XSSFSheet sheet = book.getSheet("Sheet1");
	    
	    int rowcount = sheet.getLastRowNum();//it will cover whole row in the sheet
	    
	    for(int i=0;i<=rowcount;i++)
	    {
	    	String username = sheet.getRow(i).getCell(0).getStringCellValue();
	    	String password = sheet.getRow(i).getCell(1).getStringCellValue();
	    	Thread.sleep(3000);
	    	wd.findElement(By.name("username")).sendKeys(username);
	    	Thread.sleep(3000);
	    	wd.findElement(By.name("password")).sendKeys(password);
	    	Thread.sleep(3000);
	    	wd.findElement(By.className("oxd-button")).click();
	    	Thread.sleep(3000);
	    	
	    	if(wd.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"))
	    	{
	    		wd.findElement(By.className("oxd-userdropdown")).click();
	    		Thread.sleep(5000);
	    		wd.findElement(By.linkText("Logout")).click();
	    		Thread.sleep(5000);
	    		
	    	}
	    	else if(wd.findElement(By.cssSelector("p.oxd-text")).isDisplayed())
	    		Thread.sleep(5000);
	    	
	    	{
	    		for(int j=i+1;j<=rowcount;j++) 
	    		{
	    			String username1 = sheet.getRow(j).getCell(0).getStringCellValue();
	    	    	String password1 = sheet.getRow(j).getCell(1).getStringCellValue();
	    	    	Thread.sleep(2000);
	    	    	wd.findElement(By.name("username")).sendKeys(username1);
	    	    	Thread.sleep(2000);
	    	    	wd.findElement(By.name("password")).sendKeys(password1);
	    	    	Thread.sleep(2000);
	    	    	wd.findElement(By.className("oxd-button")).click();
	    	    	
	    	    	if(wd.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"))
	    	    	{
	    	    		System.out.println("Error");
	    	    		Thread.sleep(2000);
	    	    		wd.findElement(By.className("oxd-userdropdown")).click();
	    	    		Thread.sleep(5000);
	    	    		wd.findElement(By.linkText("Logout")).click();
	    	    		Thread.sleep(5000);
	    	    		
	    	    	}
	    	    		
	    		}
	    		
	    	}

	    	break;
	    }
	    
	    
}
	@AfterTest
	public void end() {
	 wd.quit();
	}
	
}
