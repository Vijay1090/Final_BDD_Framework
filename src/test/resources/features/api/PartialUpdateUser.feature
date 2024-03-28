Feature: Verify Upadate User Scenario

  @TestRun
  Scenario Outline: Verity partial update User Functionality
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
    And I hit "partialupdate" booking "PATCH" request
    Then I should get status code as 200
    And I should get booking modifiedFname as '<modifiedFname>'
    And I should booking user modifiedLname as '<modifiedLname>'
   
    
    
   

    Examples: 
     | endpoint | originalFname | originalLname | endpoint2     | modifiedFname | modifiedLname |
     | /booking | Vijay         | Yaligar       | /booking/{id} | Sagar         | Madure        |                
      
      
 