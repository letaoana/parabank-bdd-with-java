@Balance
  Feature: Account Balance

    Scenario: Account balance is positive
      Given Account with positive balance
      When The user checks the balance
      Then The balance should be displayed

    Scenario: Account balance is negative
      Given Account with negative balance
      When The user checks the balance
      Then The balance should be displayed
