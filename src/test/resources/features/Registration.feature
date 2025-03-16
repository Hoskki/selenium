Feature: User Registration

  Scenario: Successful registration
    Given User is on registration page
    When User enters valid details
    Then Account should be created successfully

  Scenario: Creating an account with missing last name
    Given User is on registration page
    When User omits last name
    Then Error message should be displayed for missing last name

  Scenario: Creating an account with mismatching passwords
    Given User is on registration page
    When User enters mismatching passwords
    Then Error message should be displayed for password mismatch

  Scenario: Creating an account without accepting terms and conditions
    Given User is on registration page
    When User does not accept terms and conditions
    Then Error message should be displayed for terms not accepted