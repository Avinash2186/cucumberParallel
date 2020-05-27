package managers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import enums.DriverType;
import enums.EnvironmentType;

public class WebDriversManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriversManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() throws MalformedURLException {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() throws MalformedURLException {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() throws MalformedURLException {
		System.out.println("RemoteWebDriver is not yet implemented");
		//sWebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
        DesiredCapabilities cap=null;
		switch (driverType) {
		case FIREFOX:
			System.out.println("REMOTE FIREFOX......................");
			cap = new DesiredCapabilities();
	        cap.setCapability("browserName", "firefox");
			break;
			
		case CHROME:
			System.out.println("REMOTE CHROME.........................");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			
			cap = new DesiredCapabilities();
	        cap.setCapability("browserName", "chrome");
	        //capabilities.setCapability("version", "76.0.3809.132");
	        cap.setCapability(ChromeOptions.CAPABILITY, options);
		}
		RemoteWebDriver rdriver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		//RemoteWebDriver rdriver=new RemoteWebDriver(new URL("http://192.168.0.6:5555/wd/hub"), capabilities);
		
		//driver = rdriver;
		System.out.println("returning details....");
		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			rdriver.manage().window().maximize();
		rdriver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),TimeUnit.SECONDS);
		return rdriver;
        
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:
			/*
			 * System.setProperty(CHROME_DRIVER_PROPERTY,
			 * FileReaderManager.getInstance().getConfigReader().getDriverPath()); driver =
			 * new ChromeDriver();
			 */
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			List<String> chromeVersions = WebDriverManager.chromedriver().getDriverVersions();
			System.out.println("ChromeVErsions::::" + chromeVersions);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver.manage().window().maximize();
			break;

		case OPERA:
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		}

		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}
}