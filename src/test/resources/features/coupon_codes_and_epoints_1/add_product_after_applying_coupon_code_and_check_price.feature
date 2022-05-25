Feature: Add product after applying coupon code and check the price

  A customer should be able to add a different product after
  applying coupon code on checkout page and see the the discount
  price is higher.

  Scenario: Should be able to
    Given that Alex is on the checkout page
    When he applies a coupon code on checkout page
    And he sees the discount price on checkout page
    And he returns to the previous page and adds another product to cart
    When he goes to checkout page
    Then he should see that the discount price is higher

  Scenario: Should be able to
    Given that Alex is on the payment page as a person
    When he applies a coupon code on payment page
    And he sees the discount price on payment page
    And he returns to the previous page and adds another product to cart
    When he goes to the payment page
    Then he should see that the discount price is higher


