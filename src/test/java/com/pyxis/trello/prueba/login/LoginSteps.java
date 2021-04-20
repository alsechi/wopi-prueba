package com.pyxis.trello.prueba.login;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.List;

import cucumber.api.DataTable;

import static org.hamcrest.Matchers.containsString;


public class LoginSteps {

	LoginPageObject loginPageObject;
	
	@Step
	public void AbrirNavegador() {
		loginPageObject.open();
	}
	
	@Step("Ingresar datos de acceso ")
	public void IniciarSesionExitosa(DataTable datos) {
		List<List<String>> data = datos.raw();
		loginPageObject.darClickLinkIniciar();
		loginPageObject.ingresarUser(data.get(0).get(0).trim());
		loginPageObject.darClickBotonIngresar();
		loginPageObject.ingresarPassword(data.get(0).get(1).trim());
		loginPageObject.darClickBotonIniciar();
		
	}

	@Step("verificar el inicio correcto se sesión")
	public void VerificarAccesoApp(String mensaje) {
		assertThat(loginPageObject.obtenerMensajeIngreso(),containsString(mensaje));
		Serenity.takeScreenshot();
	}

	@Step("verificar el mensaje de error")
	public void VerificarMensajeError(String mensaje) {
		assertThat(loginPageObject.obtenerMensajeErrorIngreso(),containsString(mensaje));
		Serenity.takeScreenshot();
	}

	
}
