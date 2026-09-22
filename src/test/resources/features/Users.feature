@Regression
Feature: users
@SearchUser
Scenario Outline: searchuser

Given I logged into the application

When I clicks on user menu 

And I searches the user '<user>'
 
Then I verify user '<user>' is found  

Examples: 
|user   |
|Rahul 1|
|Priya 2|
|Arun 3 |
@Useradd
Scenario: adduser

Given I logged into the application

When I clicks on user menu 

And I adds the new user '<user>'

Then I verifies the new user '<user>'

Examples:
|user  | 
|anju  |
|meghna|