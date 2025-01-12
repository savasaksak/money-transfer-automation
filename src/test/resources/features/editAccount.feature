@done
Feature: Edit Account functionality

  Background: Login steps
    Given user navigates to catchylab login page
    When user logged in with valid credentials
    Then verify that user on the home page

  @editAccount
  Scenario: Edit Account Name
    When user navigates money transfer page
    And user edit account modal
    And user change account name with "new account"
    Then verify that account name updated as "new account"


