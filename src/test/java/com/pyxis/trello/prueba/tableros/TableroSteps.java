package com.pyxis.trello.prueba.tableros;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.List;

import cucumber.api.DataTable;

import static org.hamcrest.Matchers.containsString;

public class TableroSteps {

	TableroPageObject tableroPageObject;
	
	@Step("Crea tablero nuevo")
	public void crearTableroNuevo(String tablero) {
		tableroPageObject.clickCardNuevoTablero();
		tableroPageObject.ingresarNombreDeTablero(tablero);
		tableroPageObject.clickAgregarTablero();
	}
	
	@Step("Crea Lista nueva")
	public void crearlistaNueva(String lista) {
		tableroPageObject.clickCardNuevaLista();
		tableroPageObject.ingresarNombreDeLista(lista);
		tableroPageObject.clickAgregarLista();
	}
	
	@Step("Verificar tablero creado")
	public void verificarTablero(String tablero) {
		assertThat(tableroPageObject.obtenerMensajeTituloTablero(),containsString(tablero));
		Serenity.takeScreenshot();
	}
	
	@Step("Verificar lista creada")
	public void verificarLista(String lista) {
		assertThat(tableroPageObject.obtenerMensajeTituloLista(),containsString(lista));
		Serenity.takeScreenshot();
	}
	
	@Step("Eliminar tablero")
	public void eliminarTablero() {
		tableroPageObject.eliminarTablero();
		Serenity.takeScreenshot();
	}
}
