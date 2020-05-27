package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	WebDriverWait wait;
	
	 public SearchResultsPage(WebDriver driver) {
		 wait = new WebDriverWait(driver, 30);
		 PageFactory.initElements(driver, this);
		 }
		 
		 @FindBy(xpath= "(//div[contains(@class,'s-result-list')]//h2)[1]") 
		 private WebElement firstItem;
		 
		 @FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
		 private List<WebElement> prd_List; 
		 
		 public String getFirstItemText() {
				wait.until(ExpectedConditions.elementToBeClickable(firstItem));

			 return firstItem.getText();
		 }
		 
		 public void select_Product(int productNumber) {
		 prd_List.get(productNumber).click();
		 }

}
