package com.pyxis.trello.prueba.login;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginDefinitions {

	@Steps
	LoginSteps loginSteps;

	@Given("^ingreso al portal transaccional$")
	public void ingresoAlPortalTransaccional() {
		loginSteps.AbrirNavegador();
	}

	@When("^digito los datos de usuario$")
	public void digitoLosDatosDeUsuario(DataTable datos) {
		loginSteps.IniciarSesionExitosa(datos);
	}

	@Then("^verifico el ingreso exitoso \"([^\"]*)\"$")
	public void verificoElIngresoExitoso(String mensaje) {
		loginSteps.VerificarAccesoApp(mensaje);
	}

	@Then("^verifico el mensaje de error \"([^\"]*)\"$")
	public void verificoElMensajeDeError(String mensaje) {
		loginSteps.VerificarMensajeError(mensaje);
	}

	
}