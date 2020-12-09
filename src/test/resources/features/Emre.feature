Feature: Emre tests

  Background: User is logged in
    Given I logged in Emre

    @Emre
    Scenario: Emre test
      When I click on "newHireButton" as Emre
      Then I wait for "3000" milliseconds