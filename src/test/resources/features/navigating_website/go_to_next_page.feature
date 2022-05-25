Feature: Go to next page

  Customer should be able to go to a next page category page.

  Scenario: Should be able to

    Given that Gordon opens a category page
    When he clicks a pagination arrow
    Then he should go to that page

  Scenario: Should be able to

    Given that Gordon is on a collection page
    When he clicks a pagination arrow
    Then he should go to that page

  Scenario: Should be able to

    Given that Gordon searches for a mug
    And he sees the search results page
    When he clicks a pagination arrow
    Then he should go to that page


