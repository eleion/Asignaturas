package prueba;

/**
 * @brief Clase que implementa el patrón "Interceptor".
 * */
public class DemoInterceptor {
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * 
	 *                Programa principal.
	 * * * * * * * * * * * * * * * * * * * * * * * * * */	
	
	public static void main(String[] args) {
		// Variables.
		GestorFiltros gestorFiltros = new GestorFiltros();   	// Creamos el gestor de filtros.
		Cliente cliente             = new Cliente();			// Creamos el cliente.
		
		// Añadimos los filtros.
		gestorFiltros.addFiltro(new CalcularDistancia());
		gestorFiltros.addFiltro(new CalcularVelocidad());

		cliente.setGestorFiltros(gestorFiltros);
		// Número inicial de vueltas del eje.
		cliente.enviarPeticion(500);
		
	}
}
