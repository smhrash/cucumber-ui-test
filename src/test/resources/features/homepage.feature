Feature: Selenium Homepage
  # This feature file contains tests to verify that the Selenium homepage loads correctly
  # and displays expected UI elements like the title and the logo.

  Background: Navigate to the Selenium homepage
    # The Background section is executed before each Scenario.
    # It ensures that the user starts from the Selenium homepage for every test.
    Given I open the Selenium homepage

  Scenario: Verify homepage title
    Then the page title should contain "Selenium"

  Scenario: Verify logo is displayed
    Then the Selenium logo should be visible

  @smoke
  Scenario: Verify documentation link works properly.
    When I click on the documentation link
    And I click on the link About this documentation
    Then I should see the title text "About this documentation"