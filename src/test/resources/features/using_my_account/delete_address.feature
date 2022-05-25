Feature: Deleting an address

  Customer should be able to delete an address.

  Scenario: Should be able to

    Given that Dennis is in the address book
    When he clicks on a trash icon
    And he confirms that he wants to remove the address
    Then he should see a popup with "address deleted" inscription