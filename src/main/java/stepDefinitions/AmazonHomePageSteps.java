package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.TestContext;
import managers.WebDriversManager;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import utilities.ConfigFileReader;
import utilities.TestDataHandler;

public class AmazonHomePageSteps {
	
	//WebDriver driver;
	HomePage home;
	/*
	 * SearchResultsPage searchResults; PageObjectManager pageObjectManager;
	 * WebDriversManager webDriverManager;
	 */
	
	 TestContext testContext;
	// HomePage homePage;
	 
	 public AmazonHomePageSteps(TestContext context) {
	 testContext = context;
	 home = testContext.getPageObjectManager().getHomePage();
	 }
	
	
	//ConfigFileReader obj= new ConfigFileReader();  
	TestDataHandler testDataHandler = new TestDataHandler();

	
	@Given("User is on Home Page")
	public void user_is_on_Home_Page() throws IOException {
		/*
		 * System.out.println("on home page......"); webDriverManager = new
		 * WebDriversManager(); driver = webDriverManager.getDriver(); pageObjectManager
		 * = new PageObjectManager(driver);
		 */
		//driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		home.navigateToHomePage();
		//waitForPageLoaded();
	}

	@When("User searches for {string}")
	public void user_searches_for(String searchItem) throws InterruptedException {
		testContext.setSearchItem(searchItem);
		System.out.println("searched for "+searchItem);
		//home = pageObjectManager.getHomePage();
		home.perform_Search(searchItem);
		
	}

	/*
	 * @Then("products related to search must appear") public void
	 * products_related_to_search_must_appear() throws InterruptedException {
	 * searchResults = pageObjectManager.getSearchResultPage(); String text =
	 * searchResults.getFirstItemText(); System.out.println("text:::::::"+text);
	 * Assert.assertTrue(text.contains(searchItem),
	 * "Product Mismatch in Assertion for Item :::"+searchItem); Thread.sleep(3000);
	 * driver.close(); }
	 */

	/*
	 * public void waitForPageLoaded() { ExpectedCondition<Boolean> expectation =
	 * new ExpectedCondition<Boolean>() { public Boolean apply(WebDriver driver) {
	 * return ((JavascriptExecutor)
	 * driver).executeScript("return document.readyState").toString()
	 * .equals("complete"); } }; try { Thread.sleep(1000); WebDriverWait wait = new
	 * WebDriverWait(driver, 30); wait.until(expectation); } catch (Throwable error)
	 * { Assert.fail("Timeout waiting for Page Load Request to complete."); } }
	 */
}
