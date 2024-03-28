Feature: verify end to end flow of Functionality

  Scenario: verify end to end flow of functions
    Given I am on Homepage of IGP
    When I click  on user profile tap
    Then I should redirected to loginpage
    When I enters emailid and password
    And Click on login button
    Then I should loggedin Successfully
    When I search for " flower" in search text field
    Then I navigate to flower section
    And I select one product "Opulent Orchids Bouquet"
    Then I should navigate to product page
    When I enters invalid pincode
    Then I should get error message as "We currently do not deliver this product at this location."
    When I enters valid pincode
    Then I Should get text as "Available"
    When I select Date in calender
    When I select the delivary Type
    When I select Time Slot in dropdown
    When I click on add to cart button
    Then overlay should appear which contain addons and button have label "CONTINUE WITHOUT ADDON"
    When I click on X Button
    And I click on Proceed to cart Button
    Then I should Navigate to shopping cart page
    Then Verify the content
    When I click on proceed to checkout Button
    Then I should navigate to checkout page
    When I fills all delivery details and click on save button
      | firstnameLastName | addressline    | mobilenumber | alternatenumber | emailid              |
      | Vijay Yaligar     | Mukhargi Nagar |   7757900210 |      9096636040 | vijayy8981@gmail.com |
    Then I should Navigate to Header order summery section and verify that section
    When I click on proceed to payment Button
    Then I should Navigate to payment tab
    Then payment tab should contain user delivery details on this page with total product Amount
    When I select payment option as Paytm and click on make Payment Button
