package com.yourcompany.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.yourcompany.automation.factory.DriverFactory;

public class GenericMethods {
	
	
	
	public static void click(By locator) {
		DriverFactory.getDriver().findElement(locator).click();
    	}
    
    public static String text(By locator) {
    	String text= DriverFactory.getDriver().findElement(locator).getText();
    	return text;
    }
    
     
    public static void enterText(By locator,String text) {
    	DriverFactory.getDriver().findElement(locator).sendKeys(text);
    }

}
