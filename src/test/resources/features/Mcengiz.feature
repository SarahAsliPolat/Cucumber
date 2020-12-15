Feature: MCengiz tests

  Background: User is logged in
    Given I logged in MCengiz


    @MCengiz
    Scenario: MCengiz test
      When I click on "newHireButton" as MCengiz
      Then I wait for "3000" milliseconds