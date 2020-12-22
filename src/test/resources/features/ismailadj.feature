
Feature: A description

  Background: User is logged in
    Given I am on the "LoginPage" as ismail
    When I wait for "loadLogin" to be "visible" as ismail
    Then I click on "loadLogin" as ismail
    Then I wait for "1000" milliseconds as ismail
    Then I enter "admin@staging-buffsci.org" in "emailSection" as ismail
    Then I wait for "1000" milliseconds as ismail
    Then I enter "admin123test" in "passwordSection" as ismail
    Then I wait for "loginButton" to be "clickable" as ismail
    Then I click on "loginButton" as ismail
    Then I wait for "newHireButton" to be "visible" as ismail
    Then I am on the "IsmailPage" as ismail

  @ismail
  Scenario: A scenario
    Then I click on "newHireButton" as ismail
    Then I Validate the jobFilterList drop down list has these below as ismail

      |Salutation:|
      |First Name:|
      |Middle Name:|
      |Last Name:|
      |Vacant Positions:|
      |Personal Email:|
      |Cell Phone:|
