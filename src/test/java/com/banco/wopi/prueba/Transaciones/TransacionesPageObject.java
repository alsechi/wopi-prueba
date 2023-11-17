package com.banco.wopi.prueba.Transaciones;

import com.banco.wopi.prueba.utils.AccionesObjetos;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://checkout.co.uat.wompi.dev/l/stagtest_VPOS_bdQraT")
public class TransacionesPageObject extends PageObject {

    public TransacionesPageObject(WebDriver driver) {
        super(driver);
    }

    AccionesObjetos accionesObjetos;

    @FindBy(xpath ="//*[@id=\"app\"]/div[2]/div/div[2]/div/form/div/input")
    public WebElementFacade strMonto;

    @FindBy(xpath ="//*[@id=\"app\"]/div[2]/div/div[2]/div/div/a[2]")
    public WebElementFacade qr;

    @FindBy(xpath ="//*[@id=\"app\"]/div[2]/div/div[2]/div/div/a[3]")
    public WebElementFacade tranferencia;

    @FindBy(xpath ="//*[@id=\"app\"]/div[2]/div/div[2]/div/div/a[6]")
    public WebElementFacade correponsal;

    @FindBy(xpath ="//*[@id=\"email\"]")
    public WebElementFacade strCorreo;

    @FindBy(xpath ="//*[@id=\"fullName\"]")
    public WebElementFacade strNombre;

    @FindBy(xpath ="//*[@id=\"number\"]")
    public WebElementFacade strTelefono;

    @FindBy(xpath ="//*[@id=\"acceptance\"]")
    public WebElementFacade aceptacion;

    @FindBy(xpath ="//*[@id=\"app\"]/div[2]/div/div[2]/div/form/div/button")
    public WebElementFacade continuar;

    @FindBy(xpath ="//*[@id=\"app\"]/div[2]/div/div[2]/div/form/div[5]/button")
    public WebElementFacade continuar2;

    @FindBy(xpath ="//*[@id=\"app\"]/div[2]/div/div[1]/span")
    public WebElementFacade resultado;


    public void ingresarMonto(String monto) {
        accionesObjetos.setInputText(strMonto,monto);
    }
    public void darClickQr() {
        try {
            accionesObjetos.ClickObjeto(qr, "");
            waitFor(15).seconds();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void darClickTransferencia() {
        try {
            accionesObjetos.ClickObjeto(tranferencia, "");
            waitFor(15).seconds();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void darClickCorresponsal() {
        try {
            accionesObjetos.ClickObjeto(correponsal, "");
            waitFor(15).seconds();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void darClickAcepto() {
        try {
            accionesObjetos.ClickObjeto(aceptacion, "");
            waitFor(15).seconds();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void darClickContinuar() {
        try {
            accionesObjetos.ClickObjeto(continuar, "");
            waitFor(15).seconds();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void darClickContinuar2() {
        try {
            accionesObjetos.ClickObjeto(continuar2, "");
            waitFor(15).seconds();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ingresarCorreo(String correo) {
        accionesObjetos.setInputText(strCorreo,correo);
    }
    public void ingresarNombre(String nombre) {
        accionesObjetos.setInputText(strNombre,nombre);
    }
    public void ingresarTelefono(String telefono) {
        accionesObjetos.setInputText(strTelefono,telefono);
    }

    public String obtenerResultadoDePago() {
        return resultado.getText();
    }

}
