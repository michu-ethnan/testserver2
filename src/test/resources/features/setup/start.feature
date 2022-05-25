@Setup
Feature: Start

  Scenario: Setup website
    Given that Oscar has a product in cart
    When he tries to order it using courier delivery and pay using transfer
    Then he should see that order was placed