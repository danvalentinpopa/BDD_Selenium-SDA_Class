Feature: Test login functionality

  Scenario Outline: Login with valid credentials
    Given user is on login page
    When user enters valid <username> and <password>
    And clicks on login button
    Then use is navigated to the homepage
    Examples:
      | username        | password |
      | admin@admin.com | admin123 |


  Scenario Outline: Login with invalid credentials
    Given User is on login page
    When user enters invalid <username> and <password>
    And the submit button is pressed
    Then error message is displayed
    Examples:
      | username        | password |
      | admin@admin.com | admin12  |
      | adminadmin.com  | admin123 |
      |                 | admin123 |
      | admin@admin.com |          |