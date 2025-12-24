package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
	public WebDriver driver;
	Properties prop;
	public static String highlight;
	public OptionManager optionsmanager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	

	public WebDriver init_Browser(Properties prop) {
		System.out.println("Given Broswer name is :");
		String Browsername = prop.getProperty("browser");
		highlight = prop.getProperty("highlight");
		optionsmanager = new OptionManager(prop);
		 System.out.println("Given Broswer name is :" +Browsername);

		if (Browsername.equalsIgnoreCase("chrome")) {
			tlDriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
			// driver = new ChromeDriver(optionsmanager.getChromeOptions());
		} else if (Browsername.equalsIgnoreCase("firefox")) {
			// driver = new FirefoxDriver(optionsmanager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsmanager.getFirefoxOptions()));
		} else {
			System.out.println("Please pass the correct Browsername :" + Browsername);
		}

		getDriver().manage().window().fullscreen();
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();

	}

	// getDriver():it will return a thread local copy of the webdriver
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
		if (envName == null) {
			System.out.println("Running on PROD env:");
			try {
				ip = new FileInputStream("./src/test/resourcess/config/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Running on  environment:" + envName);
			try {
			switch (envName) {
			case "qa":
				ip = new FileInputStream("./src/test/resourcess/config/qa.config.properties");
				break;
			case "dev":
				ip = new FileInputStream("./src/test/resourcess/config/dev.config.properties");
				break;
			case "stage":
				ip = new FileInputStream("./src/test/resourcess/config/stage.config.properties");
				break;
			case "uat":
				ip = new FileInputStream("./src/test/resourcess/config/uat.config.properties");
				break;
			default:
				System.out.println("Please pass the right Environment...");
				break;

			}
		}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return prop;

	}
	public String getScreenshot() {
		File src =  ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			
			FileUtils.copyFile(src,destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}
	
}
