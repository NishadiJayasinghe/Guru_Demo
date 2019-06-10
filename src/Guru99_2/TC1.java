package Guru99_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Library.Utility;

public class TC1 {

	WebDriver driver;
	String baseURL = "http://live.guru99.com/index.php/";
	
	@BeforeTest
	public void LaunchingBrowser(){
		
		System.getProperty("webdriver.chrome.driver", "E:\\software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 0)
	public void verify_TitleOf_HomePage() {
		
		String actual_title = driver.findElement(By.cssSelector("h2")).getText();
		String expected_title = "THIS IS DEMO SITE FOR ";
		Assert.assertEquals(actual_title, expected_title);
	}
	
	@Test(priority = 1)
	public void mobile() {
		
		WebElement mobile = driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		mobile.click();
		
	}
	
	@Test(priority = 2)
	public void verify_Titleof_Mobilepage() {
		
		String actual_title = driver.getTitle();
		String expected_title = "Mobile";
		Assert.assertEquals(actual_title, expected_title);
	}	
	
	@Test(priority = 3)
	public void sortBy() {
		WebElement Sortby = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
		Sortby.click();
		WebElement name = driver.findElement(By.xpath("//option[contains(text(),'Name')]"));
		Actions act = new Actions(driver);
		act.moveToElement(name).perform();
		name.click();
		
	}
	
	@AfterMethod
	public void Screenshot() throws Exception{
		  
		Utility.CaptureScreenshot(driver, "demosite2");
		
	}
	
	@AfterTest
	public void terminateBrowser() {
		driver.quit();
	}
	 
	
}
	

