Feature: For the web portal write UI automated tests for positive and negative cases based of the next scenarios:

  @ui
  Scenario: Customer sees message that e-mail is sent
    Given customer is in a login page
    When customer selects create account link
    And customer inserts "test@gmail.com" e-mail address
    Then customer is redirected to the '/authentication/confirmationemailsent' page
    And "You've got mail" message is shown

  @ui
  Scenario: Customer sees error message when invalid information inserted
    Given customer is in a login page
    When customer selects login with 'e-mail and password' option
    And customer inserts invalid "test@gmail" email address
    Then error validation message is shown

  @ui
  Scenario: Customer sees error message when information of non-existing customer is inserted
    Given customer is in a login page
    When customer selects login with 'e-mail and password' option
    And customer inserts "test@gmail.com" email address and "1234" password
    Then customer is redirected to the '?type=emailandpassword&error=20' page
    And error notification summary message is shown