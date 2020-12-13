Feature: Emre tests

  Background: User is logged in
    Given I logged in Emre

    @Emre
    Scenario: Validate Search Box
      When I type "al" in "searchBox"
      Then I wait for "1000" milliseconds
      Then I get the "searchResult" as a list


