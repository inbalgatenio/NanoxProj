Feature: Contact Management

  Scenario: Test3 - Validate Contact Email is not empty in Contact form (Negative)

    Given I login with username and password
    When I send message in Contact Form without to fill the email address field
    Then The Send message button should not be Clickable and enabled
    Then Verify message wasn't sent