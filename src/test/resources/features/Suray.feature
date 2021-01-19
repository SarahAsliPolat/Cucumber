
  Feature: Suray Test
    Background:user is in the login page
      Given I logged in Suray
      And I set my page "SurayPage"
    @tabs
  Scenario: As an admin, I should see Basic, Details, Attendance and Files tabs on the upper right part of the form header
    Then the user validates that staff info tabs are on the staff page

      |Basic        |
      |Details      |
      |Attendance   |
      |Files        |
#RT 19
    @Columns
    Scenario:As a user, I need to see applicants as a table that consists of six columns
      When the user clicks to "applicants"
      Then  the user should see the  following columns

        |Location              |
        |Applied To Position   |
        |First Name & Last Name|
        |Internal              |
        |Interview Rates       |
        |Status                |
#RT-22
@Navigation_bar
     Scenario:As an admin I should be able to see a navigation bar for view more applicants
     When the user clicks to "applicants"
     Then the user validates pages corresponding with the navigation bar
