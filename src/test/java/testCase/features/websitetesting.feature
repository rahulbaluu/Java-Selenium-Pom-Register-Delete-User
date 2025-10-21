# Created by rahulbalashanmugam at 20/10/2025
Feature: Testing the Website with some scenario's

  Scenario: Registering the new user and delete the created user
    Given Open the website home page
    When Verify the home page is visible successfully
    And Click on Signup Login button
    And Verify New User Signup is visible
    And Enter name, email address and click Signup button
    And Verify ENTER ACCOUNT INFORMATION is visible
    And Enter the details in the Signup form and click create Account button
    And Verify ACCOUNT CREATED is visible and click Continue button
    And Verify Login in as username is visible
    And Click Delete Account button
    And Verify that Account Deleted is visible
    Then Click Continue button and take screenshot on every step