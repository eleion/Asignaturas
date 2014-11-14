package prueba;

/**
 * Clase encargada de gestionar los filtros según
 * 		el patrón Interceptor.
 * */
public class GestorFiltros {
	// Atributos.
	private CadenaFiltros cadena_filtros;
	
	// Métodos.
	/**
	 * Constructor. Se encarga de darle valores iniciales 
	 * 		a los atributos.
	 * @param objetivo: Objetivo de la cadena de filtros.
	 * */
	GestorFiltros(){
		cadena_filtros = new CadenaFiltros();
		
	}
	
	/**
	 * Añade un filtro a la cadena de filtros.
	 * @param f: Filtro que se va a añadir a la cadena.
	 * */
	void addFiltro(Filtro f){
		cadena_filtros.addFiltro(f);
	}
	
	/**
	 * Elimina un filtro de la cadena de filtros.
	 * @param f: Filtro que se quiere eliminar.
	 * */
	void delFiltro(Filtro f){
		cadena_filtros.delFiltro(f);
	}
	
	/**
	 * Ejecuta el filtro pertinente.
	 * @param p: Petición.
	 * */
	void ejecutar(double p){
		cadena_filtros.ejecutar(p);
	}

}
