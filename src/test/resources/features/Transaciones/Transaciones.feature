@Transaciones
Feature: Hacer las transaciones por medio de pagos

  @TransacionTranferencia
  Scenario Outline: Hacer una Transacion con Tranferencia
    Given Abro pagina medios de pago
    When Seleciono monto y tranferencia e ingreso datos
      |<Monto>|<Correo>|<Nombre>| <Telefono>|
    Then Compruebo el resultado <Resultado>
    Examples:
      |Monto|Correo|Nombre|Telefono|Resultado|
      |2000|pruebatrello247@yopmail.com|bocadillo1|3166204613|"Transacción aprobada"|


  @TransacionQr
  Scenario Outline: Hacer una Transacion con Qr bancolombia
    Given Abro pagina medios de pago
    When Seleciono monto y Qr e ingreso datos
      |<Monto>|<Correo>|<Nombre>| <Telefono>|
    Then Compruebo el resultado <Resultado>
    Examples:
      |Monto|Correo|Nombre|Telefono|Resultado|
      |2000|pruebatrello247@yopmail.com|bocadillo1|3166204613|"Transacción aprobada"|


  @TransacionCorresponsal
  Scenario Outline: Hacer una Transacion con Correponsal Bancario
    Given Abro pagina medios de pago
    When Seleciono monto y Corresponsal e ingreso datos
      |<Monto>|<Correo>|<Nombre>| <Telefono>|
    Then Compruebo el resultado <Resultado>
    Examples:
      |Monto|Correo|Nombre|Telefono|Resultado|
      |2000|pruebatrello247@yopmail.com|bocadillo1|3166204613|"Transacción aprobada"|
