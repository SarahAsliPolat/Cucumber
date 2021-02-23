Feature: As an admin, when I click on Details tab,
  I should be able to see the data of selected staff.

  Background: User is logged in
    Given I logged in Gulshat

  #RT-4
  Scenario: Gulshat test
    When I click on "details" as Gulshat
    And I wait for "500" milliseconds
    Then I verified that "originalHireDate" element is exist with "Original Hire Date:" text
    Then I verified that "contractWorkDays" element is exist with "Contract Work Days:" text
    Then I verified that "employmentBasis" element is exist with "Employment Basis:" text
    Then I verified that "educationalLevel" element is exist with "Education Level:" text
    Then I verified that "annualContractWorkMonth" element is exist with "Annual Contract Work Months:" text
    Then I verified that "previousYearsOfTeachingExperience" element is exist with "Previous Years of Teaching Experience:" text
    Then I verified that "birthDate" element is exist with "Birth Date:" text
    Then I verified that "gender" element is exist with "Gender:" text
    Then I verified that "nativeLanguage" element is exist with "Native Language:" text
    Then I verified that "secondaryLanguage" element is exist with "Secondary Language:" text
    Then I verified that "placeOfBirth" element is exist with "Place of Birth:" text
    Then I verified that "countryOfOrigin" element is exist with "Country of Origin:" text
    Then I verified that "hispanic" element is exist with "Hispanic:" text
    Then I verified that "race" element is exist with "Race:" text

  #RT-13
  Scenario: Validate Job box dropdown list
    Then I validate position filter is working

  #RT-20
  Scenario:Validate Applicants sub-page and Edit button
    When I click on "applicants" as Gulshat
    And I wait for "300" milliseconds
    Then I click on "edit" as Gulshat
    Then I wait for "3000" milliseconds
    Then I validate the details below are present on the applicant information page
      | Applied At:         |
      | Address:            |
      | Email:              |
      | Experience:         |
      | Certifications:     |
      | Resume / Documents: |
      | Recent Updates:     |
      | Updated At:         |
      | Phone Number:       |
      | Notes:              |

  #RT-25
  Scenario: Save as a new position
    When I click on "positionsPage" as Gulshat
    Then I click on "addNew" as Gulshat
    And I wait for "200" milliseconds
    And I enter "Scrum master" in the "titleBox" as Gulshat
    When I select "CFO" from "positionDropDown" drop-down
    And I select "District Office" from "locationDropDown" drop-down
    And I wait for "500" milliseconds
    And I select "Altenwerth, Ned (Geo)" from "assignedStaff" drop-down
    And I wait for "500" milliseconds
    And  I click on "confirmOk" as Gulshat
    And I wait for "500" milliseconds
    When I select "Begum, Gregory (Hall Monitor)" from "reportsToDropDown" drop-down
    And I wait for "200" milliseconds
    And I click on "Supervisor_No" as Gulshat
    And I click on "posted_Yes" as Gulshat
    And I wait for "500" milliseconds
    And I enter "test document" in the "noteBox" as Gulshat
    And I wait for "200" milliseconds
    And I scroll down and click to "save" button as Gulshat
    And I wait for "300" milliseconds
    Then I validate "staffPositionSaved" toaster message is displayed
    And I wait for "300" milliseconds
    And I enter "Scrum master" in the "searchBox"
    And I wait for "300" milliseconds
    And I click on "edit" as Gulshat
    Then I validate the details below are present on the new position  page
      | Scrum master                  |
      | CFO                           |
      | District Office               |
      | Altenwerth, Ned (Geo)         |
      | Begum, Gregory (Hall Monitor) |
      | test document                 |
    And I wait for "5000" milliseconds
    And I click on "closeButton" as Gulshat
    And I wait for "200" milliseconds
    And I click on "deleteButton" as Gulshat
    And I wait for "200" milliseconds
    And I click on "ok" as Gulshat

  @Gulshat
#RT-28
  Scenario: Reason and a dropdown list should appear
    When I click on "termination" as Gulshat
    And I wait for "300" milliseconds
    And I click on "ReasonDropDown" as Gulshat
    Then I validate that the list below is present on the "ReasonDropDownList"
      | Resignation                     |
      | Retirement                      |
      | Performance related termination |
      | Other                           |


  @API @5
  Scenario: Post Create
    When I create a user in post api

  Scenario: Delete user
    When I delete a user

  @Gulshat_001
  Scenario:Validate Select Location filter on Applicatns page is working.
    When I click on "Applicants" as Gulshat
    And I wait for "3000" milliseconds
    And I select "High School" from "selectLocation_dd" drop-down
    Then I validate "High School" Applicants are displayed
    And I select "Elementary" from "selectLocation_dd" drop-down
    Then I validate "Elementary" Applicants are displayed







    