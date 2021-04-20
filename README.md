### Introduccion

Una automatizacion simple con la cual crea un tablero y una lista nueva dentro de la pagina [Trello](https://trello.com) tomando captura de pantalla en cada paso.

###Ejecucion

Este es el comando de ejecucion completo :

`$ mvn test -Dwebdriver.driver=chrome serenity:aggregate`

el se divide en el comando principal de ejecucion `$ mvn test` , la opcion que escoge el driver de navegador o del dispositivo movil a trabajar  `-Dwebdriver.driver=chrome` en este caso chrome y el comando para agregara la evidencia `mvn serenity:aggregate`


###Resultados

Para ver los resultados de la ejecucion  dirigirnos a la carpeta de proyecto ***target/site/serenity*** dentro de esta buscar un archivo *index* este te llevara a una pagina que presentara la evidencia  de ejecucion de manera ordenada

###Precondiciones
#####Conexion a internet
#####En la carpeta driver  tener el webdriver de su navegador correcto para esto:

1. Verificar la version de el navegador ejecutar normalmente se encuentra en ayuda -> acerca de...
1. luego buscar webdriver de esta version en el caso de cromes es [chromedriver](https://chromedriver.chromium.org/downloads)
1. poner el driver en la carpeta de drivers ***\src\test\resources***

### Construido con
- Maven
- Junit
- SerenityBDD
- Selenium library

###Autor
Alejandro Vargas **haunter42@gmail.com**