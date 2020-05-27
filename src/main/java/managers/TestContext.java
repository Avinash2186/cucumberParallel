package managers;
import java.net.MalformedURLException;

import managers.PageObjectManager;
import managers.WebDriversManager;

public class TestContext {
	private WebDriversManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private String searchItem;
	
	public String getSearchItem() {
		return searchItem;
	}

	public void setSearchItem(String searchItem) {
		this.searchItem = searchItem;
	}

	public TestContext() throws MalformedURLException{
		webDriverManager = new WebDriversManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}
	
	public WebDriversManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}