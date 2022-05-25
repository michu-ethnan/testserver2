Feature: Add product to cart and order-3

  A customer should be able to add a product to cart and order it.

  Scenario: 15
    Given that Adam adds product to cart on account3
    When he attempts to order it as company using pickup delivery
    And he attempts to pay using card
    And he attempts to use sandbox
    Then the order should be placed

  Scenario: 16
    Given that Adam adds product to cart on account3
    When he attempts to order it as company using pickup delivery
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: 17
    Given that Adam adds product to cart on account3
    When he attempts to order it as company using courier delivery
    And he enters shipping address as company
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: 18
    Given that Adam adds product to cart on account3
    When he attempts to order it as company using courier delivery
    And he enters shipping address as company
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: 19
    Given that Adam adds product to cart on account3
    When he attempts to order it as company using courier delivery
    And he enters shipping address as company
    And he attempts to pay using pickup
    Then the order should be placed

  Scenario: 20
    Given that Adam adds product to cart on account3
    When he attempts to order it as company using courier delivery
    And he enters shipping address as person
    And he attempts to pay using transfer
    Then the order should be placed

  Scenario: 21
    Given that Adam adds product to cart on account3
    When he attempts to order it as company using courier delivery
    And he enters shipping address as person
    And he attempts to pay using pickup
    Then the order should be placed