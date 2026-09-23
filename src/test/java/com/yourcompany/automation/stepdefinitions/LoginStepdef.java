package com.yourcompany.automation.stepdefinitions;

import com.yourcompany.automation.factory.DriverFactory;
import com.yourcompany.automation.pages.Loginpage;
import com.yourcompany.automation.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdef {
      Loginpage loginPage;
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		loginPage = new Loginpage(DriverFactory.getDriver());
	   loginPage.enterUrl(ConfigReader.get("url"));
	}

	@When("the user enters the valid username and password")
	public void the_user_enters_the_valid_username_and_password() {
	    loginPage.enterUsername(ConfigReader.get("username"));
	    loginPage.enterUsername(ConfigReader.get("password"));
	    
	}

	@When("click on the login button")
	public void click_on_the_login_button() {
		loginPage.clickLogin();
	    
	}

	@Then("the dashboard should be displayed")
	public void the_dashboard_should_be_displayed() {
	    
	}
	
	
	@Given("I logged into the application")
	public void i_logged_into_the_application() throws InterruptedException {
		loginPage = new Loginpage(DriverFactory.getDriver());
	   loginPage.enterUrl(ConfigReader.get("url"));
	   loginPage.enterUsername(ConfigReader.get("username"));
	    loginPage.enterPassword(ConfigReader.get("password"));
	    loginPage.clickLogin();
	}
	
	
	
}
