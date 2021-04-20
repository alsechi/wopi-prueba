package com.pyxis.trello.prueba.tableros;

import com.pyxis.trello.prueba.login.LoginSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TableroDefinitions {
	
	
	@Steps
	TableroSteps tableroSteps;
	
	@When("^creo un tablero nuevo \"([^\"]*)\"$")
	public void creoUnTableroNuevo(String tablero) {
		tableroSteps.crearTableroNuevo(tablero);
	}
	
	@When("^creo una lista nueva \"([^\"]*)\"$")
	public void creoUnaListaNueva(String lista) {
		tableroSteps.crearlistaNueva(lista);
	}
	
	@Then("^verifico los elementos creados \"([^\"]*)\" \"([^\"]*)\"$")
	public void verificoElMensajeDeError(String tablero,String lista) {
		tableroSteps.verificarTablero(tablero);
		tableroSteps.verificarLista(lista);
		tableroSteps.eliminarTablero();
	}
}
