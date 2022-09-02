Feature: Login Sauce Demo
  Background: User login into Sauce Demo page
    Given Im in Sauce Demo web page

  @LoginWithValidCredentials
  Scenario: Login into Sauce Demo page with valid credentials
    Given I set the user name field with "standard_user"
    And I set the password field with "secret_sauce"
    When I click on login button
    Then The home page should be displayed

  @LogoutTest
  Scenario: Check logout button is working
    Given I set the user name field with "standard_user"
    And I set the password field with "secret_sauce"
    And I click on login button
    And I click on burger menu button
    When I click on logout button
    Then The login page should be displayed

   @CartIncremented
   Scenario: Check if the cart's number is incremented when a product is added
     Given I set the user name field with "standard_user"
     And I set the password field with "secret_sauce"
     And I click on login button
     When I add a product to the cart
     Then The cart product's number increments

   @VerifyLowToHighFilter
   Scenario: Verify if the low to high filter works right
     Given I set the user name field with "standard_user"
     And I set the password field with "secret_sauce"
     And I click on login button
     When I select low to high option in the filter
     Then The products will be sorted in low to high prices


