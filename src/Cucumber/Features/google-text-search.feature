Feature: Google search

  Scenario Outline: user can search any keyword
    Given an open browser with google.com
    When a keyword <keywords> is entered in input field
    Then the first one should contain <expectedResult>
    And close browser

    Examples:
    |keywords |expectedResult|
    |selenium |selenium      |
    |appium   |appium        |
    |cucumber |cucumber      |
