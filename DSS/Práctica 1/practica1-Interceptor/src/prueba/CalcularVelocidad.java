package prueba;

public class CalcularVelocidad implements Filtro{

	// Atributos.
	double revolAnt;
	double RADIO;
	
	// M�todos.
	/**
	 * Constructor. Se encarga de darle a los atributos
	 * 		unos valores iniciales.
	 * */
	CalcularVelocidad() {
		revolAnt = 0;
		RADIO    = 3;
	}
	
	/**
	 * @brief Ejecuta la petici�n pertinente.
	 * @param o: Petici�n que se desea ejecutar.
	 * */
	public double ejecutar(Object o){
		double revoluciones = (Double) o;
		double distancia    = (revoluciones - revolAnt) * 2 * RADIO * 3.1416;
		
		revolAnt = revoluciones;
		
		return distancia;
	}
}
