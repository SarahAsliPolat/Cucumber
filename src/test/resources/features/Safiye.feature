@Safiye
Feature: test
  Background: User is logged in
    Given I logged in as Safiye

Scenario:
  When I click on "terminationButton" as Safiye
  Then I should see the "terminationDate" as Safiye
  And I should see the "reasonDropdown" as Safiye
  Then I should see the "saveButton" as Safiye
  Then I should see the "cancelButton" as Safiye




