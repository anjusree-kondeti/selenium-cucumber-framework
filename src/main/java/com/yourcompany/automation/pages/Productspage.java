package com.yourcompany.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.yourcompany.automation.utils.GenericMethods;

public class Productspage {
	
	private WebDriver driver;
	
	public Productspage(WebDriver driver) {
		this.driver = driver;
	}
	
	GenericMethods genericmethods=new GenericMethods();

	private By btnProducts =By.xpath("//button[@data-page='products']");
	private By productsTable=By.xpath("//section[@id='products']/descendant::table");
	
	
	public void clickProducts() {
		genericmethods.click(btnProducts);
	}
	
	
	public void verifyProducts(String product,String category,String price,String stock) {
		WebElement productTable = driver.findElement(productsTable);
		List<WebElement>rows=productTable.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++) {
		List<WebElement>cols=rows.get(i).findElements(By.tagName("td"));
		String productText=cols.get(1).getText();
		Assert.assertEquals(productText,product);
		String categoryText=cols.get(2).getText();
		Assert.assertEquals(categoryText,category);
		String priceText=cols.get(3).getText();
		Assert.assertEquals(priceText,price);
		String stockText=cols.get(4).getText();
		Assert.assertEquals(stockText,stock);
	}
	}

}
