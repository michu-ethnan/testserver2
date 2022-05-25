Feature: Log in

  A customer should be able to log in.

  Scenario: Should be able to
    Given that Anne is on the login page
    When she fills in login form
    And she submits it
    And she goes to My Account
    Then she should be able to see "account header"