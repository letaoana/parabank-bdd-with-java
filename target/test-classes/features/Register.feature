@CustomerRegister
Feature: Customer Register

  Scenario: Successful customer registration
    Given New customer with valid data
    When The customer submits complete Register form
    Then The customer should be registered successfully

  Scenario Outline: Unsuccessful customer registration, display error message
    Given New customer with invalid data
    When The customer submits Register form with a "<fieldId>" field not set
    Then "<fieldId>" field error should be displayed
    Examples:
      | fieldId                 |
      |customer.username        |
      |customer.lastName        |
      |customer.address.street  |
      |customer.address.city    |
      |customer.address.state   |
      |customer.address.zipCode |
      |customer.ssn             |
      |customer.username        |
      |customer.password        |
      |repeatedPassword         |