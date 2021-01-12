Feature: Vusala tests

  Background: user is logged in
    Given I logged in Vusala


  @Vusala1 @RT-6
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

 @Vusala2 @RT-12
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
   And I validate "No matching records found" message is displayed

@Vusala3 @RT-23
Scenario: Remove filters
  When I click on "Positions" as Vusala
  Then I select element from "location"
  Then I select element from "position"
  Then I select element from "status"
  When I click on "ClearFilters" as Vusala
  Then I validate "- Select Location -" text is displayed in "location" dropDown list
  Then I validate "- Select Position -" text is displayed in "position" dropDown list
  Then I validate "- Select Status -" text is displayed in "status" dropDown list

@Vusala4 @RT-26
Scenario:  Buffsci title
  When I click on "Applicants" as Vusala
  And I validate that "Applicants" element is visible on the page
  And I click on "BuffsciTitle" as Vusala
  And I wait for "900" milliseconds
  Then I validate that "StaffList" element is visible on the page