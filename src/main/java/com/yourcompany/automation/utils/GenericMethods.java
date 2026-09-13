package com.yourcompany.automation.utils;

import org.openqa.selenium.By;

import com.yourcompany.automation.factory.DriverFactory;

public class GenericMethods {
	
	
	public static void click(By locator) {
    	DriverFactory.getDriver().findElement(locator).click();
    	}
    
    public static String text(By locator) {
    	String text= DriverFactory.getDriver().findElement(locator).getText();
    	return text;
    }

}
