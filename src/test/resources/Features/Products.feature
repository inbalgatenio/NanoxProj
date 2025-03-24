Feature: Products Management

  Scenario: Test1 - Place a new laptop order
    Given I open the website with default browser
    When I login with username and password
    Given There are no products in the cart
    When I open Laptops list
    When I add Laptop to the cart
    When I place the order
    Then Verify Order is created successfully
    Then There are no products in the cart
