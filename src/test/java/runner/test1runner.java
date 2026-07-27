package runner;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/test1.feature",
        		glue = {"stepdefination", "utility"},
        plugin = {
                "pretty",
               
                "json:target/cucumber.json",
                
        }
        
        

)
public class test1runner 
{
	 @AfterClass
	    public static void generateReport() 
	 {

	        File reportOutputDirectory = new File("target");

	        List<String> jsonFiles = new ArrayList<>();
	        jsonFiles.add("target/cucumber.json");

	        Configuration configuration =
	                new Configuration(reportOutputDirectory, "Testing_2026");
	        
	        configuration.setBuildNumber("1");
	        configuration.addClassifications("Platform", "Windows");
	        configuration.addClassifications("Browser", "Chrome");
	        configuration.addClassifications("Automation", "Selenium");
	        configuration.addClassifications("Framework", "BDD Cucumber");

	        ReportBuilder reportBuilder =
	                new ReportBuilder(jsonFiles, configuration);

	        reportBuilder.generateReports();
	        
	 }


}
