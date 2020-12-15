Feature: As an admin, when I click on Details tab,
  I should be able to see the data of selected staff.

  Background: User is logged in
    Given I logged in Gulshat

  @Gulshat
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