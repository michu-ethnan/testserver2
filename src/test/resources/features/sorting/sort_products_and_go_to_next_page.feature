Feature: Sort products and go to next page

  Customer should be able to go to a next page after having sorted the products.

  Scenario: Should be able to

    Given that Pamela begins shopping on a category page
    When she sorts products
    And she proceeds to next page
    Then she should end up on the next page

    Scenario: Should be able to

      Given that Pamela tries to find a mug
      And she finds herself on the search results page
      When she sorts products
      And she proceeds to next page
      Then she should end up on the next page