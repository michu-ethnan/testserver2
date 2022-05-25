Feature: Apply range filter, refresh and go to next page

  A customer should be able to apply a range filter, refresh and go to next page.

  Scenario: Should be able to

    Given that April is on a given category page
    When she selects a range filter
    And she hits the refresh button
    And she goes to the next page
    Then she should see that the filter is still applied
