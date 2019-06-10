package Guru99_bank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SS1 {

	public static void main (String[]args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\\\software\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).clear();
		WebElement UserId = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
		UserId.sendKeys("mngr196327");
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).clear();;
		WebElement Password = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
		Password.sendKeys("bYzevUs");
		
		WebElement login = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
		login.click();
		
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = driver.getTitle();
		//Assert.assertEquals(expectedTitle, actualTitle);
		
		if(actualTitle.contains(expectedTitle)) {
			System.out.println("Test case : Passed");
		}
		else {
			System.out.println("Test case : Failed");
		}
		//Thread.sleep(3000);
		
		driver.quit();
		
		
	}
	
	
}
