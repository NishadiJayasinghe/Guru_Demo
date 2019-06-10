package Guru99_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC2 {

	private static Object Xperia = null;
	private static Object XperiaDetail = null;
	private WebDriver driver;
	private String baseUrl = "http://live.guru99.com";
	
	@BeforeTest
	public void LaunchingBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void clickOnMobile() {
		
		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		   
	}
	
	@Test(priority = 1)
	public void readXperiaValue() {
		
	 Xperia = driver.findElement(By.cssSelector("#product-price-1 > span")).getText();
		   
	}
	
	@Test(priority = 2)
	public void clickOnXperia() {
		
	WebElement Xperia1 = driver.findElement(By.cssSelector("#product-collection-image-1"));
		Xperia1.click();
		   
	}
	
	@Test(priority = 3)
	public void readXperiaDetailValue() {
		
	XperiaDetail = driver.findElement(By.cssSelector("#product-price-1 > span")).getText();
		   
	}
	
	@Test(priority = 4)
	public void comparevalues() throws Exception{
		try {
			Assert.assertEquals(Xperia, XperiaDetail);
			System.out.println(Xperia + "=" + XperiaDetail);
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
		
	}
	
	@AfterTest
	public void terminateBrowser() {
		
		driver.quit();
	}
	
}
