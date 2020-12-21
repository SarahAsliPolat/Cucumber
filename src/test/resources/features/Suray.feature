
  Feature: As an admin, I should see Basic, Details, Attendance and Files tabs on the upper right part of the form header
    Background:user is in the login page
      Given I logged in Suray
    @tabs
  Scenario: Validate tabs
    Then the user validates the basicTab in the right side of the page

      |Basic        |
      |Details      |
      |Attendance   |
      |Files        |

