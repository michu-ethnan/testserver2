Feature: See cookies policy

  A customer should be able to see the cookies policy before accepting the cookies.

  Scenario: Should be able to

    Given that Colin is about to accept the cookies
    When he clicks see more button
    And he clicks cookies policy
    Then he should see the cookies policy