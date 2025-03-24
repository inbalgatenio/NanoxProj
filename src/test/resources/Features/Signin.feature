Feature: Sign in Management


Scenario: Test4 - Sign up rejects malicious script in username(negative)

    Given I open the website with default browser
    Given The "<script>alert('XSS attack');</script>" user doesn't exist in the system
    When I sign in with username "<script>alert('XSS attack');</script>" and password "112233"
    Then I don't get "Sign up successful" message
    Then I get error message popup contains "Error" message
    Then The "<script>alert('XSS attack');</script>" user doesn't exist in the system