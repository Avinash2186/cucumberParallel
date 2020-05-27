package stepDefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigFileReader;
import utilities.TestDataHandler;

public class HomePageSteps {
	
	public  WebDriver driver;
	public  String searchItem;
	ConfigFileReader obj = new ConfigFileReader();
	TestDataHandler testDataHandler = new TestDataHandler();
	HttpURLConnection huc = null;
	int respCode = 200;
	Properties properties;

	
	@Given("User is on AAP Home Page")
	public void user_is_on_AAP_Home_Page() throws IOException, InterruptedException {
		System.out.println("on home page......");
		//properties = obj.getProperty();
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		List<String> chromeVersions = WebDriverManager.chromedriver().getDriverVersions();
		System.out.println("ChromeVErsions::::"+chromeVersions);

		/*
		 * WebDriverManager.operadriver().setup(); driver = new OperaDriver();
		 */
		WebDriverManager.chromedriver().setup();
		
		// Create driver object for Chrome
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(properties.getProperty("browser.AAPbaseURL"));
		waitForPageLoaded();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 2000)");
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0, 0)");
		// Thread.sleep(3000);
		waitForPageLoaded();
		checkFlyerDiscount();
	}

	@Then("Verify flyer is displayed and clicked on Close")
	public void verify_flyer_is_displayed_and_clicked_on_Close() {
		// Write code here that turns the phrase above into concrete actions

				driver.findElement(By.id("aap-flyout-ymme-year-1")).click();

				List<WebElement> optionList = driver
						.findElements(By.xpath("//input[@id='aap-flyout-ymme-year-1']//parent::div//ul/li"));

				System.out.println("optionList::::::::" + optionList.size());
				JavascriptExecutor js = (JavascriptExecutor) driver;
				/*
				 * for (WebElement option : optionList) { System.out.println("option text ::: "
				 * + option.getText()); }
				 */
				js.executeScript("arguments[0].click();", optionList.get(78));
				optionList.clear();
				
				
				WebDriverWait wait = new WebDriverWait(driver, 2);
				driver.findElement(By.id("aap-flyout-ymme-make-1")).click();
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//input[@id='aap-flyout-ymme-make-1']//parent::div//ul/li")));
				optionList = driver.findElements(By.xpath("//input[@id='aap-flyout-ymme-make-1']//parent::div//ul/li"));
				System.out.println("optionList::::::::" + optionList.size());
				js = (JavascriptExecutor) driver;
				for (WebElement option : optionList) {
					System.out.println("option text 2 ::: " + option.getText());
				}
				js.executeScript("arguments[0].click();", optionList.get(2));
				optionList.clear();
				
				
				driver.findElement(By.id("aap-flyout-ymme-model-1")).click();
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//input[@id='aap-flyout-ymme-model-1']//parent::div//ul/li")));
				optionList = driver.findElements(By.xpath("//input[@id='aap-flyout-ymme-model-1']//parent::div//ul/li"));
				System.out.println("optionList::::::::" + optionList.size());
				js = (JavascriptExecutor) driver;
				for (WebElement option : optionList) {
					System.out.println("option text 3 ::: " + option.getText());
				}
				js.executeScript("arguments[0].click();", optionList.get(1));

			}

			private void checkFlyerDiscount() {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='reset']")));
				System.out.println("pressence of element done..........");
				List<WebElement> flyer = driver.findElements(By.xpath("//button[@type='reset']"));
				System.out.println("size is greater than 0 of flyer....." + flyer.size());
				if (flyer.size() > 0) {
					for (WebElement fly : flyer) {
						try {
							if (fly.isDisplayed()) {
								wait.until(ExpectedConditions.elementToBeClickable(fly));
								fly.click();
								break;
							}
						} catch (Exception e) {
							System.out.println("flyer not displayed.....");

						}

					}
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@type='reset']")));
					System.out.println("element is invisible now.......");
				}
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
