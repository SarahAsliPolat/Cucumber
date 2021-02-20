
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


@ismail002
  Scenario: Validate the Basic,Details, Attendance, Files Tabs are present on the staff page
    Given I am on the "IsmailPage" as ismail
    When I click on "StaffButton" as ismail
    And  I wait for "StaffButmenu" to be "visible" as ismail
    Then I validate that "Basic" element is visible on the page as ismail
    And I validate that "Details" element is visible on the page as ismail
    And I validate that "Attendance" element is visible on the page as ismail
    And I validate that "Files" element is visible on the page as ismail








