Feature:loginfunctionality
@Login
Scenario:successfullylogin

Given user is on the login page

When the user enters the valid username and password

And click on the login button

Then the dashboard should be displayed

Scenario:successfullylogged in

Given I logged into the application 

