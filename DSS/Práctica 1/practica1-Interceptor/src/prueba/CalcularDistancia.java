package prueba;

/**
 * Este filtro se encarga de calcular la velodidad.
 * */
public class CalcularDistancia implements Filtro{
	
	// Atributos.
	double distancia_ant;
	double INTERVALO;
	
	// Métodos.
	/**
	 * Constructor, se encarga de darle valores
	 * 	iniciales a los atributos.
	 * */
	CalcularDistancia() {
		distancia_ant  = 0;
		INTERVALO = 10;
	}
	
	/**
	 * @brief Ejecuta las peticiones del usuario.
	 * @param o: Petición que se va a ejecutar.
	 * */
	public double ejecutar(Object o) {
		double distancia = (Double) o;
		distancia = distancia / INTERVALO;
		
		// Guardamos los datos.
		distancia_ant = distancia;
		return distancia;
	}
}
