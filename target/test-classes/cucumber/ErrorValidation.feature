
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landend on page
    When I Logged in with <name> and <password>
    Then "Incorrect email or password." Error Message is Displayed

    Examples: 
      | name        | password | 
      | s@gmail.com |     Nikhil97@ | 