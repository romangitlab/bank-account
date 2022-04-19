Feature: For the REST API endpoint below write automated tests for positive and negative cases based of the next scenarios:

  @api
  Scenario: Bank account validation responds with 401 response code, if authentication token was not provided.
    Given the bank account validation request without a JWT token
    When sample request is sent to the server
    Then server responds with HTTP response code 401
    And response body contains "Authorization has been denied for this request." message.

  @api
  Scenario: Bank account validation returns isValid flag = true for valid IBANs
    Given the bank account validation request with a valid IBAN
    And valid authentication token
    When bank account validation request is sent to the server
    Then server responds with HTTP response code 200
    And response body contains isValid = true