Feature: Login Management

  Scenario: Login with default browser (positive)
    Given I open the website with default browser
    When I login with username and password
    Then The login button should change to "Log out"
    Then The Sign in button should change to "Welcome" username


  Scenario Outline: Test2 - login with registered Username and Password on <Browser> (positive)
    Given I run the test on "<Browser>" browser
    When I login with username and password
    Then The login button should change to "Log out"
    Then The Sign in button should change to "Welcome" username

    Examples:
       | Browser  |
       | chrome   |
       | firefox  |




