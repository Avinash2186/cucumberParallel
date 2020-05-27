package managers;



import org.openqa.selenium.WebDriver;


import pageObjects.HomePage;

import pageObjects.SearchResultsPage;



public class PageObjectManager {

	private WebDriver driver;
	private HomePage home;
	private SearchResultsPage searchResult;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	

	public HomePage getHomePage(){

		return (home == null) ? home = new HomePage(driver) : home;

	}

	

	public SearchResultsPage getSearchResultPage() {

		return (searchResult == null) ? searchResult = new SearchResultsPage(driver) : searchResult;

	}

}