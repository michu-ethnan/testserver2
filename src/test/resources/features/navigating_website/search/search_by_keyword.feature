Feature: Search by keyword

  Business wants for customers to be able to search for
  products by a single keyword.
  The products shown should be adequate, most likely
  have a matching word in the name.

  Scenario: Should list items related to a specified keyword
    Given that Sasha wants to search for a product
    When he searches for a mug by keyword
    Then he should see that the first product contains keyword mug