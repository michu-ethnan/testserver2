Feature: Sort products by price, highest first

  A customer should be able to sort products with price in a descending order.

  Scenario: Should be able to sort products with price by descending order, category page
    Given that Maja opens the first category page
    When she applies a price filter with a descending order
    And she sees the first price
    And she sees the second price
    Then she should ensure that the sort is correct

  Scenario: Should be able to sort products with price by descending order, search page
    Given that Maja attempts to look fo a "mug"
    When she applies a price filter with a descending order after search
    And she sees the first price
    And she sees the second price
    Then she should ensure that the sort is correct
