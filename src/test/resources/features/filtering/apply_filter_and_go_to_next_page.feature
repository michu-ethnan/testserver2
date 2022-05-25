Feature: Apply filter and go to next page

  Customer should be able to go to a next page after applying a filter.

  Scenario: Should be able to

    Given that Philip arrives to a category page
    When he applies some filter
    And he goes to next page
    Then he should find himself on the next page

  Scenario: Should be able to

    Given that Philip attempts to find a mug
    And he arrives to the search results page
    When he applies some filter
    And he goes to next page
    Then he should find himself on the next page