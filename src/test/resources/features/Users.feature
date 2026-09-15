Feature: users
@SearchUser
Scenario Outline: searchuser

Given I logged into the application

When I clicks on user menu 

And I searches the user '<user>'
 
Then I verify user '<user>' is found  

Examples: 
|user |
|Rahul|
#|Priya|
#|Arun |

Scenario: adduser

Given I logged into the application

When I clicks on user menu 

And I adds the new user 

Then I verifies the new user 