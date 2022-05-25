Feature: Order products logged in-3

  Logged in Customer should be able to order items with delivery as courier or
  in-store pickup if available. Also Customer should be able to order as
  a Company. All order payment options should be available to use.


  Scenario: 14

    Given that Oscar is logged in on account3
    When he orders "mug" using courier delivery
    And he changes billing address
    And he pays using card
    And he uses sandbox
    Then he should place order

  Scenario: 15

    Given that Oscar is logged in on account3
    When he orders "mug" using courier delivery
    And he changes billing address
    And he pays using transfer
    Then he should place order

  Scenario: 16

    Given that Oscar is logged in on account3
    When he orders "mug" using courier delivery
    And he changes billing address
    And he pays using pickup
    Then he should place order


  Scenario: 17

    Given that Oscar is logged in on account3
    When he orders "mug" using courier delivery
    And he changes billing address
    And he changes shipping address
    And he pays using transfer
    Then he should place order

  Scenario: 18

    Given that Oscar is logged in on account3
    When he orders "mug" using courier delivery
    And he changes billing address
    And he changes shipping address
    And he pays using pickup
    Then he should place order