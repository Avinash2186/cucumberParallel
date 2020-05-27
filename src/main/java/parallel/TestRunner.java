package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "./features",
        glue = {"stepDefinitions"}, 
        monochrome = true,
        //strict = false,
       // dryRun = true,
       /* plugin = { "pretty", "html:target/htmlreports" }*/
        plugin = {"pretty", "html:target/htmlreports",
        		"json:target/cucumber.json",
        		"junit:target/cucumber.xml"},
        tags = {"@SEARCHITEMS"}

        		)

public class TestRunner extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}