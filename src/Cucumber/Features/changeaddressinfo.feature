Feature: Change user information after login

  Scenario Outline: Change user address page
    Given User is logged in the address page
    When User goes to AddressPage
    And User adds and saves new <address>, <city> and <postcode>
    Then User sees "Address successfully added!"
    Examples:
      | address | city     | postcode |
      | Parkowa | Wroclaw  | 51-616   |
      | Lesna   | Warszawa | 32-202   |
      | Prosta  | Plock    | 88-733   |