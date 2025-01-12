@done
Feature: Transfer Money functionality

  Background: Login steps
    Given user navigates to catchylab login page
    When user logged in with valid credentials
    Then verify that user on the home page

  @checkSenderAccount
  Scenario: Check Sender Account Name
    When user navigates money transfer page
    And check the account name
    And user open money transfer modal
    Then verify that sender account name is correct

  @smoke @transferMoney @fail
  Scenario: Check Transfer Detail
    When user navigates money transfer page
    And check the total amount
    And user open money transfer modal
    And user transferred "100"
    Then verify that total amount changed based on transferred amount
    And verify that transaction shows latest action as "100"


  @fail @transferMoney
  Scenario Outline: Check Invalid Amounts Transfer
    When user navigates money transfer page
    And check the total amount
    And user open money transfer modal
    And user transferred "<amount>"
    Then verify that total amount is not changed
    Examples:
      | amount |
      | -500   |
      | 0      |


  @fail @transferMoney
  Scenario: Check receiver account is changed
    When user navigates money transfer page
    And check the total amount
    And user open money transfer modal
    And user change the receiver account as "Testinium-2"
    Then verify that receiver account changed to "Testinium-2"


