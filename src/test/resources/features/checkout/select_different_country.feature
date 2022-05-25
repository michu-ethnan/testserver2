Feature: Select different country

  A customer should be able to select a country other than Poland at checkout and proceed to the next step. It should
  be possible in the case of a billing address as well as a delivery address.

  Scenario: Should be able to

    Given that Serena wants to select a billing country
    When she chooses Portugal as a person
    And clicks the payment page button
    Then she should be on the payment page

  Scenario: Should be able to

    Given that Serena wants to select a billing country
    When she chooses Ireland as a person
    And clicks the payment page button
    Then she should be on the payment page