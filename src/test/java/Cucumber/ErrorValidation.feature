
Feature: Error Validation 
  I want to use this template for my feature file
  

 @ErrorValidation 
  Scenario Outline: Test for validating username and password
    Given I landed on ecommerce website page
    When Logged in with username <userName> and password <password>
    Then "Incorrect email or password." message is displayed

   Examples: 
      | userName                | password  |
      |raj.rajeshwari@gmail.com | Divya@153 | 