Feature: Delete a coupon code on the payment page logged in

  A logged in customer should be able to delete a coupon code on the payment page.

  Scenario: Should be able to

    Given that Desmond is a logged in person
    When he adds a coupon code on the payment page as person
    And he removes it
    Then he should see that it was removed