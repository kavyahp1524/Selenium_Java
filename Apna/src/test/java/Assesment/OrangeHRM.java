package Assesment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	
	WebDriver driver;
	String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";//

@BeforeTest //launching and getting website
public  void tc1() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();//launching the browser
	driver.get(url);//initiating a url
	driver.manage().window().maximize();//used to maximize the web. 

}
@Test //validating title and url by using assertion method
public void tc2() throws InterruptedException {
	String exp_title="OrangeHRM"; // assigning expected title
	String act_title=driver.getTitle(); //getting actual title
	Assert.assertEquals(act_title, exp_title); //comparing expected and actual title
	System.out.println(driver.getTitle());//getting actual title in console

	System.out.println(driver.getCurrentUrl());//getting actual url in console
	
	Thread.sleep(5000);

}
@Test//validating login slot whether is displayed or not by using boolean method
public void tc3() throws InterruptedException {
	WebElement web=driver.findElement(By.cssSelector("div.orangehrm-login-slot"));
	Boolean bn=web.isDisplayed();
	System.out.println(bn);
	System.out.println(web.getText());
	Thread.sleep(5000);
}	
	
@Test//checking the functionality username,password, login&logout button  by entering correct wrong&name password and getting popup message in console

public void tc4() throws InterruptedException  {
	Thread.sleep(5000);
	
	//validating username box displayed in orangehrm 
	WebElement web= driver.findElement(By.name("username"));
	if(web.isDisplayed()==true) {
		web.sendKeys("Admi");}		
	
	//validating password box displayed in orangehrm
	WebElement web1=driver.findElement(By.name("password"));
	if(web1.isDisplayed()==true) {
		web1.sendKeys("admin123");}
	
	Thread.sleep(5000);

	
	//validating login button displayed in orangehrm
	WebElement web2=driver.findElement(By.className("oxd-button"));
	if(web2.isDisplayed()==true) {
		web2.click();}
	
	Thread.sleep(5000);


	//validating and getting displayed popup message in orangehrm
	WebElement web3=driver.findElement(By.cssSelector("p.oxd-text"));
	Boolean bn=web3.isDisplayed();
	System.out.println(bn);
	System.out.println(web3.getText());
	Thread.sleep(5000);

		
}

@Test//checking the functionality username,password, login&logout button  by entering correct name&wrong password and getting popup message in console

public void tc5() throws InterruptedException  {
	Thread.sleep(5000);
	
	//validating username box displayed in orangehrm 
	WebElement web= driver.findElement(By.name("username"));
	if(web.isDisplayed()==true) {
		web.sendKeys("Admin");}		
	
	//validating password box displayed in orangehrm
	WebElement web1=driver.findElement(By.name("password"));
	if(web1.isDisplayed()==true) {
		web1.sendKeys("admin12");}
	
	
	//validating login button displayed in orangehrm
	WebElement web2=driver.findElement(By.className("oxd-button"));
	if(web2.isDisplayed()==true) {
		web2.click();}
	
	Thread.sleep(5000);

	//validating and getting displayed popup message in orangehrm
	WebElement web3=driver.findElement(By.cssSelector("p.oxd-text"));
	Boolean bn=web3.isDisplayed();
	System.out.println(bn);
	System.out.println(web3.getText());
	
	Thread.sleep(5000);

		
}
@Test//checking the functionality username,password,login&logout button  by entering correct name&password 
public void tc6() throws InterruptedException {
	
	//validating username box displayed in orangehrm 
	WebElement web= driver.findElement(By.name("username"));
	if(web.isDisplayed()==true) {
		web.sendKeys("Admin");}
	
	//validating password box displayed in orangehrm
	WebElement web1=driver.findElement(By.name("password"));
	if(web1.isDisplayed()==true) {
		web1.sendKeys("admin123");}
	
	//validating login button displayed in orangehrm
	WebElement web2=driver.findElement(By.className("oxd-button"));
	if(web2.isDisplayed()==true) {
		web2.click();}
	
	Thread.sleep(5000);

	
	//validating dropdown button displayed in orangehrm
	WebElement web3=driver.findElement(By.className("oxd-userdropdown"));
	if(web3.isDisplayed()==true) {
		web3.click();}
	
	Thread.sleep(5000);

	//validating logout button displayed in orangehrm
	WebElement web4=driver.findElement(By.linkText("Logout"));
	if(web4.isDisplayed()==true) {
		web4.click();}
	
}

}
