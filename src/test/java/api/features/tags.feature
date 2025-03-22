@api
Feature: Get List of Tags on https://dummyapi.io/data/v1/tag

  Scenario: Get list of tags
    Given send "GET" request to "/tag" endpoint
    Then the response code should be 200