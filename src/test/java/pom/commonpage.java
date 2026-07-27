package pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class commonpage 
{
	WebDriver driver;
	
	By userxpath=By.xpath("//input[@id='userName']");
	By pwdxpath=By.xpath("//input[@id='password']");	
	By loginbuttonxpath=By.xpath("//button[@id='login']");
	By selectnmenu=By.xpath("//span[text()='Select Menu']");
	By selectDropdown=By.xpath("//*[text()='Select One']//following::*[text()='Select Title']");
	By oldselectxpath=By.xpath("//select[@id='searchDropdownBox']");
	
	public commonpage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void setURL(String weburl)
	{
		driver.get(weburl);
	}
	
	public void setCredentials()
	{
		WebElement username=driver.findElement(userxpath);
		username.sendKeys("Admin");
		
		WebElement password=driver.findElement(pwdxpath);
		password.sendKeys("Admin@123");
		
		
	}
	
	public void buttonclick()
	{
		WebElement loginbutton=driver.findElement(loginbuttonxpath);
		loginbutton.click();
	}
	
	
	
	public By dropdownmethodxpath(String value)
	{
		By dropdownvaluesxpath=By.xpath("//*[text()='"+ value +"']");
		return dropdownvaluesxpath;
		
	}
	
	public void menuclick()
	{
		WebElement dropmenu=driver.findElement(selectnmenu);
		dropmenu.click();
	}
	
	public void verfydropdownvalues(DataTable dataTable )
	{
		WebElement ele=driver.findElement(selectDropdown);
		ele.click();
		List<Map<String,String>> data=dataTable.asMaps(String.class, String.class);
		
		for(Map<String,String>eachField:data)
		{
			String expectedvalue=eachField.get("values");
			
			System.out.println("values are="+expectedvalue);
			
			
			WebElement ele1=driver.findElement(dropdownmethodxpath(expectedvalue));
			
			String actualvalue=ele1.getText();
			
			Assert.assertEquals(expectedvalue, actualvalue);
			
			
		}
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	public void verfydropdownvalues1(DataTable dataTable )
	{

		 // Open dropdown
	    WebElement dropdown = driver.findElement(By.id("selectOne"));
	    dropdown.click();

	    // Wait for options
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[starts-with(@id,'react-select-3-option')]")
	    ));
	
		   
	    
	    // Get expected values (remove header)
		    List<String> expectedValues = dataTable.asList(String.class);
		    

		   

		    // Get all dropdown options
		    List<WebElement> options = driver.findElements(
		            By.xpath("//div[starts-with(@id,'react-select-3-option')]")
		    );

		    // Collect actual texts
		    List<String> actualValues = new ArrayList<>();
		    
		    
		    for (WebElement option : options) 
		    {
		        actualValues.add(option.getText().trim());
		    }

		    // Verify expected values
		   
		        Assert.assertTrue("values not found", actualValues.contains(expectedValues) );
		    
		}
	
   public void clickdropdownvalue(String name)
   {
	   WebElement ele=driver.findElement(oldselectxpath);
	   
	   Select s=new Select(ele);
	   s.selectByVisibleText(name);

	   
   }



	}
	
	
	


