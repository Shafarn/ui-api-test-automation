@api
Feature: Get user by ID , Create User , Update and Delete User on https://dummyapi.io/data/v1/user

  Scenario: Create user
    Given I have a user data
    When send "POST" request to "/user/create" endpoint with request body
    Then the response code should be 200
    And validate the following fields in the response body: "title, firstName, lastName, email"
    Then save the created user id

  Scenario: Get user by ID
    Given Create a User
    Then send "GET" request to fake user endpoint
    Then the response code should be 200
    And the response body should contain the created userId

Scenario: Get user by invalid ID
    Given send "GET" request to "/user/60d0fe4f5311116168a109c1" endpoint
    Then the response code should be 404
    And the response body should contain error message indicating that the user was not found

  Scenario: Update User
    Given Create a User
    Then I have a user data
    Then send "PUT" request to fake user endpoint with request body
    Then the response code should be 200
    And validate the following fields in the response body: "title, firstName, lastName, email"

  Scenario: Delete User
    Given Create a User
    Then send "DELETE" request to fake user endpoint
    Then the response code should be 200

  Scenario: Delete Invalid User
    Then send "DELETE" request to "/user/60d0fe4f5311116168a109c1" endpoint
    Then the response code should be 404