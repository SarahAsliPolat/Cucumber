Feature: As an admin, when I click on New Hire button,
  in the New Hire window following fields should be mandatory: Salutation, First Name,
  Last Name, Personal Email, and Cell Phone

  Background: user is logged in
    Given I logged in Vusala


  @Vusala
  Scenario: Vusala test
    When I click on "newHireButton" as Vusala
    And I wait for "500" milliseconds
    Then I click on "saveButton" as Vusala
    And I wait for "500" milliseconds
    And I validate "The salutation field is required." message is displayed
    And I validate "The first name field is required." message is displayed
    And I validate "The last name field is required." message is displayed
    And I validate "The personal email must be a valid email address." message is displayed
    And I validate "The cell phone field is required." message is displayed