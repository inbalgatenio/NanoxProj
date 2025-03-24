Feature: Cart Management

  Scenario: Test5 - Place Order without products in the Cart (negative)

    Given I login with username and password
    Given There are no products in the cart
    When Click to Place Order
    Then Verify Place order page is not triggered
    Then The Place Order button should be disabled
    Then The Place Order button should not be clickable

