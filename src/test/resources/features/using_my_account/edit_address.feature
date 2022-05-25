Feature: Edit address

  A customer should be able to edit addresses in the address book.

  Scenario: Should be able to

    Given that Edith happens to be in the address book
    When she clicks on some address in the address book
    And she edits input fields
    And she adds a newAddress
    And she saves it
    Then she should see that it was saved with popup saying "address saved"