Feature: Google search
  Scenario: user can create an account
    Given an open browser with https://qloapps.coderslab.pl/pl/logowanie?back=my-account
    When an email is entered in input field
    When entered personal information
    And zamykanie przeglądarki
