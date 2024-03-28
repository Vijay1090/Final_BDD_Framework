Feature: verify order single nonveg pizza with login
  I want to use this template for my feature file

  @tag1
  Scenario: order one nonveg pizza with login
    Given user am on dashboard page
    When Click on the order online button
    Then Verify navigated to contact delivery page
    When Click on locate me button
    Then Verify navigated to home page
    When Click on My account link 
    Then Verify navigated to Login page
    And  Enter mobile number as "7757900210" and click on send otp button
    When Enter valid otp
    Then Verify successfully loggedin and navigate to homepage 
     When Click on nonveg Pizza option
    And Choose a specific nonvegetarian pizza 
    Then Verify chechout popup with selected pizza with amount  
     When Click on checkout button
    Then Verify navigated to cart page
    Then Verify product details on cart page
    Then verify price details in cart page
    When Click on place order button
   Then Verify navigated payment page
    Then Verify the order details and delivery address
    When Select payment mode as cash on delivery
    Then Verify click_authonticate_button displayed
    When Select payment mode as credit card
    Then Verify "Pay using Credit Card" displayed
    When Select payment mode selected as net banking
    Then Verify "Pay using Net Banking" displayd