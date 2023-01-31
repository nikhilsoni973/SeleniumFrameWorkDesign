
@tag
Feature: Submit Order from ecommerce
  I want to use this template for my feature file
  
  Background:
  Given I landend on page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given I Logged in with <name> and <password>
    When add the product <productName> to cart
    And checkout <productName> and submit the order 
    Then "THANKYOU FOR THE ORDER." is displayed on confirmation page.
    Examples: 
      | name          | password  |  productName |
      | s101@gmail.com | Nikhil97@ | ZARA COAT 3 |
      | s102@gmail.com | Nikhil97@ | ADIDAS ORIGINAL |
