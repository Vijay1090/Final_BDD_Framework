Feature: Verify end to end flow dominos Order one veg pizza without login

  @RegressionTest @SmokeTest @DominosOrderOnlineTest10
  Scenario Outline: Verify End To End flow to order one veg pizza with one colddrink without login
    Given Verify user is on Dominos Home page
    When Click on the order online button
    Then Verify contact delivery page
    When Click on locate me button
    And Enter and Select Area as "Utsav Residency  "
    Then Verify navigated to Menu page
    When Click on '<Section>' Menu
    And Click on '<Product>' Add to Cart button under '<Section>' section
    And Make a note of one '<Product>' Price under '<Section>' section
    Then Verify '<Product>' and total quantity of '<Quantity>' added in the checkout section
    Then Verify total '<Quantity>' '<Product>' product price in the checkout section
    When Click on checkout button
    Then Verify navigated to cart page
    Then Verify '<Product>' is showing in the cart page
    When Add  '<CompleteMealProduct_Quantity>' product of  '<Complete_Your_Meal_product>'  from complete your meal section
    Then Verify '<Complete_Your_Meal_product>' is showing into selected product and note its price
    And Verify price details of total '<Quantity>' '<Product>' product in cart page
    When Click on place order button
    And Fill all following details
    When Click on save to continue button
    Then Verify user is navigated payment page
    Then Verify the order Sub Total
    

    Examples: 
      | Section  | Product      | Quantity | CompleteMealProduct_Quantity|Complete_Your_Meal_product |
      | Veg Pizza | Margherita  | 1        | 1                           |Garlic Breadsticks + Pepsi |                  