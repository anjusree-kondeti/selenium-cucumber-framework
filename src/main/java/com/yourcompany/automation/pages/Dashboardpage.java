package com.yourcompany.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.yourcompany.automation.utils.GenericMethods;
import com.yourcompany.automation.utils.WaitUtils;

public class Dashboardpage {
	
	private WebDriver driver;
	
	public Dashboardpage(WebDriver driver) {
		this.driver=driver;
	}
	GenericMethods genericmethods=new GenericMethods();
	
	private By totalUsers=By.xpath("//div[text()='Total Users']/following-sibling::div");
	private By products=By.xpath("//div[text()='Products']/following-sibling::div");
	private By orderToday=By.xpath("//div[text()='Orders Today']/following-sibling::div");
	private By revenue=By.xpath("//div[text()='Revenue']/following-sibling::div");
	
	      
	
	          public String getTotalUsers() {
//	        	 String users= driver.findElement(totalUsers).getText();
//	        	 System.out.println(users);
	        	  String users=GenericMethods.text(totalUsers);
	        	 	 System.out.println(users);
	        	 	 return users;
	          }
	          
	          public String getProducts() {
	        	  String product= driver.findElement(products).getText();
	        	  System.out.println(product);
	        	  return product;
	          }
	          
	          public String getOrderToday() {
	        	  String orders=driver.findElement(orderToday).getText();
	        	  System.out.println(orders);
	        	  return orders;
	          }
	          
	          public String getRevenue() {
	        	  String revenues = driver.findElement(revenue).getText();
	        	  System.out.println(revenues);
	        	  return revenues;
	          }
	          
	          
	          
	          
	
	

}
