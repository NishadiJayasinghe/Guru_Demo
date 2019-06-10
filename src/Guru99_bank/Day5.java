package Guru99_bank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Library.Utility;

//import sun.misc.FpUtils;

public class Day5 {

	public WebDriver driver;
	public String BaseURL = "http://www.demo.guru99.com/V4/";
	
	@DataProvider(name = "GuruTest")
	public Object[][] testData(){
		Object[][] data = new Object[4][2];
		
		data[0][0] = "mngr196327";
		data[0][1] =  "bYzevUs";
		
		data[1][0] = "invalid";
		data[1][1] = "valid";
		
		data[2][0] = "valid";
		data[2][1] = "invalid";
		
		data[3][0] = "invalid";
		data[3][1] = "invalid";
		return data;
		
		
	}
	
	@BeforeMethod
	public void launching_browser() throws Exception {
		
		System.getProperty("webdriver.chrome.driver", "E:\\software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(BaseURL);
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider = "GuruTest")
	public void day5testcase(String UserName, String Password) throws Exception {
		
		String ActualBoxMessage;
		String ExpectedError = "User or Password is not valid";
		String PATTERN = ":";
	    String FIRST_PATTERN = "mngr";
	    String SECOND_PATTERN = "[0-9]+";
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).clear();
		WebElement userId = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
		userId.sendKeys(UserName);
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(Password);
		
		driver.findElement(By.name("btnLogin")).click();
		
		
		try {
			
			Alert alt = driver.switchTo().alert();
			ActualBoxMessage = alt.getText();
			alt.accept();
			
			Assert.assertEquals(ActualBoxMessage,ExpectedError);
			
		}
		
		catch(NoAlertPresentException Ex) {	    
		    
			String pageText = driver.findElement(By.tagName("tbody")).getText();
			
			// Extract the dynamic text mngrXXXX on page		
			String[] parts = pageText.split(PATTERN);
			String dynamicText = parts[1];
			
			// Check that the dynamic text is of pattern mngrXXXX
			// First 4 characters must be "mngr"
			Assert.assertTrue(dynamicText.substring(1, 5).equals(FIRST_PATTERN));
			
			// remain stores the "XXXX" in pattern mngrXXXX
			String remain = dynamicText.substring(dynamicText.length() - 4);
			
			// Check remain string must be numbers;
			Assert.assertTrue(remain.matches(SECOND_PATTERN));
			
			Utility.CaptureScreenshot(driver, "demosite1");
			
		}
	
	}
	@AfterMethod
	public void terminateBrowser() throws Exception{
		driver.quit();
		
	}
}
