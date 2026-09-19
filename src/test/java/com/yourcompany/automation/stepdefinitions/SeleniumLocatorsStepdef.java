package com.yourcompany.automation.stepdefinitions;

import com.yourcompany.automation.factory.DriverFactory;
import com.yourcompany.automation.pages.SeleniumLocatorspage;
import com.yourcompany.automation.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumLocatorsStepdef {
	
	SeleniumLocatorspage locatorsPage;
	
	@Given("I logged into the selenium pratice lab application")
	public void i_logged_into_the_selenium_pratice_lab_application() {
		locatorsPage=new SeleniumLocatorspage(DriverFactory.getDriver());
		locatorsPage.logIntoApplication(ConfigReader.get("url2"));
	    
	}

	@When("I enter the full name")
	public void i_enter_the_full_name() {
	    locatorsPage.enterFullName();
	}

	@When("I enter the email")
	public void i_enter_the_email() {
		locatorsPage.enterEmail();
	}

	@When("I enter the password")
	public void i_enter_the_password() {
		locatorsPage.enterPassword();
	}

	@When("I enter about you")
	public void i_enter_about_you() {
		locatorsPage.enterAboutYou();
	}

	@Then("I click on submit")
	public void i_click_on_submit() {
		locatorsPage.submit();
	}
	
	@Then("I verify the success message")
	public void i_verify_the_success_message() {
		locatorsPage.verifySuccessMsg("Form submitted successfully!");
	}
	
	
	
	//RADIOBUTTONS
	
	@When("I click on the radio button")
	public void i_click_on_the_radio_button() {
	   locatorsPage.clickButton();
	}

	@Then("I verify the radio button is selected")
	public void i_verify_the_radio_button_is_selected() {
	   locatorsPage.verifyButton();
	}
	
	
	
	
	//CHECKBOXES
	
	@When("I click on the checkboxes")
	public void i_click_on_the_checkboxes() {
	    locatorsPage.clickBox();
	}

	@Then("I verify the checkbox is selected")
	public void i_verify_the_checkbox_is_selected() {
	    locatorsPage.verifyCheckBox();
	}
	
	
	
	//DROPDOWNS
     
	@When("I select the dropdown value")
	public void i_select_the_dropdown_value() {
		locatorsPage.selectCountry();
	}
	    

	@Then("I verify the dropdown value is selected")
	public void i_verify_the_dropdown_value_is_selected() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
