Feature: Verify end to end flow dominos Order Multiple Nonveg pizza without login

  @RegressionTest @SmokeTest @DominosOrderNonveg @DominosUITest1
  Scenario: Verify end to end flow dominos Order Multiple nonveg pizza without login
    Given Verify user is on Dominos Home page
    When Click on the order online button
    Then Verify contact delivery page
    When Click on locate me button
    And Enter and Select Area as "Utsav Residency  "
    Then Verify navigated to Menu page
    When Add Multiple NonVeg Pizzas also note there price
    And Click on checkout button
    Then Verify navigated to cart page
    Then Verify Subtotal price on cart page 
    When Click on place order button
    And Fill all following details
    When Click on save to continue button
    Then Verify user is navigated payment page
    #Then Verify the SubTotal Price on Payment Page
    
    @RegressionTest @SmokeTest @DominosOrder @DominosUITest1
  Scenario: Verify end to end flow dominos Order Multiple veg pizza without login
    Given Verify user is on Dominos Home page
    When Click on the order online button
    Then Verify contact delivery page
    When Click on locate me button
    And Enter and Select Area as "Utsav Residency  "
    Then Verify navigated to Menu page
    When Add Multiple veg Pizzas also note there price
    And Click on checkout button
    Then Verify navigated to cart page
    Then Verify Subtotal price on cart page 
    When Click on place order button
    And Fill all following details
    When Click on save to continue button
    Then Verify user is navigated payment page
    #Then Verify the SubTotal Price on Payment Page
    
    
    
    
   