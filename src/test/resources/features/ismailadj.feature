
Feature: A description

  Background: User is logged in
    Given I am on the "LoginPage" as ismail
    When I wait for "loadLogin" to be "visible" as ismail
    Then I click on "loadLogin" as ismail
    Then I wait for "1000" milliseconds as ismail
    Then I enter "admin@staging-buffsci.org" in "emailSection" as ismail
    Then I wait for "1000" milliseconds as ismail
    Then I enter "admin123test" in "passwordSection" as ismail
    Then I wait for "loginButton" to be "clickable" as ismail
    Then I click on "loginButton" as ismail
    Then I wait for "newHireButton" to be "visible" as ismail
    Then I am on the "IsmailPage" as ismail


  Scenario: A scenario
    Then I click on "newHireButton" as ismail
    Then I Validate the newhire list has these below as ismail

      |Salutation:|
      |First Name:|
      |Middle Name:|
      |Last Name:|
      |Vacant Positions:|
      |Personal Email:|
      |Cell Phone:|



  Scenario: the second scenario
    Then I click on "jobTap" as ismail
    Then I Validate the dropDown job list down list has these below as ismail

  |-- Job --|
  |Custodian|
  |CFO|
  |Administrative Staff|
  |IT Support|
   |          |
  |IT Specialist|
  |Teacher - SPED- (K-4)|
  |Teacher - Reading Specialist (K-4)|
  |Dean of Students|
  |Teacher - Math - (5-8)|
  |Teacher - Elementary|
  |PSR Teacher (5-8)|
  |Security/ Hall Monitor|
  |Support Teacher K-4|
  |Teacher - ELA - (9-12)|
  |Teacher - Specialty (K-4)|
  |Teacher - ENL|
  |Director of Special Projects|
  |Receptionist|
  |Substitute Teachers|
  |Director of Guidance|
  |Teacher - Social - (9-12)|
  |College Guidance|
  |Teacher Aide (K-4)|
 | Cleaning Crew|
 | Teacher - Comp/Tech (9-12)|
 | Athletic Coach|
 | Teacher - Sci - (9-12)|
  |Teacher - SPED - (5-8)|
  | Teacher - Art- (5-8)|
  | Teacher - ELA - (5-8)|
  | Teacher - Math Specialist (K-4)|
  |Teacher - Math - (9-12)|
  |Support Teacher 5-8|
  |Nurse|
  |Data Coordinator|
  |HR Coordinator|
  | Operation / Business Manager|
  | Principal|
  |Librarian (K-4)|
  |Teacher - Art -(9-12)|
  |Teacher - Spanish|
  |Social Workers (9-12)|
  | Teacher - Social (5-8)|
  | PSR Teacher (K-4)|
  |Teacher - Comp/Tech (K-8)|
  |Teacher - Music -(5-8)|
  |Teacher - PE (9-12)|
  | Executive Director|
  | Social Worker (K-4)|
  |Teacher - PE (K-4)|
  | Teacher - Sci - (5-8)|
  |Teacher - PE (5-8)|
  |Director of Curr Ins|
  |Teacher - SPED - (9-12)|
  |Social Worker (5-8)|
  | SPED Coordinator|
  | PSR Teacher (9-12)|
  |Teacher - Turkish|


    Scenario: checking the applications drop down
      Then I click on "applicationsTap" as ismail
      Then I wait for "applicationsText" to be "visible" as ismail
      Then I click on "selectPositionFiled" as ismail
     Then  make sure the selectposition function  is working properly


  @ismail
    # https://softinnovator.atlassian.net/browse/RT-24
  Scenario: check the new position steps
    Then I click on "position" as ismail
    Then I click on "addNewButton" as ismail
    Then I wait for "1000" milliseconds as ismail
    Then i validate the "New Position" page pups up
    Then i validate all the text on the position page
    |Title|
 | Assigned Staff|
  |Position Type|
  |Reports To   |
  |Location|
  |Supervisor|
  |Posted|


