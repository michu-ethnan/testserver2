Feature: Order products logged in-2

  Logged in Customer should be able to order items with delivery as courier or
  in-store pickup if available. Also Customer should be able to order as
  a Company. All order payment options should be available to use.



  Scenario: 8

    Given that Oscar is logged in on account2
    When he orders "mug" using pickup delivery
    And he pays using card
    And he uses sandbox
    Then he should place order

  Scenario: 9

    Given that Oscar is logged in on account2
    When he orders "mug" using pickup delivery
    And he pays using transfer
    Then he should place order

  Scenario: 10

    Given that Oscar is logged in on account2
    When he orders "mug" using pickup delivery
    And he changes billing address
    And he pays using card
    And he uses sandbox
    Then he should place order

  Scenario: 11

    Given that Oscar is logged in on account2
    When he orders "mug" using pickup delivery
    And he changes billing address
    And he pays using transfer
    Then he should place order

  Scenario: 12

    Given that Oscar is logged in on account2
    When he orders "mug" using courier delivery
    And he changes billing address
    And he clicks the same shipping address checkbox
    And he pays using pickup
    Then he should place order

  Scenario: 13
    Given that Oscar is logged in on account2
    When he orders "mug" using courier delivery
    And he changes billing address
    And he clicks the same shipping address checkbox
    And he pays using transfer
    Then he should place order