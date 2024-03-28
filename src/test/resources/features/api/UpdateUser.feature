Feature: Verify Upadate User Scenario

  @TestRun
  Scenario Outline: Datatable Example
    Given I have endpoint as "/booking"
    When I provided Content-Type as "application/json"
    When User enters valid credentials
      | Shiva | nand    | add1 | city1 |
      | Vijay | Yaligar | add2 | city2 |
      | Sri   | B       | add3 | city3 |

  @TestRun123222
  Scenario Outline: Json schema Validator
    Given I have endpoint as "/booking"
    When I provided Content-Type as "application/json"
    When I provided in payloadbody firstname as '<originalFname>' and lastname as '<originalLname>'
    And I hit "create" booking "POST" request
    Then I should get status code as 200
    And I should get fistname as '<originalFname>'
    And I should get lastname as '<originalLname>'
    Then Validate Json Schema "createBooking"

    Examples: 
      | originalFname | originalLname |
      | Vijay         | Yaligar       |

  #https://qaautomation.expert/2024/01/20/datatables-in-cucumber
  @TestRun
  Scenario Outline: Verity New update User Functionality
    Given I have endpoint as '<endpoint>'
    When I provided Content-Type as "application/json"
    When I provided in payloadbody firstname as '<originalFname>' and lastname as '<originalLname>'
    And I hit "create" booking "POST" request
    Then I should get status code as 200
    And I should get fistname as '<originalFname>'
    And I should get lastname as '<originalLname>'
    Given I have endpoint as '<endpoint2>'
    When I provided Content-Type as "application/json"
    When I have generated the token
    When I provided in payloadbody firstname as '<modifiedFname>' and lastname as '<modifiedLname>'
    And I hit "update" booking "PUT" request
    Then I should get status code as 200
    And I should booking user fistname as '<modifiedFname>'
    And I should booking user lastname as '<modifiedLname>'

    Examples: 
      | endpoint | originalFname | originalLname | endpoint2     | modifiedFname | modifiedLname |
      | /booking | Vijay         | Yaligar       | /booking/{id} | Sanjay        | Horke         |
