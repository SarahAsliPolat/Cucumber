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
   And I select "Custodian" from "PositionType" dropDownList
   And I select "Elementary" from "Location" dropDownList
   And I select "Roberts, June (Art)" from "ReportsTo" dropDownList
   And I scroll and click to "Save" as Vusala
   And I wait for "500" milliseconds
   And I validate "toasterValidation" toaster message is displayed
   Then I enter "AZ_dili" in the "Search" as Vusala
   Then I click on "deleteButton" as Vusala
   And I wait for "200" milliseconds
   Then I validate "ConfirmToDelete" Pop-Up page displayed
   Then I click on "ok" as Vusala
   And I validate "toasterValidation" toaster message is displayed
   And I wait for "1000" milliseconds
   And I validate "No matching records found" message is displayed
   And I wait for "1000" milliseconds

@Vusala3 @RT-23
Scenario: Remove filters
  When I click on "Positions" as Vusala
  And I select "Elementary" from "SelectLocation" dropDownList
  And I select "College Guidance" from "SelectPosition" dropDownList
  And I select "Interviewed" from "SelectStatus" dropDownList
  When I click on "ClearFilters" as Vusala
  Then I validate "- Select Location -" text is displayed in "location" dropDown list
  Then I validate "- Select Position -" text is displayed in "position" dropDown list
  Then I validate "- Select Status -" text is displayed in "status" dropDown list

@Vusala4 @RT-26
Scenario:  Buffsci home
  When I click on "Applicants" as Vusala
  And I validate that "Applicants" element is visible on the page
  And I click on "BuffsciTitle" as Vusala
  And I wait for "900" milliseconds
  Then I validate that "StaffList" element is visible on the page

  @Vusala5 @RT-27
    Scenario:  I should be able to see Termination Date and an input box
    When I click on "Termination" as Vusala
    And I wait for "200" milliseconds
    And I validate that "TerminationDate" element is visible on the page
    Then I validate that "InputBox" element is visible on the page

  @Vusala6 @API1
      Scenario: get staff info staff ID
      When I print staff info with staff ID

  @Vusala7 @API2
    Scenario: Create Post
    When I create a new user

  @Vusala8 @API3
    Scenario: Put Update
    When I put new information


  @Vusala9 @API4
    Scenario: Delete the user
  When  Delete the user

    @Vusala10 @RT-44
    Scenario: Choose element from Select Location drop-down list
      When I click on "Positions" as Vusala
       And I select "District Office" from "SelectLocation" dropDownList
       And I wait for "200" milliseconds
      Then I Validate only "District Office" Positions are displayed from "PositionsOfDistrictOffice"


