package com.yourcompany.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.yourcompany.automation.utils.GenericMethods;

public class Userspage {
	
	private WebDriver driver;
	
	public Userspage(WebDriver driver) {
		this.driver=driver;
	}
	
	GenericMethods genericmethods=new GenericMethods();
	
	private By btnUsersMenu =  By.xpath("//button[text()='Users']");
	private By inputSearchUser = By.xpath("//input[@id='userSearch']");
	 private By usersTable =  By.xpath("//table[@id='userTable']");
	      
	           public void clickUsers() {
	        	   genericmethods.click(btnUsersMenu);
	           }
	           
	           
	           public void enterUser(String user) {
	        	   genericmethods.enterText(inputSearchUser,user);
	        	   
	           }
	    
	           public void verifyUser(String user) {
	        	   WebElement table=driver.findElement(usersTable);
	        	   List<WebElement>rows=table.findElements(By.tagName("tr"));
	        	   List<WebElement>cols=rows.get(1).findElements(By.tagName("td"));
	        	   String actualUser=cols.get(1).getText();
	        	   Assert.assertEquals(actualUser,user);
	        	   System.out.println("user is verified :" + actualUser);
	           }
	

}
