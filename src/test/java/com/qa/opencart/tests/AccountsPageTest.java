package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {
	@BeforeClass
	public void accountsPagesetup() {
		// System.out.println(prop.getProperty("username"));
		accountsPage = loginPage.doLogin("moluguvinay2434@gmail.com", "Mvinay@2243");
	}

	@Test(priority = 1)
	public void accPageTtileTest() {
		String actTitle = accountsPage.getAccountsPageTitle();
		System.out.println("Account page title is " + actTitle);
		Assert.assertEquals(actTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void isLogoutExistTest() {
		Assert.assertTrue(accountsPage.isLogoutlinkExist());
	}

	@Test(priority = 3)
	public void accPageSectionsTest() {
		List<String> actAccSecList = accountsPage.getAccountSeclist();
		Assert.assertEquals(actAccSecList, Constants.getExpectedAccSecList());
	}

	@DataProvider
	public Object[][] productdata() {
		return new Object[][] { { "Macbook" }, { "Apple" }, { "Samsung" }, };
	}

	@Test(priority = 4, dataProvider = "productdata")
	public void SearchTest(String Productname) {
		searchResultPage = accountsPage.doSearch(Productname);
		Assert.assertTrue(searchResultPage.getProductListcount() > 0);
	}
	@DataProvider
	public Object[][] productselectdata() {
		return new Object[][] { 
			{ "MacBook","MacBook Pro"}, 
			{ "Apple","Apple Cinema 30\"" }, 
			{ "Samsung","Samsung SyncMaster 941BW" },
			{"imac","iMac"},
			};
	}
	@Test(priority = 5, dataProvider = "productselectdata")
	public void selectProductTest(String productname,String Mainproductname) {
		searchResultPage = accountsPage.doSearch(productname);
		productInforPage = searchResultPage.selectProduct(Mainproductname);
		String productheader = productInforPage.getProductHeader();
		Assert.assertEquals(productheader,Mainproductname);
	}

}