@Login
Feature: Escenarios del Login

 @LoginExitoso @Todos
 Scenario Outline: Login Exitoso
 	Given ingreso al portal transaccional
 	When digito los datos de usuario
 	|<User>| <Password>|
 	Then verifico el ingreso exitoso <Mensaje>
    
     Examples: 
      |User|Password|Mensaje|
      |pruebatrello247@yopmail.com|bocadillo1|"Tableros"|
    
 @LoginNoExitoso 
 Scenario Outline: Login No Exitoso
 	Given ingreso al portal transaccional
 	When digito los datos de usuario 
 	|<TipoDoc>| <NroDoc>| <Password>| 
 	Then verifico el mensaje de error <Mensaje>
   
     Examples: 
      |User|Password|Mensaje|
      |haunter_42@hotmail.com|Tsoft2018|"¡Error en Credenciales!"|

      
