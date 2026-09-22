package com.yourcompany.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	private By selectCity=By.xpath("//select[@id='city']");
	private By hoverMe=By.xpath("//div[@id='hoverMenu']");
    private By hoverText=By.xpath("//span[@id='hoverText']");
    private By rightClick=By.xpath("//button[@id='rightClickButton']");
    private By rText=By.xpath("//p[@id='mouseMessage']");
    private By doubleClick=By.xpath("//button[@id='doubleClickButton']");
    private By doubleText=By.xpath("//p[@id='mouseMessage']");
	
	
	
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
	
	
	public void clickButton(String radioButton) {
		WebElement fBtn=driver.findElement(By.xpath("//input[@value=" +"'"+radioButton+"'"+"]")); //By.xpath("//input[@value='Female']");
		boolean b= fBtn.isDisplayed();
		if(b) {
			System.out.println("displayed");
			fBtn.click();
		}
		else {
			System.out.println("not displayed");
		}
	}
	
	
	public void verifyButton() {
		WebElement fBtn=driver.findElement(radioButton);
				
		boolean s= fBtn.isSelected();
		if(s) {
			System.out.println("selected");
		}else {
			System.out.println("not selected");
		}
	}
	
	
	public void clickBox() {
		WebElement cBox=driver.findElement(checkBox);
		boolean b =cBox.isDisplayed();
		if(b) {
			System.out.println("displayed");
			cBox.click();
		}else {
			System.out.println("not diaplyed");
		}
	
	}
	
	public void verifyCheckBox() {
		WebElement cBox=driver.findElement(checkBox);
		
		
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
		 WebElement cityDropDown=driver.findElement(selectCity);
			cityDropDown.click();
	driver.findElement(By.xpath("//option[text()='Bangalore']")).click();
			cityDropDown.click();
	    
		
	}
	
	
   public void verifyDropDown(String text) {
	  
		String actualText=driver.findElement(By.xpath("//option[text()='Bangalore']")).getText();
		Assert.assertEquals(actualText,text);
	}
	
	
	
	
	public void mouseActions() {
		Actions actions = new Actions(driver);
		WebElement mouseHoverMe=driver.findElement(hoverMe);
		actions.moveToElement(mouseHoverMe).perform();
		WebElement text=driver.findElement(hoverText);
		WebElement rClick=driver.findElement(rightClick);
		actions.contextClick(rClick).perform();
		WebElement rightText=driver.findElement(rText);
		WebElement dClick=driver.findElement(doubleClick);
		actions.doubleClick(dClick);
		WebElement dText=driver.findElement(doubleText);
	}
	
	
	
	public void verifyMouseActions(String hoverMouseText) {
		Actions actions = new Actions(driver);
		WebElement mouseHoverMe=driver.findElement(hoverMe);
		actions.moveToElement(mouseHoverMe).perform();
		
		WebElement text=driver.findElement(hoverText);		
		boolean h=text.isDisplayed();
		if(h) {
			System.out.println("displayed");
			
		}else {
			System.out.println("not displayed");
		}
		String hText= text.getText();
		Assert.assertEquals(hText, hoverMouseText);
		
	}
	
	
	
	
	

	
	
	
	
	
	
}
