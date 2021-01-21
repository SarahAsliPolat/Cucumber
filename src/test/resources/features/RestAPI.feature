Feature: Rest API

  @Rest @1
  Scenario: get staff info by staff ID

    Given I store parameters in userId map
      | staff_id| 67986|

    Given I verify getService for "SDMA" has status 200 on "getStaffInfo" with header params "", path params "userId", query params "", form params "", auth "", body ""

    Then I verify rest response data for SDMA
      | room       | 744           |
      | full_name  | Douglas Fox   |
      | location   | High School   |
      | job        | Teacher - ENL |

   @Rest @2
  Scenario: get self info

    Given I verify getService for "SDMA" has status 200 on "getSelfInfo" with header params "", path params "", query params "", form params "", auth "", body ""
    Then I verify rest response data for SDMA
      | room       |300                 |
      | full_name  |Betty C. Jackson    |
      | location   | District Office    |
      | job        | Executive Director |

   @Rest @3
  Scenario: get staff list 1

    Given I verify getService for "SDMA" has status 200 on "getStaffList" with header params "", path params "", query params "", form params "", auth "", body ""

    Then I verify rest response data for SDMA
      |staff_list.id[0]          |67986         |
      | staff_list.full_name[0]  | Douglas Fox  |
      | staff_list.location[0]   | High School  |
      | staff_list.job[0]        | Teacher - ENL|

   @Rest @4
  Scenario: get staff list 2

    Given I verify getService for "SDMA" has status 200 on "getStaffList" with header params "", path params "", query params "", form params "", auth "", body ""

    Then I verify rest response data contains for "SDMA"
      |{"id":67986,"full_name":"Douglas Fox","location":"High School","job":"Teacher - ENL"}          |
      |{"id":78213,"full_name":"Amanda Daly","location":"High School","job":"Teacher - ELA - (9-12)"} |


   @Rest @5
  Scenario: Post new Staff

    Given I store parameters in postBody map
      |email       |mjackson32@buffaloscience.org |
      |position_id |123                         |
      |salutation  |Mr.                         |
      |first_name  |Michael                     |
      |middle_name |Joseph                      |
      |last_name   |Jackson                     |
      |cell_phone  |7754483302                  |

    Given I verify postService for "postNewStaff" has status 200 on "postNew" with header params "", path params "", query params "", form params "postBody", auth "", body ""
    Then I verify "postNewStaff" postMethod created data with "postBody"
    Then I delete "postNewStaff" staff
