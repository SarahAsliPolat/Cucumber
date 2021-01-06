Feature: As an admin, when I click on New Hire button,
  in the New Hire window following fields should be mandatory: Salutation, First Name,
  Last Name, Personal Email, and Cell Phone

  Background: user is logged in
    Given I logged in Vusala


  @Vusala
  Scenario: Vusala test
    When I click on "newHireButton" as Vusala
    And I wait for "200" milliseconds
    Then I click on "saveButton" as Vusala
    And I wait for "200" milliseconds
    And I validate "The salutation field is required." message is displayed
    And I validate "The first name field is required." message is displayed
    And I validate "The last name field is required." message is displayed
    And I validate "The personal email must be a valid email address." message is displayed
    And I validate "The cell phone field is required." message is displayed

 @Vusala2
Scenario: Delete position
   When I click on "Positions" as Vusala
   Then I click on "AddNew" as Vusala
   And I wait for "200" milliseconds
   Then I click on "Title" as Vusala
   Then I enter "AZ_dili" in the "Title" as Vusala
   Then I select element from "Position Type"
   Then I select element from "Location"
   Then I select element from "Reports To"
   And I scroll and click to "Save" as Vusala
   And I wait for "500" milliseconds
   And I validate "toasterValidation" toaster message is displayed
   Then I enter "AZ_dili" in the "Search" as Vusala
   Then I click on "deleteButton" as Vusala
   And I wait for "200" milliseconds
   Then I validate "ConfirmToDelete" Pop-Up page displayed
   Then I click on "ok" as Vusala
   And I validate "toasterValidation" toaster message is displayed
   And I wait for "200" milliseconds
   And I validate "Showing 0 to 0 of 0 entries (filtered from 202 total entries)" message is displayed


