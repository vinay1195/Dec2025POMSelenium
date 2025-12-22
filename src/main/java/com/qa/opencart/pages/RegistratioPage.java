package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class RegistratioPage {
	private WebDriver driver;
	private ElementUtils eleUtil;

	public RegistratioPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
	}

	private By firstname = By.id("input-firstname");
	private By LastName = By.id("input-lastname");
	private By Email = By.id("input-email");
	private By Telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By Confirmpwd = By.id("input-confirm");
	private By SubscribeYes = By.xpath("(//label[@class='radio-inline'])[1]/input[@name='newsletter']");
	private By SubscribeNo = By.xpath("(//label[@class='radio-inline'])[2]/input[@name='newsletter']");
	private By Successmsg = By.id("content");
	private By agreecheckBox = By.name("agree");
	private By Continue = By.xpath("//input[@value='Continue']");
	private By logout = By.linkText("Logout");
	private By RigisterLink = By.linkText("Register");

	public boolean accountRegistration(String firstname,String LastName,String Email,String Telephone,String password,String Subscribe)
	{
		eleUtil.doSendKeys(this.firstname, firstname);
		eleUtil.doSendKeys(this.LastName, LastName);
		eleUtil.doSendKeys(this.Email, Email);
		eleUtil.doSendKeys(this.Telephone, Telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.Confirmpwd, password);
		if(Subscribe.equals("yes"))
		{
			eleUtil.doClick(SubscribeYes);
		}
		else
		{
			eleUtil.doClick(SubscribeNo);	
		}
		eleUtil.doClick(agreecheckBox);
		eleUtil.doClick(Continue);
		eleUtil.waitForElementToBeVisible(Successmsg, 10, 2000);
		String msg=eleUtil.doGetText(Successmsg);
		System.out.println(msg);
		if(msg.contains(Constants.REGISTER_SUCCESS_MESG))
		{
			eleUtil.doClick(logout);
			eleUtil.doClick(RigisterLink);
			return true;
		}
		return false;	
	}
}


