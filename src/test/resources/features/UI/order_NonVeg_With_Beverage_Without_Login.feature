Feature: Verify end to end flow dominos Order Multiple Nonveg pizza without login

  @RegressionTest @SmokeTest @DominosOrderNonVegWithBeverage @DominosUITestRunner
  Scenario: Verify end to end flow dominos Order Multiple NonVeg pizza with Beverages without login
    Given Verify user is on Dominos Home page
    When Click on the order online button
    Then Verify contact delivery page
    When Click on locate me button
    And Enter and Select Area as "Utsav Residency  "
    Then Verify navigated to Menu page
    When Add multiple nonVeg pizzas with beverages also note there price consider "NonVeg_WithBeverage"
    And Click on checkout button
    Then Verify navigated to cart page
    Then Verify Subtotal price on cart page 
    When Click on place order button
    And Fill all following details
    When Click on save to continue button
    Then Verify user is navigated payment page
    #Then Verify the SubTotal Price on Payment Page
    