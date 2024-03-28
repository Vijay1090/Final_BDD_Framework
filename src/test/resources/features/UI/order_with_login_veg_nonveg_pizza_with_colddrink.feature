   Feature: verify order one veg and one nonveg pizza with colddrink with login
  I want to use this template for my feature file

  @tag1
  Scenario: order one veg and one nonveg pizza with colddrink with login
    Given user am on dashboard page
    When Click on the order online button
    Then Verify navigated to contact delivery page
    When Click on locate me button
    Then Verify navigated to home page
    When Click on My account link
    Then Verify navigated to Login page
    And Enter mobile number as "7757900210" and click on send otp button
    When Enter valid otp
    Then Verify successfully loggedin and navigate to homepage
    When Click on veg Pizza option
    And Choose a specific vegetarian pizza
    When Click on nonveg Pizza option
    And Choose a specific nonvegetarian pizza
    Then Verify chechout popup with selected pizza with amount
    When Click on checkout button
    Then Verify navigated to cart page
    And Click on Add botton on one coldrink option
    Then Verify product details on cart page
    And verify price details in cart page
    When Click on place order button
    Then user should navigate to payment page
    Then user should verify the order details and delivery address as per expected
    When payment mode as cash on delivery
    Then payment page should shows click to authonticate button
    When payment mode as credit card
    Then payment page should shows text as "Pay using Credit Card" with elements
    When payment mode selected as net banking
    Then payment page sholud shows text as "Pay using Net Banking"
