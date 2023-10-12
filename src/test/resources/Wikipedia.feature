Feature: Wikipedia

  Scenario: Search info about BDD
    Given I am on the wikipedia search page
    When I search for BDD
    Then the page title should start with BDD