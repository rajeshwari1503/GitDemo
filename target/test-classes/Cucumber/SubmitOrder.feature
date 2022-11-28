
Feature: Purchase the order from ecommerce website
  I want to use this template for my feature file

Background: 
Given I landed on ecommerce website page

 @Add
  Scenario Outline: Positive test for submitting the order
    Given Logged in with username <userName> and password <password>
    When  I add product <productName> to cart 
    And   Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message displayed on ConfirmationPage 

    Examples: 
      | userName                | password  | productName  |
      |raji.rajeshwari@gmail.com| Divya@1503| ZARA COAT 3  |