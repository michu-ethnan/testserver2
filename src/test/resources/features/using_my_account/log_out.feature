Feature: Logging out

  Customer should be able to log out.

  Scenario: Should be able to

    Given that Lorna is logged into My Account
    When she attempts to log out
    Then she should see login button