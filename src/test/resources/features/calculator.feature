Feature: Calculator Functionality

  As a Customer when I perform a calculation,
  I want the answer displayed completely after pressing the '='
  button and evaluated by rounding up to the 4th decimal place


  @calc
  Scenario: Calculator app functionalty
    Given the user opens the calculator app
    When the user adds "23" and "95" and get the sum
    And takes the square root of that sum
    And multiply it by "-1"
    And verify the result
