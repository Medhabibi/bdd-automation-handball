Feature: Login functionality by user role
  As a registered user of Handball Management
  I want to log in according to my role
  So that I can access the correct dashboard

  Background:
    Given the user navigates to the home page

  @SmokeTest @Login
  Scenario Outline: Successful and failed login attempts for each role
    When the user selects the role "<role>" from the menu
    And the user enters "<username>" and "<password>"
    And clicks on the login button
    Then the result should be "<expectedResult>"

    Examples:
      | role               | username            | password     | expectedResult              |
      | Joueurs            | admin@gmail.com     | Azert123@    | success_redirect_dashboard  |
      | Entraîneurs        | admin@gmail.com     | Azert123@    | success_redirect_dashboard  |
      | Préparateurs Physiques | admin@gmail.com | Azert123@    | success_redirect_dashboard  |
      | Managers           | admin@gmail.com     | Azert123@    | success_redirect_dashboard  |
      | Joueurs            | admin@gmail.com     | wrongPass    | error_invalid_credentials   |
      | Entraîneurs        |                     |              | error_fields_required       |
