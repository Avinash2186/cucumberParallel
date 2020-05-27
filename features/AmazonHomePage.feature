@SEARCHITEMS
Feature: Search Feature on Amazon.com

@SEARCHITEMS1
  Scenario: Search Validation with Lego
    Given User is on Home Page
    When User searches for "LEGO"
    Then products related to search must appear

  Scenario: Search Validation with Pogo
    Given User is on Home Page
    When User searches for "Pogo"
    Then products related to search must appear

  Scenario: Search Validation with Capering
    Given User is on Home Page
    When User searches for "Capering"
    Then products related to search must appear
