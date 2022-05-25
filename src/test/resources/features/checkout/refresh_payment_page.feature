Feature: Refresh payment page

  After a customer selects pickup point delivery type, proceeds to the payment page and refreshes it, then cash on
  delivery payment should not be visible.

  Scenario: Should be able to

    Given that Rebecca selects pickup delivery as person
    And she proceeds to the payment page to pay using transfer
    When she refreshes the page
    Then she should not see the cash on delivery option