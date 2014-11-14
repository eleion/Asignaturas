package prueba;

import java.io.IOException;
import java.net.URISyntaxException;

public class Interfaz {
	// Atributos.
	
	// Métodos.
	/**
	 * @brief Ejecuta la petición.
	 * @param Petición que se pretende ejecutar.
	 * */
	void ejecutar(double p) throws IOException, URISyntaxException{
		System.out.println("  [Ifz]------Llamada a la interfaz");
		java.awt.Desktop.getDesktop().browse(new java.net.URI("http://localhost:8080/holamundo/home.jsf"));
	}
}
