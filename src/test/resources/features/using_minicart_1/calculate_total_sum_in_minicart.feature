Feature: Calculate total sum in minicart

  The total sum in minicart should equal a number of products multiplied by their price. A customer should be able to
  see that the price is calculated correctly.

  Scenario: Should be able to

    Given that Cassie is on the product page
    And she sees a product price
    When the total sum in minicart is calculated
    Then she should see that it is correct