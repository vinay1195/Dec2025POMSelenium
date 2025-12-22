package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {
	@BeforeClass
	public void setupRegistration() {
		registrationPage = loginPage.gotoRegistrationPage();
	}

	public String getRandomEmail() {
		Random randomgen = new Random();
		String email = "vinaymolugu" + randomgen.nextInt(100) + "@gmail.com";
		return email;
	}

	@DataProvider
	public Object[][] getRegisterData()
	{
		 return ExcelUtil.getTestData(Constants.REGISTER_SHETT_NAME);
	}
   @Test(dataProvider ="getRegisterData")
    public void userRegistrationTest(String firstname,String LastName,String Telephone,String password,String Subscribe)
	{
	   //String firstname,String LastName,String Email,String Telephone,String password,String Subscribe
		Assert.assertTrue(registrationPage.accountRegistration(firstname,LastName,getRandomEmail(),Telephone,password,Subscribe));
	}
}
