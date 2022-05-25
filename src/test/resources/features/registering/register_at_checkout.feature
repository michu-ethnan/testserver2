Feature: Register at checkout

  A customer should be able to register at checkout.

  Scenario: Should be able to

    Given that Regina is at checkout
    And she attempts to fill in the checkout form "withoutEmailAddress"
    And she pays by transfer
    When she submits an order
    Then she should notice that "account header" is visible
