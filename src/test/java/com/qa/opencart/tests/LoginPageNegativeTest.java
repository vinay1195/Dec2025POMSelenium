package com.qa.opencart.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest extends BaseTest {
	@DataProvider
	public Object[][] loginWrongTestData()
	{
		return new Object[][]
				{
			{"abc@gmail.com","123"},
			{"123@gmail",""},
			{"",""}
		};
	}

	@Test(dataProvider="loginWrongTestData")
	public void loginNegativetest(String Un,String pwd)
	{
		Assert.assertFalse(loginPage.doLoginWithWrongCredentials(Un,pwd));
	}

}
