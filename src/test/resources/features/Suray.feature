
  Feature: As an admin, I should see Basic, Details, Attendance and Files tabs on the upper right part of the form header
    Background:user is in the login page
      Given I am on the "LoginPage"
      When I wait for "loadLogin" to be "visible"
      Then I click on "loadLogin"
      Then I wait for "1000" milliseconds
      Then I enter "admin@staging-buffsci.org" in "emailSection"
      Then I wait for "1000" milliseconds
      Then I enter "admin123test" in "passwordSection"
      Then I wait for "loginButton" to be "clickable"
      Then I click on "loginButton"
      Then I wait for "newHireButton" to be "visible"
      Then I validate current page url is "https://hr-testing.buffsci.org/home"
      Then I am on the "SamplePage"

    @tabs
  Scenario: Validate tabs
    Then the user validates the basicTab in the right side of the page

      |Basic        |
      |Details      |
      |Attendance   |
      |Files        |

