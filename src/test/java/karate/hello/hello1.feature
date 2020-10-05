Feature: Hello World

  Background:
    Given url baseUrl
    Given path '/greeting'

  Scenario: Hello World

    When method GET
    Then status 200
    And match $ = "Hello, world!"