@flow
Feature: Flows Feature

  @registration
  Scenario: Registration Scenario
    Given user navigates to the homepage
    When user clicks on the sign in button
    And user adds 'user1' email to create a new account
    Then user can click on the create account button
    When user fills the registration form with the data of 'user1'
    Then verify that the registration is successfully completed

  @login
  Scenario: Login Scenario
    Given user navigates to the homepage
    When user clicks on the sign in button
    And user fills the login form with the data of 'user1'
    Then verify that the login is successfully completed

  @cart
  Scenario: Cart Checkout Scenario
    Given user navigates to the homepage
    When user clicks on the sign in button
    And user fills the login form with the data of 'user1'
    Then verify that the login is successfully completed
    When user clicks on 'T-Shirts' menu
    And selects the item named 'Faded Short Sleeve T-shirts'
    Then user can add the selected item to his cart
    And proceed to the checkout page
    When user proceeds to the Address page
    And proceeds to the Shipping page
    And accepts the terms and conditions
    Then user can proceed to the Payment page
    When user chooses to pay by bank wire
    And confirms the order
    Then the order confirmation message 'Your order on My Store is complete.' should be visible