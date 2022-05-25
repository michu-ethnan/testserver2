Feature: Adding a new address to the address book

  A customer should be able to add a new address to the address book

  Scenario: Should be able to

    Given that Adele is logged into her account
    When she adds newAddress to the address book
    Then she should see a popup saying "address saved"
