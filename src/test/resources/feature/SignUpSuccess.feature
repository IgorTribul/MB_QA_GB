Feature: SignUpSuccess

  Scenario: Sign Up with valid email
    Given User is on Sign Up page
    When User send valid email address
    And User send valid password
    And User confirm valid password
    And User click sign up button
    Then User should see message "You successfully signed up!"
