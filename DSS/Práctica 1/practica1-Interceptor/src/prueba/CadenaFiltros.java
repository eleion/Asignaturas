package prueba;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa una cadena de filtros
 *  que se usarán en el patrón Interceptor.
 * */
public class CadenaFiltros {
	// Atributos.
	private List<Filtro> filtros;
	private Interfaz objetivo;
	
	// Métodos.
	/**
	 * @brief Constructor de la clase.
	 * */
	CadenaFiltros(){
		// Declaramos el array de filtros genérico de elementos Filtro.
		filtros  = new ArrayList<Filtro>();
		// El objetivo será crear la interfaz.
		objetivo = new Interfaz();
	}
	
	/**
	 * @brief Añadir un filtro a la lista de filtros.
	 * @param f: Filtro que se va a añadir.
	 * */
	public void addFiltro(Filtro f){
		filtros.add(f);
	}
	
	/**
	 * @brief Elimina un filtro.
	 * @param f: Filtro que se va a eliminar.
	 * */
	public void delFiltro(Filtro f){
		filtros.remove(f);
	}
	
	/**
	 * @brief Ejecuta la petición. Ejecuta todos los filtros de
	 * 		la lista de los filtros.
	 * @param peticion: Double indicando qué se va a ejecutar.
	 * */
	public void ejecutar(double peticion) {
		// Ejecutamos cada uno de los filtros.
		for(Filtro f: filtros) {
			System.out.println("  [Fil]------Nueva velocidad (m/s) " + f.ejecutar(peticion));
		}
		
		// Ejecutamos el objetivo.
		try {
			objetivo.ejecutar(peticion);
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * Indicar el objetiv.
	 * @param Será la interfaz que se va a mostrar.
	 * */
	public void setObjetivo(Interfaz objetivo) {
		this.objetivo = objetivo;
	}
}
