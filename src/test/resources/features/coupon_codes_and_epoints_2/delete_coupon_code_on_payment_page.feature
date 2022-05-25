Feature: Delete coupon code on the payment page

  A customer should be able to delete a coupon code on the payment page.

  Scenario: Should be able to

    Given that Dennis attempts to apply a coupon code as person
    When he attempts to delete it
    Then he should see that the code was deleted