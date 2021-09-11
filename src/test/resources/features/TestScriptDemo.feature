@TestScriptDemo
Feature:Products to cart
  Background:
    Given I am on the test script demo page

  Scenario: Add Lowest price item from wish list to cart
    Given I add 4 different products to my wish list
    When  I view my wishlist table
    Then  I find total 4 selected items in my Wishlist
    When  I search for lowest price product
    And   I am able to add the lowest price item to my cart
    Then  I am able to verify the item in my cart
