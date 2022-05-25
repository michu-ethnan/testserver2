Feature: Register a new address

  A customer should be able to register a new address.

  Scenario: Should be able to

    Given that Reginald is on the register page
    When he submits the registration form
    And he clicks My Account button
    Then "account header" should appear