Feature: verify order multiple nonveg pizza without login
  I want to use this template for my feature file

  @tag1
  Scenario: verify user is able to order Multiple nonveg pizza without login
    Given user is on dashboard page
    When user click on the order online button
    Then user should navigate to contact delivery page
    When user click on locate me button
    Then user should navigate to home page and bydefault on recommended option
    When user click on veg Pizza option 
    And user choose a specific nonvegetarian pizza "Chicken Dominator" with large size 
    And user should get chechout popup with selected pizza with amount
    And user want to order "Chicken Dominator" quantity of 5 and Amount should reflact according to that number of orders
    When user click on checkout button
    Then user should navigate to cart page and it includes all buying product details 
    Then verify sub amount and grand total amount which includes taxes
    When user click on place order button
    And user fills all following details and click on save to continue button
    |firstname|lastname|mobilenumber|emailaddress        |address|houseno|
    |Vijay    |yaligar |7757900210  |vijayy8981@gmail.com|pune   |24     |
    
   Then user should navigate to payment page 
   And user should verify the order details and delivery address as per expected
   When payment mode as cash on delivery
   Then payment page should shows click to authonticate button
   When payment mode as credit card
   Then payment page should shows text as "Pay using Credit Card" with elements
   When payment mode selected as net banking
   Then payment page sholud shows text as "Pay using Net Banking"
   
   
    
