Feature: Gulshat test

  Background: User is logged in
    Given I logged in Gulshat

  @Gulshat
  Scenario: Gulshat test
    When I click on "newHireButton" as Gulshat
    Then I wait for "1000" milliseconds
    Then I verify value is as expected