package com.qa.opencart.pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class LoginPage {
	private WebDriver driver;
	private ElementUtils eleUtil;

	public  LoginPage(WebDriver driver)
	{
     this.driver= driver;
     eleUtil= new ElementUtils(driver);  
	}
	private By Email = By.id("input-email");
	private By password = By.id("input-password");
	private By RigisterLink = By.linkText("Register");
	private By ForgotpwdLink= By.linkText("Forgotten Password");
	private By loginbtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
	private By loginErrorMesg=By.xpath("//div[@class='alert alert-danger alert-dismissible']/i");

	public String getLoginPageTitle() {
		return eleUtil.doGetTitle(Constants.LOGGIN_PAGE_TITLE,Constants.DEFAULT_TIME_OUT);
	}
	public boolean getLoginPageUrl()
	{
		return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION,Constants.DEFAULT_TIME_OUT);
	}
	public boolean isRigisterLinkExist()
	{
		//return driver.findElement(RigisterLink).isDisplayed();
		return eleUtil.doIsDisplayed(RigisterLink);
	}
	public boolean isForgotpwdLinkExist()
	{
		return eleUtil.doIsDisplayed(ForgotpwdLink);
	}
	public AccountsPage doLogin(String un,String pwd)
	{
		System.out.println("Login with Username and Password:" +un+ ":" +pwd);
		eleUtil.doSendKeys(Email, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginbtn);
		return new AccountsPage(driver);
		
	}
	public boolean doLoginWithWrongCredentials(String Un,String pwd)
	{
		System.out.println("try to login with wrong credentials" +Un +":" +pwd);
		eleUtil.doSendKeys(Email, Un);
		eleUtil.doSendKeys(password,pwd);
		eleUtil.doClick(loginbtn);
		String ErrorMsg=eleUtil.doGetText(loginErrorMesg);
		System.out.println(ErrorMsg);
		if(ErrorMsg.contentEquals(Constants.LOGIN_ERROR_MSG))
		{
			System.out.println("login is not success");
			return true;
		}
		
		return false;
	}
	public RegistratioPage gotoRegistrationPage()
	{
		 eleUtil.doClick(RigisterLink);
		 return new RegistratioPage(driver);
	}

}
