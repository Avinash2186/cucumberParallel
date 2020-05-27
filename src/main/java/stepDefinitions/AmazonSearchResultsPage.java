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

public class AmazonSearchResultsPage {
	
	WebDriver driver;
	//HomePage home;
	SearchResultsPage searchResults;
	/*
	 * PageObjectManager pageObjectManager; WebDriversManager webDriverManager;
	 * public String searchItem;
	 */
	//ConfigFileReader obj= new ConfigFileReader();  
	//TestDataHandler testDataHandler = new TestDataHandler();
	 TestContext testContext;
	public AmazonSearchResultsPage(TestContext context) {
		 testContext = context;
		 searchResults = testContext.getPageObjectManager().getSearchResultPage();
		 }

	
	@Then("products related to search must appear")
	public void products_related_to_search_must_appear() throws InterruptedException {
		//searchResults = pageObjectManager.getSearchResultPage();
		String text = searchResults.getFirstItemText();
		System.out.println("Actual text on Page :::::::"+text);
		System.out.println("Expected text from text context:::::"+testContext.getSearchItem());
		    Assert.assertTrue(text.contains(testContext.getSearchItem()), "Product Mismatch in Assertion for Item :::");
			Thread.sleep(3000);	 	
			//driver.close();
			
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

}
