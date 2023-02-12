@Deposit
  Feature: Account Deposit
    Scenario:
      Given Account with balance
      When The user makes a deposit with a positive amount
      Then The deposit should be successful

    Scenario:
      Given Account with balance
      When The user makes a deposit with a negative amount
      Then The deposit should not be successful