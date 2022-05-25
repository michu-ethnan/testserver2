Feature: Order after registration

  A customer should be able to place an order after registration.

  Scenario: Should be able to

    Given that Renee is a registered user
    When she places an order "withoutEmailAddress"
    And she pays using transfer
    Then she should see that the order was submitted