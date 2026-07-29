package utility;

import io.cucumber.java.AfterStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass
{
	
	
	@Before
	@Override
	public void setChrome()
	{
	   super.setChrome();
	}
	
	@AfterStep
	@Override
	public void captureScreenshot(Scenario scenario) 
	{
	   super.captureScreenshot(scenario);
	}
	
	

	}


	
	


