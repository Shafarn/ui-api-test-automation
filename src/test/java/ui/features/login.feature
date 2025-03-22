@web
Feature: Login

  Scenario: Successfully login
    Given user is on login page
    When user click login nav menu
    Then modal login is shown
    And user input username "shafa"
    And user input password "shafa"
    And user press login button
    Then user is logged in

  Scenario: Failed login - wrong password
    Given user is on login page
    When user click login nav menu
    Then modal login is shown
    And user input username "random"
    And user input password "asdf"
    And user press login button
    Then alert will show "Wrong password."

  Scenario: Failed login -
    Given user is on login page
    When user click login nav menu
    Then modal login is shown
    And user input username "kzxlcja123iso"
    And user input password "asdf"
    And user press login button
    Then alert will show "User does not exist."