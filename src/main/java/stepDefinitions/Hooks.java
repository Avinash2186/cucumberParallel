package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.*;
import managers.TestContext;

public class Hooks {
	//public WebDriver driver;
	
	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {	
		
		System.out.println("Started execution for the scenario : " + scenario.getName());
		String browser = System.getProperty("BROWSER");
		System.out.println("browser::::"+browser);
		String env = System.getenv("JAVA_HOME");
		System.out.println("env::::"+env);
		
		/*
		 * if(browser.equalsIgnoreCase("Chrome")) { WebDriverFactory }
		 */
		
	}
	
	/*
	 * @Before("@TestCase2") public void beforeTestCase2(Scenario scenario) {
	 * 
	 * System.out.println("=========================================");
	 * System.out.println("Executing before Testcase2");
	 * System.out.println("=========================================");
	 * 
	 * }
	 */
	@After
	public void AfterScenario(Scenario scenario) {
		testContext.getWebDriverManager().closeDriver();
		System.out.println("Completed execution for the scenario :" + scenario.getName());
	}

}


