package stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.commonpage;
import utility.BaseClass;

public class commonstep extends BaseClass 
{
	
	@Given("open url {string}")
	public void open_url(String url)
	{
		commonpage cp=new commonpage(driver);
		cp.setURL(url);
	}
	@When("Enter user name and password")
	public void enter_user_name_and_password() 
	{
		commonpage cp=new commonpage(driver);
		cp.setCredentials();
		
	}
	@Then("click on login button")
	public void click_on_login_button()
	{
		commonpage cp=new commonpage(driver);
		cp.buttonclick();
	}
	
	@When("click on dropdown1 button")
	public void click_on_dropdown1_button()
	{
		commonpage cp=new commonpage(driver);
		cp.menuclick();
	}
	@Then("verify below values are present in dropdown1")
	public void verify_below_values_are_present_in_dropdown1(io.cucumber.datatable.DataTable dataTable) 
	{
	  
		commonpage cp=new commonpage(driver);
		cp.verfydropdownvalues(dataTable);
		
	}

	
	@Then("verify below values are present in dropdown2")
	public void verify_below_values_are_present_in_dropdown2(io.cucumber.datatable.DataTable dataTable) 
	{
	  
		commonpage cp=new commonpage(driver);
		cp.verfydropdownvalues1(dataTable);
		
	}
	
	 @Then("verify below values are present in header of table")
	 public void verify_below_values_are_present_in_header_of_table(io.cucumber.datatable.DataTable dataTable)
	 {
	    
	 }

	 @Then("click on value {string}")
	 public void click_on_value(String name) 
	 {
		 commonpage cp=new commonpage(driver);
			cp.clickdropdownvalue(name);
	 }


}
