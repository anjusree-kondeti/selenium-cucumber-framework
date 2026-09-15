package com.yourcompany.automation.stepdefinitions;

import com.yourcompany.automation.factory.DriverFactory;
import com.yourcompany.automation.pages.Userspage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersStepdef {
	
	Userspage userpage;
	
	@When("I clicks on user menu")
	public void i_clicks_on_user_menu() {
		userpage = new Userspage(DriverFactory.getDriver());
	    userpage.clickUsers();
	}

	
	
	@When("I searches the user {string}")
	public void i_searches_the_user(String user) {
	    userpage.enterUser(user);
	}

	@Then("I verify user {string} is found")
	public void i_verify_user_is_found(String user) {
	    userpage.verifyUser(user);
	}

	@When("I adds the new user")
	public void i_adds_the_new_user() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I verifies the new user")
	public void i_verifies_the_new_user() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
