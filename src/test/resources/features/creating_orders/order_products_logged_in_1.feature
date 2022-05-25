Feature: Order products logged in-1

  Logged in Customer should be able to order items with delivery as courier or
  in-store pickup if available. Also Customer should be able to order as
  a Company. All order payment options should be available to use.

  Scenario: 1

    Given that Oscar is logged in on account1
    When he orders "mug" using courier delivery
    And he clicks the same shipping address checkbox
    And he pays using card
    And he uses sandbox
    Then he should place order

  Scenario: 2
    Given that Oscar is logged in on account1
    When he orders "mug" using courier delivery
    And he clicks the same shipping address checkbox
    And he pays using transfer
    Then he should place order

  Scenario: 3

    Given that Oscar is logged in on account1
    When he orders "mug" using courier delivery
    And he clicks the same shipping address checkbox
    And he pays using pickup
    Then he should place order


  Scenario: 4
    Given that Oscar is logged in on account1
    When he orders "mug" using courier delivery
    And he pays using transfer
    Then he should place order

  Scenario: 5

    Given that Oscar is logged in on account1
    When he orders "mug" using courier delivery
    And he pays using pickup
    Then he should place order

  Scenario: 6

    Given that Oscar is logged in on account1
    When he orders "mug" using courier delivery
    And he changes shipping address
    And he pays using transfer
    Then he should place order




