Feature: Log in with products in cart

  A customer should be able to log in with products in cart.

  Scenario: Should be able to

    Given that Peggy added a product to the cart
    When she attempts to log in
    And opens the minicart
    Then she should see that the same product is in the cart