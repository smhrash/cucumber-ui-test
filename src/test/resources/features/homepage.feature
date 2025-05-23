Feature: Selenium Homepage

  Scenario: Verify homepage title
    Given I open the Selenium homepage
    Then the page title should contain "Selenium"

  Scenario: Verify logo is displayed
    Given I open the Selenium homepage
    Then the Selenium logo should be visible