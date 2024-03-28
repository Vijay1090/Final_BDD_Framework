Feature: Verify Upadate User Scenario

  @TestRun
  Scenario Outline: Scenario API : Delete : Delete Details to existing scenario
    Given I have endpoint as '<endpoint>'
    When I provided Content-Type as "application/json"
    When I provided in payloadbody firstname as '<firstFname>' and lastname as '<firstLname>'
    And I hit "create" booking "POST" request
    Then I should get status code as 200
    And I should get fistname as '<firstFname>'
    And I should get lastname as '<firstLname>'
    
    
    
    Given I have endpoint as '<endpoint2>'
    When I provided Content-Type as "application/json"
    When I have generated the token
    When I provided in payloadbody firstname as '<modifiedFname>' and lastname as '<modifiedLname>'
    And I hit "update" booking "PUT" request
    Then I should get status code as 200
    And I should booking user fistname as '<modifiedFname>'
    And I should booking user lastname as '<modifiedLname>'
    

    Given I have endpoint as '<endpoint2>'
    When I provided Content-Type as "application/json"
    When I have generated the token
    And I hit "remove" booking "DELETE" request
    Then I should get status code as 201
    
    
    Examples: 
      | endpoint | firstFname | firstLname | endpoint2     | modifiedFname | modifiedLname |
      | /booking | Vijay      | Yaligar    | /booking/{id} | Sanjay        | Horke         |