@Sales
Feature: Sales feature
  User want to make purchase on sauce demo website

  Scenario Outline: User make a purchase Sauce Labs Onesie item on Sauce Demo website
#    //Login Page
    Given User already on website sauce demo
    When User input"<userName>" as userName and input"<password>" as password

#    //Sales Page
    Then User already on sales page
    When User sort product list by "Name (Z to A)"
    Then User pick up items from the checkout list "Test.allTheThings() T-Shirt (Red)" and "Sauce Labs Onesie" and to cart list
    When User click "Sauce Labs Onesie" to show detailed product information
    Then User click shopping cart link

#    //Cart Page
    And User already on cart page
    When User remove item from the cart page "Test.allTheThings() T-Shirt (Red)"
    Then User verify that the quantity of the item is the same as click on the sales page
    And User verify that the price of the item is the same as listed on the sales page
    When User click checkout button

#    // Checkout Page Information
    And User already on checkout page
    When User inputs "<firstName>" as firstName, inputs "<lastName>" as lastName, inputs "<postalCode>" as postalCode
    Then User click continue button

#    // Checkout Page Overview
    And User already on checkout overview page
    When User verify the total price of item is "8.63"
    Then User click finish button
    And User already on checkout: complete! page

#    // Logout Step
    When User click Back home button
    Then User back to sales page
    When User click burger button
    Then User click logout button
    And User already on website sauce demo

    Examples:
      | userName      | password     | firstName | lastName | postalCode |
      | standard_user | secret_sauce | Sandy     | Saputra  | 23443154   |

