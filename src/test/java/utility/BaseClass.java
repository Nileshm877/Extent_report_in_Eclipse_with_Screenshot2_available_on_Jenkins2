package utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Scenario;
import java.io.File;
import java.nio.file.Files;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
public class BaseClass 
{
	public static WebDriver driver;
	public void setChrome()
	{
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\sai\\eclipse-workspace\\Cucumber_report_with_Screenshot\\Browser\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	
	//options.addArguments("--remote-allow-origin=*");
	driver=new ChromeDriver(options);
	}
	
	public void captureScreenshot(Scenario scenario) 
	{  try 
	    {

		String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		scenario.attach(
		        Base64.getDecoder().decode(base64),
		        "image/png",
		        "Step Screenshot");
		
         } 
	    catch (Exception e)
	    {
	        System.out.println("Unable to capture screenshot: " + e.getMessage());
	    }
	}

}
