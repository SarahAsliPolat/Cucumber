
  Feature: Suray Test
    Background:user is in the login page
      Given I logged in Suray
      And I set my page "SurayPage"
    @tabs
  Scenario: As an admin, I should see Basic, Details, Attendance and Files tabs on the upper right part of the form header
    Then the user validates the basicTab in the right side of the page

      |Basic        |
      |Details      |
      |Attendance   |
      |Files        |

    @Columns
    Scenario:As a user, I need to see applicants as a table that consists of six columns
    (Location, Applied to Position, First Name & Last Name, Internal, Interview Rates, and Status)
      When the user clicks to "applicants"
      Then  the user should see the  following columns

        |Location              |
        |Applied To Position   |
        |First Name & Last Name|
        |Internal              |
        |Interview Rates       |
        |Status                |

