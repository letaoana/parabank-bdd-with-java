@Login
Feature: User Login

  Scenario: Successful user login
    Given Registered user
    When The user attempts to login with correct credentials
    Then The site should login user successfully

  Scenario: Unsuccessful user login
    Given Registered user
    When The user attempts to login with incorrect password
    Then The site should not login user
