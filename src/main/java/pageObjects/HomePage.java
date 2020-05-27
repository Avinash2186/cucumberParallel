package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	//driver.findElement(By.id("aap-flyout-ymme-make-1")).click();
	
	 @FindBy(id="twotabsearchtextbox") 
	 private WebElement searchInputBox;
	 
	 @FindBy(xpath="//input[@value='Go']") 
	 private WebElement goButton;
	 
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public void navigateToHomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	public void perform_Search(String search) {
		wait.until(ExpectedConditions.elementToBeClickable(searchInputBox));
		searchInputBox.sendKeys(search);
		System.out.println("clicked on G Button....");
		goButton.click();
	}
	
}