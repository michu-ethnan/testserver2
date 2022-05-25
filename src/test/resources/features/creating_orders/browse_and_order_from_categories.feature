Feature: Browse and order products from all categories

A customer should be able to browse and order products from all categories.


  Scenario: Order from Ogród
    Given that Alexa wants to browse and order products from Ogród
    And she ensures that Ogród contents are present
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed


  Scenario: Order from Kuchnia
    Given that Alexa wants to browse and order products from Kuchnia
    And she ensures that Kuchnia contents are present
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed


  Scenario: Order from ŁazienkaIgarderoba
    Given that Alexa wants to browse and order products from ŁazienkaIgarderoba
    And she ensures that ŁazienkaIgarderoba contents are present
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed


  Scenario: Order from Dekoracje
    Given that Alexa wants to browse and order products from Dekoracje
    And she ensures that Dekoracje contents are present
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed


  Scenario: Order from ŚwiatDziecka
    Given that Alexa wants to browse and order products from ŚwiatDziecka
    And she ensures that ŚwiatDziecka contents are present
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed


  Scenario: Order from Wyprzedaż
    Given that Alexa wants to browse and order products from Wyprzedaż
    And she ensures that Wyprzedaż contents are present
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed


  Scenario: Order from Nowości
    Given that Alexa wants to browse and order products from Nowości
    And she ensures that Nowości contents are present
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed


  Scenario: Order from Promocje
    Given that Alexa wants to browse and order products from Promocje category
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed


  Scenario: Order from Marki
    Given that Alexa wants to browse and order products from Marki page
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed


  Scenario: Order from Inspiracje
    Given that Alexa wants to browse and order products from Inspiracje list
    When she adds a product from category page
    And goes to checkout as a person
    And he attempts to pay using transfer
    Then the order should be placed




