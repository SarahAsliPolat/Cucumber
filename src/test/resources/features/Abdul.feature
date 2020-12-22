Feature: Abdul tests

  Background: User is logged in
    Given I logged in as Abdul

  @Abdul
  Scenario: Abdul test
    When I click on "editHomeButton" as Abdul
    Then I should see "addressLine1" as Abdul
    And I should see "addressLine2" as Abdul
    And I should see "cityField" as Abdul
    And I should see "stateField" and it should show "NY"
    And I should see "zipCodeField" as Abdul
    And I should see "phoneField" as Abdul
    And I should see "cancelButton" as Abdul
    And I should see "saveButton" as Abdul
