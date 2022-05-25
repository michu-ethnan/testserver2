Feature: Enter coupon code on the payment page

  A customer should be able to enter a coupon code on the payment page.

  Scenario: Should be able to

    Given that Patrick happens to be on the payment page
    And he fills in billing data as person
    When he enters a coupon code
    Then he should see that the code is added

  Scenario: Should be able to

    Given that Patrick happens to be on the payment page
    And he fills in billing data as person
    When he enters a coupon code
    And he refreshes the payment page
    Then he should see that the code is added