### Introduccion
https://github.com/alsechi/wopi-prueba
Una automatizacion simple con la cual usa una platoforma de pago de test [Wopi](https://checkout.co.uat.wompi.dev/l/stagtest_VPOS_bdQraT) para disitntos casos de uso  usos tomando captura de pantalla en cada paso.

###Patrones
 Este fue realizado con el patron POM (Page object Model) debido a la premura de la implementacion igual maneja el lenguaje gherkin para el orden dela automatizacion
###Ejecucion
no tenia el conocimiento  a la velocidad de la prueba para ejecutarlo con el git action(pero ya me pondre aprender eso)
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
### Erratas
    Aunque el xlxs tiene contemplado el error de cuando el monto no fue valido ese caso dado que muestra un mensaje en una lista que aparece por lugar  distinto no se compruebe igual que el denegado o aprobado
###Autor
Alejandro Vargas **haunter42@gmail.com**