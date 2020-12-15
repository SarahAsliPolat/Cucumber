Feature: fatih tests
  Background: User is logged in
    Given I logged in fatih
  @Fatih
Scenario: fatih test
  When i run the test
    When i click on "newhire" button
    Then I wait for "3000" miliseconds