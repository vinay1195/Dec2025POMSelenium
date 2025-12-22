package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtils eleUtil;

	private By Productheader = By.xpath("//div[@id='content']//h1");
	private By imagescount = By.xpath("//ul[@class='thumbnails']//a");
	private By productMetadata = By.xpath("(//div[@class='col-sm-4']/ul)[1]/li");
	private By productpriceData = By.xpath("(//div[@class='col-sm-4']/ul)[2]/li");
	private By Quantity = By.xpath("//input[@name='quantity']");
	private By Addtocart = By.xpath("//button[@id='button-cart']");
	private Map<String, String> productInfoMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtils(driver);
	}

	public String getProductHeader() {
		String ProdcutHeaderText = eleUtil.doGetText(Productheader);
		System.out.println(ProdcutHeaderText);
		return ProdcutHeaderText;
	}

	public int getProductimagecount() {
		return eleUtil.waitForElementsToBeVisible(imagescount, 10, 2000).size();

	}

	public Map<String,String> getProductinfo() {
		productInfoMap = new LinkedHashMap<String, String>();
		productInfoMap.put("name", getProductHeader());
		getProductMetaData();
		getProductPriceData();
		return productInfoMap;

	}

	private void getProductMetaData() {
		List<WebElement> metaDataList = eleUtil.getElements(productMetadata);
		for (WebElement e : metaDataList) {
			String Txt = e.getText();
			String meta[] = Txt.split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}
	}

	private void getProductPriceData() {
		List<WebElement> metaPriceList = eleUtil.getElements(productpriceData);

		String price = metaPriceList.get(0).getText().trim();
		String exPrice = metaPriceList.get(1).getText().trim();
		productInfoMap.put("Price", price);
		productInfoMap.put("exPrice", exPrice);
	}

}
