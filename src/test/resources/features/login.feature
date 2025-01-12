@done
Feature: Login functionality

  @smoke @login
  Scenario: Check Login page with valid credentials
    Given user navigates to catchylab login page
    When user logged in with valid credentials
    Then verify that user on the home page

  @negative @login
  Scenario Outline: Check Login with invalid credentials
    Given user navigates to catchylab login page
    When user logged in with "<username>" and "<password>"
    Then verify that error message is "Username or Password Invalid!"
    Examples:
      | username      | password        |
      | validusername | invalidpassword |
      | test@test.com | validpassword   |
      |               | validpassword   |
      | validusername |                |


