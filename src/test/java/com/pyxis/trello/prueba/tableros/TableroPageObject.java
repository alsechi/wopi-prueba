package com.pyxis.trello.prueba.tableros;

import org.openqa.selenium.WebDriver;

import com.pyxis.trello.prueba.utils.AccionesObjetos;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class TableroPageObject extends PageObject {
	
	AccionesObjetos accionesObjetos;
	
	@FindBy(xpath = "//*[@class=\"boards-page-board-section mod-no-sidebar\"][1]//*[@data-test-id=\"create-board-tile\"]/div")
	public WebElementFacade cardTableroAdd;
	
	@FindBy(xpath = "//*[@data-test-id=\"create-board-title-input\"]")
	public WebElementFacade strTablero;
	
	@FindBy(xpath = "//*[@data-test-id=\"create-board-submit-button\"]")
	public WebElementFacade btnTableroAdd;
	
	//se pone con esta espicificacion debido a la naturaleza de esta auto que siempre se creara en un tablero nuevo
	@FindBy(xpath = "//*[@id=\"board\"]/div[4]/form/a")
	public WebElementFacade cardListaAdd;
	
	@FindBy(xpath = "//*[@class=\"list-name-input\"]")
	public WebElementFacade strLista;
	
	@FindBy(xpath = "//*[@class=\"list-add-controls u-clearfix\"]/input")
	public WebElementFacade btnListaAdd;
	
	@FindBy(xpath = "//div/h1")
	public WebElementFacade msgTituloTablero;
	
	@FindBy(xpath = "//div[@class=\"js-list list-wrapper\"][4]")
	public WebElementFacade msgTituloLista;
	
	@FindBy(xpath = "//li[5]/a")
	public WebElementFacade optMas;
	
	@FindBy(xpath = "//ul[3]/li/a")
	public WebElementFacade optCerrarTablero;
	
	@FindBy(xpath = " //*[@id=\"chrome-container\"]/div[4]//input")
	public WebElementFacade btnCerrarOEliminar;
	
	@FindBy(xpath = "//p[2]/a")
	public WebElementFacade linkEliminar;
	
	
	
	public void clickCardNuevoTablero() {
		try {
			accionesObjetos.ClickObjeto(cardTableroAdd, "");
			waitFor(10).seconds();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ingresarNombreDeTablero(String tablero) {
		accionesObjetos.setInputText(strTablero, tablero);
	}
	
	public void clickAgregarTablero() {
		try {
			accionesObjetos.ClickObjeto(btnTableroAdd, "");
			waitFor(10).seconds();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickCardNuevaLista() {
		try {
			accionesObjetos.ClickObjeto(cardListaAdd, "");
			waitFor(10).seconds();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ingresarNombreDeLista(String lista) {
		accionesObjetos.setInputText(strLista, lista);
	}
	
	public void clickAgregarLista() {
		try {
			accionesObjetos.ClickObjeto(btnListaAdd, "");
			waitFor(10).seconds();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String obtenerMensajeTituloTablero() {
		return msgTituloTablero.getText();
	}
	
	public String obtenerMensajeTituloLista() {
		return msgTituloLista.getText();
	}
	
	public void eliminarTablero() {
		try {
			accionesObjetos.ClickObjeto(optMas, "");
			accionesObjetos.ClickObjeto(optCerrarTablero, "");
			accionesObjetos.ClickObjeto(btnCerrarOEliminar, "");
			accionesObjetos.ClickObjeto(linkEliminar, "");
			accionesObjetos.ClickObjeto(btnCerrarOEliminar, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
