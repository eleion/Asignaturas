package prueba;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa una cadena de filtros
 *  que se usar�n en el patr�n Interceptor.
 * */
public class CadenaFiltros {
	// Atributos.
	private List<Filtro> filtros;
	private Interfaz objetivo;
	
	// M�todos.
	/**
	 * @brief Constructor de la clase.
	 * */
	CadenaFiltros(){
		// Declaramos el array de filtros gen�rico de elementos Filtro.
		filtros  = new ArrayList<Filtro>();
		// El objetivo ser� crear la interfaz.
		objetivo = new Interfaz();
	}
	
	/**
	 * @brief A�adir un filtro a la lista de filtros.
	 * @param f: Filtro que se va a a�adir.
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
	 * @brief Ejecuta la petici�n. Ejecuta todos los filtros de
	 * 		la lista de los filtros.
	 * @param peticion: Double indicando qu� se va a ejecutar.
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
	 * @param Ser� la interfaz que se va a mostrar.
	 * */
	public void setObjetivo(Interfaz objetivo) {
		this.objetivo = objetivo;
	}
}
