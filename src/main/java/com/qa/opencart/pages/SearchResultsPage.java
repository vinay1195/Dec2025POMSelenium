package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class SearchResultsPage {
	private WebDriver driver;
	private ElementUtils eleUtil;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
	}

	private By productresult = By.xpath("//div[@class='caption']//a");
	

	public int getProductListcount() {
		int resultCount = eleUtil.waitForElementsToBeVisible(productresult, 5, 2000).size();
		System.out.println(resultCount);
		return resultCount;
	}

	public ProductInfoPage selectProduct(String Mainproductname) {
		System.out.println("MainProductName is " + Mainproductname);
		List<WebElement> Searchlist = eleUtil.waitForElementsToBeVisible(productresult, 5, 2000);
		for (WebElement e : Searchlist) {
			String txt = e.getText();
			if (txt.equalsIgnoreCase(Mainproductname))
			{
				System.out.println(txt);
				e.click();
				break;
			}

		}
		return new ProductInfoPage(driver);
	}
}
