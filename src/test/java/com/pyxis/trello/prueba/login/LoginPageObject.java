package com.pyxis.trello.prueba.login;

import org.openqa.selenium.WebDriver;

import com.pyxis.trello.prueba.utils.AccionesObjetos;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http:trello.com")
public class LoginPageObject extends PageObject {

	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	AccionesObjetos accionesObjetos;
	
	@FindBy(xpath = "//nav/div/a[1]")
	public WebElementFacade linkIniciar;

	@FindBy(xpath = "//*[@id=\"user\"]")
	public WebElementFacade strUser;

	@FindBy(xpath = "//*[@id=\"password\"]")
	public WebElementFacade strPassword;

	@FindBy(xpath = "//*[@id=\"login\"]")
	public WebElementFacade btnIngresar;
	
	@FindBy(xpath = "//*[@id=\"login-submit\"]")
	public WebElementFacade btnIniciar;

	@FindBy(xpath = "//*[@id=\"password-error\"]")
	public WebElementFacade msgErrorIngreso;
	
	@FindBy(xpath = "//nav/div[1]//a/span[2]")
	public WebElementFacade msgIngreso;
	
	public void darClickLinkIniciar() {
		try {
			accionesObjetos.ClickObjeto(linkIniciar, "");
			waitFor(15).seconds();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ingresarUser(String user) {
		accionesObjetos.setInputText(strUser, user);
		
	}

	public void ingresarPassword(String password) {
		accionesObjetos.setInputText(strPassword, password);
	}

	public void darClickBotonIngresar() {
		try {
			accionesObjetos.ClickObjeto(btnIngresar, "");
			waitFor(15).seconds();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String obtenerMensajeIngreso() {
		return msgIngreso.getText();
	}

	public String obtenerMensajeErrorIngreso() {
		return msgErrorIngreso.getText();
	}

	public boolean validarIngresarHabilitado() {
		return (btnIngresar.isEnabled());
	}
	
	public void darClickBotonIniciar() {
		try {
			accionesObjetos.ClickObjeto(btnIniciar, "");
			waitFor(15).seconds();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
