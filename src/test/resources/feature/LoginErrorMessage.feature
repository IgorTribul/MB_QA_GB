Feature: Login

  Scenario: Login without email
    Given User is on Login page
    When User click login button
    Then User should see error message "Please enter a valid email address"
