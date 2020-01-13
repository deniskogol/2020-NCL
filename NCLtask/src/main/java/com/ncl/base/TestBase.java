package com.ncl.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties config;
	public static Actions actions;
	public static JavascriptExecutor jsExecutor;
	public static String browserName;
	
	public TestBase() {	
		
		try {
			config = new Properties();
		FileInputStream ip = new FileInputStream("./src/main/java/com/ncl/config/config.properties");
		    config.load(ip);		
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}

	
	public static void initialize() {

	     browserName = config.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}	
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);
		
		driver.get(config.getProperty("url"));
		
		actions = new Actions(driver);
		
	}
	
	
	
	
}
