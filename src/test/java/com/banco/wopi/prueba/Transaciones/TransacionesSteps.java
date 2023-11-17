package com.banco.wopi.prueba.Transaciones;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.List;

import cucumber.api.DataTable;

import static org.hamcrest.Matchers.containsString;
public class
TransacionesSteps {
    TransacionesPageObject transacionesPageObject;

    @Step
    public void AbrirNavegador() {
        transacionesPageObject.open();
    }


    @Step("escoger tranferencia con el monto e ingresar datos ")
    public void IngresarDatosTranferencia(DataTable datos) {
        List<List<String>> data = datos.raw();
        transacionesPageObject.ingresarMonto(data.get(0).get(0).trim());
        transacionesPageObject.darClickContinuar();
        transacionesPageObject.darClickTransferencia();
        transacionesPageObject.ingresarCorreo(data.get(0).get(1).trim());
        transacionesPageObject.ingresarNombre(data.get(0).get(2).trim());
        transacionesPageObject.ingresarTelefono(data.get(0).get(3).trim());
        transacionesPageObject.darClickContinuar2();
        transacionesPageObject.darClickAcepto();
        transacionesPageObject.darClickContinuar2();

    }

    @Step("escoger qr con el monto e ingresar datos ")
    public void IngresarDatosQr(DataTable datos) {
        List<List<String>> data = datos.raw();
        transacionesPageObject.ingresarMonto(data.get(0).get(0).trim());
        transacionesPageObject.darClickContinuar();
        transacionesPageObject.darClickQr();
        transacionesPageObject.ingresarCorreo(data.get(0).get(1).trim());
        transacionesPageObject.ingresarNombre(data.get(0).get(2).trim());
        transacionesPageObject.ingresarTelefono(data.get(0).get(3).trim());
        transacionesPageObject.darClickAcepto();
        transacionesPageObject.darClickContinuar2();

    }



    @Step("escoger Coressponsal con el monto e ingresar datos ")
    public void IngresarDatosCorresponsal(DataTable datos) {
        List<List<String>> data = datos.raw();
        transacionesPageObject.ingresarMonto(data.get(0).get(0).trim());
        transacionesPageObject.darClickContinuar();
        transacionesPageObject.darClickCorresponsal();
        transacionesPageObject.ingresarCorreo(data.get(0).get(1).trim());
        transacionesPageObject.ingresarNombre(data.get(0).get(2).trim());
        transacionesPageObject.ingresarTelefono(data.get(0).get(3).trim());
        transacionesPageObject.darClickContinuar2();
        transacionesPageObject.darClickAcepto();
        transacionesPageObject.darClickContinuar2();

    }

    @Step("verificar el resultado")
    public void VerificarElResultado(String resultado) {
        assertThat(transacionesPageObject.obtenerResultadoDePago(),containsString(resultado));
        Serenity.takeScreenshot();
    }


}
