Feature: Order after registration at checkout

  A customer should be able to submit an order after registering at the checkout.

  Scenario: Should be able to

    Given that Cherry is a user who filled in checkout form "withoutEmailAddress"
    And who paid using transfer
    When she submits an order after registration using courier delivery
    And she makes a payment using transfer
    Then she should notice that the order was submitted