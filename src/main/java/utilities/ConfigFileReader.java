package utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	
	 private Properties properties;
	 private final String propertyFilePath= "resources//browser-config.properties";
	 
	 
	 public ConfigFileReader(){
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 properties = new Properties();
	 try {
	 properties.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	 
	 public String getDriverPath(){
	 String driverPath = properties.getProperty("driverPath");
	 if(driverPath!= null) return driverPath;
	 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
	 }
	 
	 public long getImplicitlyWait() { 
	 String implicitlyWait = properties.getProperty("implicitlyWait");
	 if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
	 else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file."); 
	 }
	 
	 public String getApplicationUrl() {
	 String url = properties.getProperty("browser.baseURL");
	 System.out.println("url::::"+url);
	 if(url != null) return url;
	 else throw new RuntimeException("url not specified in the Configuration.properties file.");
	 }
	 
	 public DriverType getBrowser() {
		 String browserName;
		 String browser = System.getProperty("browser");
		 System.out.println("Tis browser is from cmd prompt:::::::"+browser);
		 if(browser!=null)
			 browserName=browser;
		 else
			 browserName = properties.getProperty("browser");
		 
		 if(browserName == null || browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		 else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		 else if(browserName.equalsIgnoreCase("opera")) return DriverType.OPERA;
		 else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
		 }
	 
	 public EnvironmentType getEnvironment() {
		 String environmentName;
		 String env = System.getProperty("env");
		 System.out.println("Tis env is from cmd prompt:::::::"+env);
		 if(env!=null)
			 environmentName=env;
		 else
			 environmentName = properties.getProperty("environment");
		 if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		 else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		 else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
		 }
		 
		 public Boolean getBrowserWindowSize() {
		 String windowSize = properties.getProperty("windowMaximize");
		 if(windowSize != null) return Boolean.valueOf(windowSize);
		 return true;
		 }

}
