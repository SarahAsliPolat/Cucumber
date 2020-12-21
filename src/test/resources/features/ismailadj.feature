Feature: A description

  Background: User is logged in
    Given I am on the "LoginPage"
    When I wait for "loadLogin" to be "visible"
    Then I click on "loadLogin"
    Then I wait for "1000" milliseconds
    Then I enter "admin@staging-buffsci.org" in "emailSection"
    Then I wait for "1000" milliseconds
    Then I enter "admin123test" in "passwordSection"
    Then I wait for "loginButton" to be "clickable"
    Then I click on "loginButton"
    Then I wait for "newHireButton" to be "visible"
    Then I validate current page url is "https://hr-testing.buffsci.org/home"
    Then I am on the "SamplePage"

  @ismail
  Scenario: A scenario
    Then I am on the "IsmailPage"

    Then I Validate the newHire text list has these below

      | Salutation:       |
      | First Name:       |
      | Middle Name:      |
      | Last Name:        |
      | Vacant Positions: |
      | Personal Email:   |
      | Cell Phone:       |
