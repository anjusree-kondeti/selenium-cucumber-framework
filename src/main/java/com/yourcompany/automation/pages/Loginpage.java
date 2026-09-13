package com.yourcompany.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.yourcompany.automation.utils.GenericMethods;
import com.yourcompany.automation.utils.WaitUtils;

public class Loginpage {
	
	
	private WebDriver driver;
	
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By username=By.xpath("//input[@id='loginUser']");
	private By password=By.xpath("//input[@id='loginPass']");
	private By login=By.xpath("//button[@id='loginButton']");
	
	
	    public void enterUrl(String url) {
	    	driver.get(url);
	    }
	
	
        public void enterUsername(String userName) {
        	WebElement user = WaitUtils.waitForVisibility(username);
        	driver.findElement(username).sendKeys(userName);
        }
        
        
        public void enterPassword(String Pswd) {
        	driver.findElement(password).sendKeys(Pswd);
        }
        
        
        public void clickLogin() {
        	//driver.findElement(login).click();
        	GenericMethods.click(login);
        }
         
        
        
}
