@done
Feature: Add Money Functionality

  Background: Login steps
    Given user navigates to catchylab login page
    When user logged in with valid credentials
    Then verify that user on the home page

  @addMoney @smoke
  Scenario: Check Add Money to Account Balance
    When user navigates money transfer page
    And check the total amount
    And user open add money modal
    And user add "100" to account
    Then verify that total amount changed based on added amount
    And verify that transaction shows latest action as "100"

  @pass
  Scenario: Check Invalid Expiry Date
    When user navigates money transfer page
    And user open add money modal
    And user enter expiry date as "15/25"
    Then verify expiry date error message is "Wrong date. Please give a correct date"

  @pass
  Scenario: Check Invalid Card Holder Name
    When user navigates money transfer page
    And user open add money modal
    And user enter short card holder name as "abc"
    Then verify card holder error message is "Too Short!"

  @pass
  Scenario: Check required error
    When user navigates money transfer page
    And user open add money modal
    And user attempt to add money without credentials
    Then verify card all fields have "Required" error message

  @fail
  Scenario: Check Invalid Card Number
    When user navigates money transfer page
    And user open add money modal
    And user enter card number as "123 123"
    Then verify user can enter card holder name

  @fail
  Scenario: Check Long Card Number Field
    When user navigates money transfer page
    And user open add money modal
    And user enter long card number as "12341234123123123123"
    Then verify user can enter card holder name
