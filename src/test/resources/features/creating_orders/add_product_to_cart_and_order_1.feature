Feature: Add product to cart and order-1

  A customer should be able to add a product to cart and order it.

  Scenario: 1
    Given that Adam adds product to cart on account1
    When he attempts to order it as company using courier delivery
    And he attempts to pay using card
    And he attempts to use sandbox
    Then the order should be placed

  Scenario: 2
    Given that Adam adds product to cart on account1
    When he attempts to order it as person using courier delivery
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: 3
    Given that Adam adds product to cart on account1
    When he attempts to order it as company using courier delivery
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: 4
    Given that Adam adds product to cart on account1
    When he attempts to order it as company using courier delivery
    And he attempts to pay using pickup
    Then the order should be placed

  Scenario: 5
    Given that Adam adds product to cart on account1
    When he attempts to order it as company using courier delivery
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: 6
    Given that Adam adds product to cart on account1
    When he attempts to order it as person using courier delivery
    And he enters shipping address as company
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: 7
    Given that Adam adds product to cart on account1
    When he attempts to order it as person using courier delivery
    And he enters shipping address as person
    And he attempts to pay using transfer
    Then the order should be placed



