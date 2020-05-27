package parallel;

import java.io.File;

//import org.junit.AfterClass;
import org.testng.annotations.DataProvider;

import com.cucumber.listener.Reporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "./features",
        glue = {"stepDefinitions"}, 
        monochrome = true,
        //strict = false,
       // dryRun = true,
       /* plugin = { "pretty", "html:target/htmlreports" }*/
		plugin = { /*
					 * "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
					 */
        		"pretty", "html:target/htmlreports",
        		"json:target/cucumber.json",
        		"junit:target/cucumber.xml"},
        tags = {"@SEARCHITEMS1"}

        		)

public class TestRunnerParallel extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    
	/*
	 * @org.testng.annotations.AfterClass(alwaysRun = true) public static void
	 * writeExtentReport() { Reporter.loadXMLConfig(new File("config/report.xml"));
	 * 
	 * }
	 */
    }

    
