Feature: See an order in My Account

  A customer should be able to see an order in My Account

  Scenario: Should be able to

    Given that Orlando is in My Account
    When he goes to My Orders tab
    And he clicks on a selected order
    Then he should see the details of this order