Feature: Apply range filter

  A customer should be able to apply a range filter, entering a value with a comma or period.

  Scenario: Should be able to

    Given that Ralph opens a given category page
    When he enters a value with a comma
    Then he should see that the filter has been applied
    And the digits are separated with a period

  Scenario: Should be able to

    Given that Ralph opens a given category page
    When he enters a value with a period
    Then he should see that the filter has been applied
    And the digits are separated with a period