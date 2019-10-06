package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageBusquedaEbay {
	private WebDriver driver;
	private WebElement webElement;
	
	public PageBusquedaEbay() {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sady\\eclipse-workspace\\AutomatizacionEbay2\\webDriver\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
//	
//	public WebElement getBuscadorProductoId(String elemento)
//	{
//		//driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
//		return driver.findElement(By.id(elemento));
//			
//	}
	
	public WebElement getBuscadorProducto(By elemento)
	{
		//driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
		return driver.findElement(elemento);
			
	}
	
	public WebElement getBuscadorProductoXpath(String elemento)
	{
		//driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
		return driver.findElement(By.xpath(elemento));
			
	}
	
	//Metodo que recibe como parametro el articulo a buscar
	public void buscarProducto(String descripcion, By buscador, By boton)
	{
		//driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
		//driver.findElement(By.id("gh-ac"));
		//Obtiene el buscador y escribe sobre ella
		getBuscadorProducto(buscador).sendKeys(descripcion);
		//OOTIENE EL BOTON BUSCAR y HACE CLICK SOBRE EL
		getBuscadorProducto(boton).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWebElement() {
		return webElement;
	}

	public void setWebElement(WebElement webElement) {
		this.webElement = webElement;
	}
	
	//MUESTRA LA CANTIDAD DE ARTICULOS EN EL RESULTADOS DE LA BUSQUEDA
	public void mostrarResultadoBusqueda(String cantidad)
	{
		System.out.println("Cantidad de Resultados: "+cantidad);
	}
	
	
	
	
	
	
	
	

}
