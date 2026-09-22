package com.yourcompany.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.yourcompany.automation.factory.DriverFactory;

public class GenericMethods {
	
	
	
	public  void click(By locator) {
		DriverFactory.getDriver().findElement(locator).click();
    	}
    
    public  String text(By locator) {
    	String text= DriverFactory.getDriver().findElement(locator).getText();
    	return text;
    }
    
     
    public void enterText(By locator,String text) {
    	DriverFactory.getDriver().findElement(locator).sendKeys(text);
    }

}
