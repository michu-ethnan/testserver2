Feature: Return after clicking a configurable product

  A customer should be returned to a place from which they clicked on a configurable product.

  Scenario: Should be able to

    Given that Ruby is on the search results page looking for "configurable product"
    When she goes to the product page
    And she clicks the back button in a browser
    Then she should see that she is on the previous search results page

  Scenario: Should be able to

    Given that Ruby opened some category page
    When she goes to the product page from category page
    And she clicks the back button in a browser
    Then she should see that she is on the previous category page
