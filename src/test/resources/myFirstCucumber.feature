Feature: Login
  Scenario: LoginFacebook

    Given i have access to facebook
    When i type the email: upb@upb.com
    And i type the password: 12345
    And i click on login button
    Then i should be logged