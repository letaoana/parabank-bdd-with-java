@Withdrawal
Feature: Account Withdraw
  Scenario: Account with positive balance
    Given Account with positive balance
    When The user request a withdrawal for a lesser amount
    Then The withdrawal should be successful

  Scenario: Account with negative balance
    Given Account with negative balance
    When The user request a withdrawal for a greater amount
    Then The withdrawal should not be successful