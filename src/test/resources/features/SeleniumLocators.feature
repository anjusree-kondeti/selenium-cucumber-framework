Feature:Selenium locators
@Locators
Scenario: Basic login details

Given I logged into the selenium pratice lab application 

When I enter the full name 

And  I enter the email 

And I enter the password 

And I enter about you 

And I click on submit 

Then I verify the success message 


@RadioButtons
Scenario: checking radio buttons 

Given I logged into the selenium pratice lab application 

When I click on the radio button 

Then I verify the radio button is selected  


@Checkboxes
Scenario: checking checkboxes 

Given I logged into the selenium pratice lab application 

When I click on the checkboxes 

Then I verify the checkbox is selected 


@DropDowns
Scenario: checking dropdowns

Given I logged into the selenium pratice lab application 

When I select the dropdown value 

Then I verify the dropdown value is selected
















































































