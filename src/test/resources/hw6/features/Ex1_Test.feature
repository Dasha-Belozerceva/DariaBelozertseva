Feature: Exercize1 feature

  Scenario: Different Elements Page Test
    Given I open JDI GitHub site
    And I login as user Roman Iovlev
    Then 'Home Page' page should be opened
    And User name should be 'ROMAN IOVLEV'
    When I click on Service button in Header
    And I click Different elements button
    And I select checkbox 'Water'
    And I select checkbox 'Wind'
    And I select radio 'Selen'
    And I select in dropdown 'Yellow'
    Then LogRow should be displayed with value 'Water' and condition 'true'
    And LogRow should be displayed with value 'Wind' and condition 'true'
    And LogRow should be displayed with value 'metal' and condition 'Selen'
    And LogRow should be displayed with value 'Colors' and condition 'Yellow'

