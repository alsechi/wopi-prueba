package com.banco.wopi.prueba.Transaciones;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
public class TransacionesDefinitions {

    @Steps
    TransacionesSteps transacionesSteps;

    @Given("^Abro pagina medios de pago$")
    public void ingresoPaginaMediosDePago() {
        transacionesSteps.AbrirNavegador();
    }

    @When("^Seleciono monto y Qr e ingreso datos$")
    public void SelecionoMontoyQrEIngresoDatos(DataTable datos) {
        transacionesSteps.IngresarDatosQr(datos);
    }

    @When("^Seleciono monto y Corresponsal e ingreso datos$")
    public void SelecionoMontoyCorresponsalEIngresoDatos(DataTable datos) {
        transacionesSteps.IngresarDatosCorresponsal(datos);
    }

    @When("^Seleciono monto y tranferencia e ingreso datos$")
    public void SelecionoMontoyTranferenciaEIngresoDatos(DataTable datos) {
        transacionesSteps.IngresarDatosTranferencia(datos);
    }

    @Then("^Compruebo el resultado \"([^\"]*)\"$")
    public void Compruebo(String resultado) {
        transacionesSteps.VerificarElResultado(resultado);
    }



}
