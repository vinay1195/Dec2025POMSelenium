package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;



public class LoginPageTest extends BaseTest
{
	/*
	 * @Description("login page Title Test")
	 * 
	 * @Severity(SeverityLevel.MINOR)
	 */
	@Test(priority=1)
		public void LoginPageTitleTest()
		{
		String actTitle=loginPage.getLoginPageTitle();
		System.out.println("Actual title of the page is"+actTitle);
		Assert.assertEquals(actTitle,Constants.LOGGIN_PAGE_TITLE);
		}
	@Epic("EPC100: login page URL")
	@Story("Story for the login")
	@Test(priority=2)
	public void LoginPageUrlTest()
	{
		boolean actUrl=loginPage.getLoginPageUrl();
		System.out.println("Url of the page is "+actUrl);
		Assert.assertTrue(loginPage.getLoginPageUrl());
	}
	@Test(priority=3)
	public void forgorpwdLinkTest()
	{
		Assert.assertTrue(loginPage.isForgotpwdLinkExist());
	}
	@Test(priority=4)
	public void RigisterLinkExist()
	{
		Assert.assertTrue(loginPage.isRigisterLinkExist());
	}

	@Test(priority=5)
	public void loginTest()
	{
		loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		Assert.assertEquals(accountsPage.getAccountsPageTitle(),Constants.ACCOUNTS_PAGE_TITLE);
	}
	
}
