Feature: Sort products by price, lowest first

  A customer should be able to sort products with price in an ascending order.

  Scenario: Should be able to sort products with price by ascending order, category page
    Given that Emilia opened the first category page
    When she applies a price filter with an ascending order
    And she sees the value of the first price
    And she sees the value of the second price
    Then she should see that the sort is correct

  Scenario: Should be able to sort products with price by ascending order, search page
    Given that Emilia attempts to search for a "mug"
    When she applies a price filter with ascending order after search
    And she sees the value of the first price
    And she sees the value of the second price
    Then she should see that the sort is correct
