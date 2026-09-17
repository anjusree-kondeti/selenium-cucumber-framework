Feature: products
@Products
Scenario Outline: verifyproducts

Given I logged into the application 

When I clicked on products menu 

Then I verify the products '<product>' '<category>' '<price>' '<stock>'

Examples:
| product | category | price | stock |
|Wireless Mouse | Electronics | ₹799 | 120 |
|Mechanical Keyboard | Electronics | ₹2,999 | 45 |
|Running Shoes | Clothing | ₹3,499 | 18 |
|Desk Lamp | Home| ₹1,299 | 0 |
