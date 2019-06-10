package Library;

import java.io.File;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static void CaptureScreenshot(WebDriver driver, String screenshotname) {
		  
		try {
			TakesScreenshot scrShot= (TakesScreenshot)driver;
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			
			File DestFile = new File("./Screenshots/"+screenshotname+".png");
			FileUtils.copyFile(srcFile, DestFile); 
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			
			System.out.println("exception while taking screenshot" +  e.getMessage());
		}
	}
	
}
