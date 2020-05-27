/*
 * package utilities;
 * 
 * import java.util.List; import java.util.Properties;
 * 
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.chrome.ChromeDriverService;
 * 
 * import io.github.bonigarcia.wdm.WebDriverManager;
 * 
 * public class WebDriverManager { private WebDriver driver; private static
 * DriverType driverType; private static EnvironmentType environmentType;
 * private static final String CHROME_DRIVER_PROPERTY =
 * "webdriver.chrome.driver";
 * 
 * public WebDriverManager() { driverType =
 * FileReaderManager.getInstance().getConfigReader().getBrowser();
 * environmentType =
 * FileReaderManager.getInstance().getConfigReader().getEnvironment(); }
 * 
 * public WebDriver getDriver() { if(driver == null) driver = createDriver();
 * return driver; }
 * 
 * private WebDriver createDriver() { switch (environmentType) { case LOCAL :
 * driver = createLocalDriver(); break; case REMOTE : driver =
 * createRemoteDriver(); break; } return driver; }
 * 
 * private WebDriver createRemoteDriver() { throw new
 * RuntimeException("RemoteWebDriver is not yet implemented"); }
 */