@Sales
Feature: Sales feature

  Scenario: User make a purchase Sauce Labs Onesie item on Sauce Demo website
#    //Login Page
    Given User already on website sauce demo
    When User input"standard_user" as userName and input"secret_sauce" as password

#    //Sales Page
    Then User already on sales page
    When User sort product list by "Name (Z to A)"
    Then User pick up items from the checkout list "Test.allTheThings() T-Shirt (Red)" and "Sauce Labs Onesie" and to cart list
    When User click "Sauce Labs Onesie" to show detailed product information
    Then User click shopping_cart_link

#    //Cart Page
    And User already on cart page
    When User Remove item from the cart page "Test.allTheThings() T-Shirt (Red)"
    Then User verify that the quantity of the item is the same as click on the sales page
    And User verify that the price of the item is the same as listed on the sales page
    Then User click checkout button

#    // Checkout Page Information
    And User already on checkout page
    When User inputs "Sandy" as firstName, inputs "Saputra" as lastName, inputs "432352" as postalCode
    Then User click continue button

#    // Checkout Page Overview
    And User already on checkout overview page
    When User verifies the total price of item is "8.63"
    Then User click finish button
    And User already on checkout: complete! page

#    // Logout Step
    When User click Back home button
    Then User back to sales page
    When User click burger button
    Then User click logout button
    And User already on website sauce demo