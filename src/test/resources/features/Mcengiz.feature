Feature: MCengiz tests

  Background: User is logged in
    Given I logged in MCengiz


  @MCengiz @MCengiz001
  Scenario: Validate Position Filter in Applicants Page
    Given I am on the "McengizPage"
    When I click on "Applicants"
    Then I validate that "Position" filter is working as expected
    