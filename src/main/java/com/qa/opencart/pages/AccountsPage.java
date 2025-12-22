package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtils eleUtil;
	private By AccountsSection = By.xpath("//*[@id=\"content\"]/h2");
	private By Searchfield = By.xpath("//*[@id='search']/input");
	private By Searchbutton = By.xpath("//*[@class='input-group-btn']");
	private By logoutLink = By.linkText("Logout");

	public  AccountsPage(WebDriver driver)
	{
     this.driver= driver;
     eleUtil= new ElementUtils(driver);  
	}

	public String getAccountsPageTitle() {
		return eleUtil.doGetTitle(Constants.ACCOUNTS_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public boolean isLogoutlinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);
	}

	public void logout() {
		if (isLogoutlinkExist()) {
			eleUtil.doClick(logoutLink);
		}
	}
	public boolean isSearchExist()
	{
	return eleUtil.doIsDisplayed(Searchfield);	
	}
	public boolean issearchBtnExist()
	{
		return eleUtil.doIsDisplayed(Searchbutton);
	}
	public List<String> getAccountSeclist()
	{
		List<WebElement> accSeclist=eleUtil.waitForElementsToBeVisible(AccountsSection,Constants.DEFAULT_TIME_OUT);
		List<String>accSecValList=new ArrayList<String>();
		for(WebElement e:accSeclist)
		{
          String text=e.getText();
          System.out.println(text);
          accSecValList.add(text);
         
		}
		return accSecValList;	
	}
	public SearchResultsPage doSearch(String productname)
	{
		System.out.println("Searching for the product is" +productname);
		eleUtil.doSendKeys(Searchfield,productname);
		eleUtil.doClick(Searchbutton);
		return new SearchResultsPage(driver);
		
	}

}
