Feature: As an admin, when I click on Details tab,
  I should be able to see the data of selected staff.

  Background: User is logged in
    Given I logged in Gulshat

  #RT-4
  Scenario: Gulshat test
    When I click on "details" tab as Gulshat
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

  @Gulshat
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
