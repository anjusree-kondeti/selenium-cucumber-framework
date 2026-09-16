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
	 private By inputNewUser = By.xpath("//input[@id='newUser']");
     private By btnAddUser =By.xpath("//button[@id='addUserButton']");
     
     
	      
	           public void clickUsers() {
	        	   genericmethods.click(btnUsersMenu);
	           }
	           
	           
	           public void enterUser(String user) {
	        	   String s[]=user.split(" "); //["Rahul" "1"]
	        	   String name=s[0];
	        	   genericmethods.enterText(inputSearchUser,name);
	        	   
	           }
	    
	         
	           public void verifyUser(String user) throws InterruptedException {
	        	   String s[]=user.split(" ");
	        	   String name=s[0];
	        	   int rowNo=Integer.parseInt(s[1]);
	        	   WebElement table=driver.findElement(usersTable);
	        	   List<WebElement>rows=table.findElements(By.tagName("tr"));
	        	   List<WebElement>cols=rows.get(rowNo).findElements(By.tagName("td"));
	        	   String actualUser=cols.get(1).getText();
	        	   Assert.assertEquals(actualUser,name);
	        	   System.out.println("user is verified :" + actualUser);
	           }
	           
	        
	          
	          
	          public void newUser(String user) {
	        	  genericmethods.enterText(inputNewUser,user);
	        	  genericmethods.click(btnAddUser);
	          
	          }
	          
	          
//	          public void addUser() {
//	        	  genericmethods.click(btnAddUser);
	          
//	          }
	          
	          
	          public void verifyNewUser(String user) {
	        	  WebElement table=driver.findElement(usersTable);
	        	   List<WebElement>rows=table.findElements(By.tagName("tr"));
	        	   List<WebElement>cols=rows.get(4).findElements(By.tagName("td"));
                   String newUser=cols.get(1).getText();
                   Assert.assertEquals(newUser,user);         
	        	   
	        	   
	        	  
	          }
	

}
