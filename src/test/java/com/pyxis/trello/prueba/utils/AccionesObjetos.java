package com.pyxis.trello.prueba.utils;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;

public class AccionesObjetos extends PageObject
{
	public AppiumDriver<WebElement> getConexionAppium(){
		@SuppressWarnings("unchecked")
		AppiumDriver<WebElement> conexionAppium = ((AppiumDriver<WebElement>)((WebDriverFacade) getDriver()).getProxiedDriver());
		return conexionAppium;
	}
	
	private int tiempoEspera = 30;
	public void setTiempoEspera(int newTime) {this.tiempoEspera = newTime;}
	 
	public AccionesObjetos(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	public void hideKeyboard() throws Exception {
		try {
			 getConexionAppium().hideKeyboard();
		 } catch (Exception e) {
			 System.out.println("Error al esconder el teclado");
		 }
	}
	
	public void setInputText(WebElement el, String dato)
	{		
		if(dato.equals("[IGNORE]")) return;
		el.click();
		el.clear();
		el.sendKeys(dato);
		try {hideKeyboard();} catch (Exception e) {e.printStackTrace();}
		Serenity.takeScreenshot();
	}
	
	public void setInputText(String [] elementos, String dato)
	{
		setInputText(EsperarObtenerObjetos(elementos), dato);
	}
	
	public void ClickObjeto(WebElement el, String dato)
	{
		if(dato.equals("[IGNORE]")) return;
		//tap(el);
		el.click();
		Serenity.takeScreenshot();
	}
	
	public void ClickObjeto(String [] elementos, String dato)
	{
		ClickObjeto(EsperarObtenerObjetos(elementos), dato);
	}
	
	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado, 30seg
	 * @param pro propiedad por el cual será buscado id, class, xpath
	 * @param prop valor de la propiedad
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement EsperarObtenerObjetos(String pro, String prop)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), this.tiempoEspera);
		WebElement element = null;
		try
		{
			switch(pro)
			{
				case "id":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop)));
					element = getDriver().findElement(By.id(prop));
				break;
				case "xpath":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop)));
					element = getDriver().findElement(By.xpath(prop));
				break;
				case "class":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(prop)));
					element = getDriver().findElement(By.className(prop));
				break;
			}
		}catch(Exception ex) {}
		finally {setTiempoEspera(30);}
		return element;
	}
	
	/***
	* Metodo para encontrar una lista de objetos esperando un tiempo maximo determinado, 30seg
	* @param pro propiedad por el cual será buscado id, class, xpath
	* @param prop valor de la propiedad
	* @return List<WebElement> con los cual interactuar, null sino se encuentra
	*/
	public List<WebElement> EsperarObtenerObjetosLista(String pro, String prop)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), this.tiempoEspera);
		List<WebElement> element = null;
		try
		{
				switch(pro)
				{
					case "id":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop)));
						element = getDriver().findElements(By.id(prop));
					break;
					case "xpath":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop)));
						element = getDriver().findElements(By.xpath(prop));
					break;
					case "class":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(prop)));
						element = getDriver().findElements(By.className(prop));
					break;
				}
		}catch(Exception ex) {}
		finally {setTiempoEspera(30);}
		return element;
	}
	
	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado
	 * @param pro propiedad por el cual será buscado id, class, xpath
	 * @param prop valor de la propiedad
	 * @param tiempoEspera tiempo maximo a esperar en segundos 
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement EsperarObtenerObjetos(String pro, String prop,int tiempoEspera)
	{
		setTiempoEspera(tiempoEspera);
		return EsperarObtenerObjetos(pro, prop);
	}
	
	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado, 30seg
	 * @param elemento WebElemento que se desea encontrar
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement EsperarObtenerObjetos(WebElement elemento) {
		WebDriverWait wait = new WebDriverWait(getDriver(), tiempoEspera);
		setTiempoEspera(30);
		return wait.until(ExpectedConditions.visibilityOf(elemento));
	}
	
	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado
	 * @param elemento WebElemento que se desea esperar
	 * @param tiempoEspera tiempo maximo a esperar en segundos 
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement EsperarObtenerObjetos(WebElement elemento,int tiempoEspera) {
		setTiempoEspera(tiempoEspera);
		return EsperarObtenerObjetos(elemento);
	}
	
	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado, 30seg
	 * @param propiedades array con las propiedades del elemento
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement EsperarObtenerObjetos(String[] propiedades) {
		String propi[]=	RetornarIosAndroid(propiedades);
		return EsperarObtenerObjetos(propi[0], propi[1]);
	}
	
	/***
	 * Metodo para encontrar un objeto esperando un tiempo maximo determinado
	 * @param propiedades array con las propiedades del elemento
	 * @param tiempoEspera tiempo maximo a esperar en segundos 
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public WebElement EsperarObtenerObjetos(String[] propiedades,int tiempoEspera) {
		setTiempoEspera(tiempoEspera);
		return EsperarObtenerObjetos(propiedades);
	}
	
    /***
	 * Metodo para encontrar una lista de objetos esperando un tiempo maximo determinado, 30seg
	 * @param propiedades array con las propiedades del elemento
	 * @return WebElement con el cual interactuar, null sino se encuentra
	 */
	public List<WebElement> EsperarObtenerObjetosLista(String[] propiedades){
		String propi[] = RetornarIosAndroid(propiedades);
		return EsperarObtenerObjetosLista(propi[0], propi[1]);
	}
	
	/***
	 * Metodo para retornar las propidades dependiendo si es iOs o Android
	 * @param propiedades Array de String con 4 elementos, los dos primeros son las propiedades de Android, los 2 ultimos las de iOS 
	 * @return Array de String con las propiedades de Android o iOS
	 */
	private String[] RetornarIosAndroid (String[] propiedades) {
		String[] elemento = new String[2];
		String SO = getConexionAppium().getPlatformName().toLowerCase();
		switch (SO)
		{
			case "ios":
				elemento[0] = propiedades[2];
				elemento[1] = propiedades[3];
				break;
			case "android":
				elemento[0] = propiedades[0];
				elemento[1] = propiedades[1];
				break;		
		}
		return elemento;
	}
	
	/***
	 * Metodo para sustituir el Thread.sleep()
	 * @param tiempoEspera tiempo el cual se desea esperar
	 */
	public void FalsoSleep (int tiempoEspera) {
		setTiempoEspera(tiempoEspera);
		EsperarObtenerObjetos("class", "falsoSleep");
		setTiempoEspera(30);
	}
	
	@SuppressWarnings("rawtypes")
	public void swipe (int inicialx, int inicialy, int finx, int finy) {
		new TouchAction((PerformsTouchActions) getConexionAppium()).longPress(
				new PointOption<>().withCoordinates(inicialx,inicialy)).
		moveTo(new PointOption<>().withCoordinates(finx,finy)).release().perform();
	}
	
	@SuppressWarnings("rawtypes")
	public void longPress (int x, int y,long duracion) 
	{
		Duration duracion2 = Duration.ofMillis(duracion);
		LongPressOptions lpo = new LongPressOptions();
		lpo.withPosition(new PointOption<>().withCoordinates(x,y));
		lpo.withDuration(duracion2);
		new TouchAction((PerformsTouchActions) getConexionAppium()).longPress(lpo).perform().release();
	}
	
	@SuppressWarnings("rawtypes")
	public void press (int x, int y) 
	{
		new TouchAction((PerformsTouchActions) getConexionAppium()).press(new PointOption<>().withCoordinates(x,y)) .perform().release();
	}
	
	@SuppressWarnings("rawtypes")
	public void tap (int x, int y)
	{
		new TouchAction((PerformsTouchActions) getConexionAppium()).tap(new TapOptions().withPosition(new PointOption<>().withCoordinates(x,y))) .perform().release();
	}
	
	@SuppressWarnings("rawtypes")
	public void tap (WebElement elemento)
	{
		int x = elemento.getLocation().getX() + (elemento.getSize().getWidth() / 2);
		int y = elemento.getLocation().getY()  + (elemento.getSize().getHeight() / 2);
		new TouchAction((PerformsTouchActions) getConexionAppium()).tap(new TapOptions().withPosition(new PointOption<>().withCoordinates(x,y))) .perform().release();
	}
	
	@SuppressWarnings("unchecked")
	public AndroidDriver<AndroidElement> getAndroidDriver()
	{
		AndroidDriver<AndroidElement> androidDriver = (AndroidDriver<AndroidElement>) ((WebDriverFacade) getDriver())
				   .getProxiedDriver();
		return androidDriver;
	}
	
	@SuppressWarnings("unchecked")
	public IOSDriver<IOSElement> getIosDriver()
	{
		IOSDriver<IOSElement> androidDriver = (IOSDriver<IOSElement>) ((WebDriverFacade) getDriver())
				   .getProxiedDriver();
		return androidDriver;
	}
	
	public void ObtenerTodoLosObjetos()
	{
		List<WebElement> elementos = getConexionAppium().findElementsByXPath("//*");
		for(WebElement el : elementos)
		{
			System.out.println(el.getText());
		}
	}
	
	public String ObtenerUDID()
	{
		return getAndroidDriver().getCapabilities().getCapability("deviceName").toString();
	}
}