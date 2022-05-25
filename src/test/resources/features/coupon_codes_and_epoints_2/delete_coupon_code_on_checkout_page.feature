Feature: Delete coupon code

  A customer should be able to delete the applied coupon code.

  Scenario: Should be able to

    Given that Delilah applied a coupon code
    When she removes it
    Then she should see that the code is not displayed

  Scenario: Should be able to

    Given that Delilah applied a coupon code
    And she attempts to proceed to the payment page as person
    And she attempts to return to the previous page
    When she removes it
    Then she should see that the code is not displayed