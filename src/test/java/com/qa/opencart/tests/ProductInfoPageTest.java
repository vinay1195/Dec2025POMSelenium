package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class ProductInfoPageTest extends BaseTest
{
	@BeforeClass
	public void ProductInfosetup() {
		// System.out.println(prop.getProperty("username"));
		accountsPage = loginPage.doLogin("moluguvinay2434@gmail.com", "Mvinay@2243");
	}
	@Test(priority=1)
	public void productHeaderTest()
	{
		searchResultPage = accountsPage.doSearch("MacBook");
		productInforPage = searchResultPage.selectProduct("Macbook Pro");
		String productheader = productInforPage.getProductHeader();
		Assert.assertEquals(productheader,"MacBook Pro");
		
	}
	@Test(priority=2)
	public void productImagesCountTest()
	{
		searchResultPage=accountsPage.doSearch("iMac");
		productInforPage=searchResultPage.selectProduct("iMac");
		Assert.assertEquals(productInforPage.getProductimagecount(),Constants.IMAC_IMAGE_COUNT);
		
	}
	@Test(priority=3)
	public void productInfoTest()
	{
		searchResultPage=accountsPage.doSearch("MacBook");
		productInforPage=searchResultPage.selectProduct("Macbook Pro");	
		Map<String,String> actproductInfoMap= productInforPage.getProductinfo();
		actproductInfoMap.forEach((k,v)->System.out.println(k+":"+v));
		softassert.assertEquals(actproductInfoMap.get("name"),"MacBook Pro");
	  softassert.assertEquals(actproductInfoMap.get("exPrice"),"Ex Tax: $2,000.00");
		  //softassert.assertEquals(actproductInfoMap.get("price"),"$2,000.00");
		 
		softassert.assertAll();
	}
	}


