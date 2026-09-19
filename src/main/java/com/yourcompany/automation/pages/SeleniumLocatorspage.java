package com.yourcompany.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.yourcompany.automation.factory.DriverFactory;
import com.yourcompany.automation.utils.GenericMethods;

public class SeleniumLocatorspage {
	
	private WebDriver driver;
	
	public SeleniumLocatorspage(WebDriver driver) {
		this.driver=driver;	
		}

	GenericMethods genericmethods = new GenericMethods();
	
	private By inputFullName= By.xpath("//input[@id='fullName']");
    private By inputEmail=By.xpath("//input[@id='email']");
	private By inputPassword=By.xpath("//input[@id='password']");
	private By txtAboutYou=By.xpath("//textarea[@id='about']");
	private By btnSubmit=By.xpath("//button[@id='submitButton']");
	private By sucessMsg=By.xpath("//p[@id='submitMessage']");
	private By radioButton=By.xpath("//input[@value='Female']");
	private By checkBox=By.xpath("//input[@value='Java']");
	private By selectCountry=By.xpath("//select[@id='country']");
	
	
	public void logIntoApplication(String url) {
		driver.get(url);
	}
	
	
	public void enterFullName() {
		genericmethods.enterText(inputFullName,"Anjusree");
	}
	
	
	public void enterEmail() {
		genericmethods.enterText(inputEmail,"anjusree132001@gmail.com");
	}
	
	
	public void enterPassword() {
		genericmethods.enterText(inputPassword,"Anju@123");
	}
	
	
	public void enterAboutYou() {
		genericmethods.enterText(txtAboutYou,"hi");
	}
	
	
	public void submit() {
		genericmethods.click(btnSubmit);
	}
	
	
	public void verifySuccessMsg(String text) {
		String sucessText=genericmethods.text(sucessMsg);
		Assert.assertEquals(sucessText,text);
		System.out.println("success");
	}
	
	
	public void clickButton() {
		genericmethods.click(radioButton);
	}
	
	
	public void verifyButton() {
		WebElement fBtn=driver.findElement(radioButton);
		boolean b= fBtn.isDisplayed();
		if(b) {
			System.out.println("displayed");
			fBtn.click();
		}
		else {
			System.out.println("not displayed");
		}
		
		boolean s= fBtn.isSelected();
		if(s) {
			System.out.println("selected");
		}else {
			System.out.println("not selected");
		}
	}
	
	
	public void clickBox() {
		genericmethods.click(checkBox);
	}
	
	
	
	public void verifyCheckBox() {
		WebElement cBox=driver.findElement(checkBox);
		boolean b =cBox.isDisplayed();
		if(b) {
			System.out.println("displayed");
			cBox.click();
		}else {
			System.out.println("not diaplyed");
		}
		
		boolean s =cBox.isSelected();
		if(s) {
			System.out.println("selected");
		}else {
			System.out.println("not selected");
		}
	}
	
	
	
	public void selectCountry() {
		WebElement countryDropdown = driver.findElement(selectCountry);
		Select select = new Select(countryDropdown);
		select.selectByIndex(1);
	}
	
	
	public void verifyDropDown() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
