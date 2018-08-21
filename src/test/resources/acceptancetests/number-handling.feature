@numbers
@all
Feature: Java tests

  @numbers_1
  Scenario: print numbers to file
    When i print numbers 1 to 100 to file ./numbers.txt
    Then i print half of the numbers from file ./numbers.txt having 100 as last number

