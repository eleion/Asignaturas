package prueba;

/**
 * @brief Clase que implementa el patr�n "Interceptor".
 * */
public class DemoInterceptor {
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * 
	 *                Programa principal.
	 * * * * * * * * * * * * * * * * * * * * * * * * * */	
	
	public static void main(String[] args) {
		// Variables.
		GestorFiltros gestorFiltros = new GestorFiltros();   	// Creamos el gestor de filtros.
		Cliente cliente             = new Cliente();			// Creamos el cliente.
		
		// A�adimos los filtros.
		gestorFiltros.addFiltro(new CalcularDistancia());
		gestorFiltros.addFiltro(new CalcularVelocidad());

		cliente.setGestorFiltros(gestorFiltros);
		// N�mero inicial de vueltas del eje.
		cliente.enviarPeticion(500);
		
	}
}
