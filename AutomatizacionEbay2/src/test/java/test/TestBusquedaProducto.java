package test;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.net.InetAddresses.TeredoInfo;

import page.PageBusquedaEbay;
import page.Producto;

public class TestBusquedaProducto {
	
	PageBusquedaEbay busquedaEbay;
	String articulo;
	String URL="https://www.ebay.com/";
	String formaOrdenamiento="ascendentemente";
	
	@BeforeMethod
	public void SetUP()
	{
		busquedaEbay= new PageBusquedaEbay();
		busquedaEbay.getDriver().manage().window().maximize();
		busquedaEbay.getDriver().get(URL);
	
	}
	
	@Test
	public void testBuscarZapato() throws InterruptedException
	{
		articulo="Zapatos";
		By buscador=By.id("gh-ac");
		By botonBuscador=By.id("gh-btn");
		
		By buscadorMarca=By.className("x-searchable-list__textbox__aspect-Brand");
		
		//NIKE=5; PUMA=6, ETC		
		By marca=By.xpath("//*[@id=\"w4-w13\"]/ul/li[6]/div/a/div/input");
		//By marca=By.className("x-searchable-list__textbox");
		
		By talla=By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[5]/div/a/div/input");
		
		busquedaEbay.getBuscadorProducto(buscador);
		busquedaEbay.buscarProducto(articulo, buscador, botonBuscador);
		
		//busquedaEbay.getBuscadorProducto(buscadorMarca).sendKeys("nike");
		busquedaEbay.getBuscadorProducto(marca).click();
		
		Thread.sleep(3000);
		
		busquedaEbay.getBuscadorProducto(talla).click();//SE LA PASA LA TALLA
		
		
		//IMPRIMIR EL NÚMERO DE RESULTADOS PARA ZAPATOS
		//By textoResultados=By.className("srp-controls__count-heading");
		By catidadResultados= By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div/div[1]/h1/span[1]");
		Thread.sleep(3000);
		WebElement cantidad=busquedaEbay.getBuscadorProducto(catidadResultados);
		System.out.println("RESUL "+cantidad.getText());
		
		busquedaEbay.mostrarResultadoBusqueda(cantidad.getText());	

		
		
		//ORDENAR ASCENDENTEMENTE
		//className: srp-controls__control--legacy
		//XPATH: //*[@id="w8"]/button/div
		
//		By ordenar=By.className("srp-sort__menu");
		
	//6- Ordenar por precio ascendente	
		By ordenar=By.xpath("//*[@id=\"w8\"]/button/div");
		//By tipoOrdenar=By.xpath();
		busquedaEbay.getBuscadorProducto(ordenar).click();
		busquedaEbay.getBuscadorProducto(ordenar).click();
		
//		Select listaOpcionesOrden = new Select(busquedaEbay.getBuscadorProducto(ordenar));
//		listaOpcionesOrden.selectByIndex(2);
//	//EL MAS BAJO PRIMERO=4, EL MAS ALTO PRIMERO=5
		By opcion=By.xpath("//*[@id=\"w8\"]/div/div/ul/li[4]");
				
		//SELECCIONAR EL TIPO DE ORDEN
		busquedaEbay.getBuscadorProducto(opcion).click();	
		
		
		//VALIDAR LOS 5 PRIMEROS RESULTADOS
		
		By primerPrecio=null;
		Double precio=0.0;
		

		
		//Tome los primeros 5 productos con sus precios e imprímalos en la consola: 
		By nombrePrimerProducto=null;
		
		String nombreProductoPrimero=null;

		
		
		//CREAR UNA LISTA CON LOS 5 PRIMEROS PROODUCTOS ORDENAS ACEDENTEMENTE POR PRECIO
		Thread.sleep(3000);
		List<Producto> listaProducto=new ArrayList<Producto>();
		
		for(int i=1; i<=10;i++)
		{
			primerPrecio=By.xpath("//*[@id=\"srp-river-results-listing"+i+"\"]/div/div[2]/div[3]/div[1]/span");
			precio=new Double(busquedaEbay.getBuscadorProducto(primerPrecio).getText().toString().substring(3,9));
			nombrePrimerProducto=By.xpath("//*[@id=\"srp-river-results-listing"+i+"\"]/div/div[2]/a/h3");
			nombreProductoPrimero=busquedaEbay.getBuscadorProducto(nombrePrimerProducto).getText().toString();
			Producto primerProducto= new Producto(nombreProductoPrimero, precio);
			listaProducto.add(primerProducto);
		}
		
		Assert.assertTrue((listaProducto.get(0).getPrecio()<=listaProducto.get(1).getPrecio())&(listaProducto.get(1).getPrecio()<=listaProducto.get(2).getPrecio())&(listaProducto.get(2).getPrecio()<=listaProducto.get(3).getPrecio())&(listaProducto.get(3).getPrecio()<=listaProducto.get(4).getPrecio()));
		
		System.out.println("Nombre "+nombreProductoPrimero);

		//8- Tome los primeros 5 productos con sus precios e imprímalos en la consola.
		System.out.println("Lista de productos con sus respectivos precios ordenados ascendentemente");
		System.out.println("========================================================================");
		for(int i=0;i<10;i++)
		{
			System.out.println("Primer precio "+listaProducto.get(i).getNombre());
			System.out.println("Primer precio "+listaProducto.get(i).getPrecio());
			
		}
		
		
		
		
		//9- Ordenar e imprimir los productos por nombre (ascendente)
		System.out.println("Lista de productos con sus respectivos precios ordenados ascendentemente");
		System.out.println("========================================================================");
		for(int i=9;i>=0;i--)
		{
			System.out.println("Primer precio "+listaProducto.get(i).getNombre());
			System.out.println("Primer precio "+listaProducto.get(i).getPrecio());
			
		}
		
		//10- Ordene e imprima los productos por precio en modo descendiente
		System.out.println("Lista de productos con sus respectivos precios ordenados ascendentemente");
		System.out.println("========================================================================");

		for(int i=0;i<10;i++)
		{
			System.out.println("Primer precio "+listaProducto.get(i).getNombre());
			System.out.println("Primer precio "+listaProducto.get(i).getPrecio());
			
		}
	
	
	}
	

	
	
	
	
	@AfterMethod
	public void close()
	{
		busquedaEbay.getDriver().manage().deleteAllCookies();
		busquedaEbay.getDriver().quit();
	
	}

}
