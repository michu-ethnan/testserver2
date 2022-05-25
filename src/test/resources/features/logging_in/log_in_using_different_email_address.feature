Feature: Log in using different email address

  A customer should be able to log in, log out and log in using different email
  address. Then, the customer should see that their personal data are different.

  Scenario: Should be able to

    Given that Logan decided to log in
    And he logs out
    When he logs in using "differentEmail"
    Then he should see that his personal data are different