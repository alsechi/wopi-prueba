#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Tableros
Feature: Escenarios que utilizan los tablerros
  @TableroConListaExitoso
  Scenario Outline: Tablero con lista nuevo
    Given ingreso al portal transaccional
    And digito los datos de usuario
 		|<User>| <Password>| 
    When creo un tablero nuevo <Tablero>
    And  creo una lista nueva <Lista>
    Then verifico los elementos creados <Tablero> <Lista>

    Examples:
      |User|Password|Tablero|Lista|
      |pruebatrello247@yopmail.com|bocadillo1|"Tablero 1"|"Lista 1"|
