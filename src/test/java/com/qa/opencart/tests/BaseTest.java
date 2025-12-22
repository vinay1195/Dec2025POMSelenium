package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistratioPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest 
{
	DriverFactory df;
	WebDriver driver;
	 LoginPage loginPage;
	 Properties prop;
	 AccountsPage accountsPage;
	 SearchResultsPage searchResultPage;
	 ProductInfoPage productInforPage;
	 SoftAssert softassert;
	 RegistratioPage registrationPage;
	 
@BeforeTest
	public void setup()
	{
		df= new DriverFactory();
		prop =df.init_prop();
		driver=df.init_Browser(prop);
		loginPage = new LoginPage(driver);
		softassert= new SoftAssert(); 
		
	}
	public void tearDown() 
	{
	   driver.quit();	
	}
	
	
	

}
