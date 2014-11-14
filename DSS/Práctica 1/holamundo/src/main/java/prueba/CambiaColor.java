package prueba;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="cambiaColor", eager = true)
@SessionScoped
public class CambiaColor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String color   = "red";				// Colo que va a tener el texto: (red - blue).
	private String mensaje = "APAGADO";			// Mensaje que aparece en la parte superior.
	private String nombre1 = "Encender";		// Botón de la izquierda. (Encender - apagar)
	private String nombre2 = "Acelerar";		// Botón de la derecha. (Acelerar)
	
	/**
	 * @brief Constructor de la clase. Se encarga de que los atributos,
	 *  		estén inicializados.
	 * */
	public CambiaColor() {
		System.out.println( " +------El constructor se ha ejecutado.");
		color   = "red";
		mensaje = "APAGADO";
		nombre1 = "Encender";
		nombre2 = "Acelerar";
	}
	
	/**
	 * @brief Función que realiza los cambios de color,
	 * 			cambios en las etiquetas de los botónes y
	 *  		en el texto que se muestra.
	 * */
	public void pulsarBoton(){
		
		System.out.println(" +------Se ha pulsado el botón.");
		
		if( color.equals("red") ){
			color   = "blue";
			mensaje = "ACELERANDO";
			nombre1 = "Apagar";
			
		}
		else{
			color   = "red";
			mensaje = "APAGADO";
			nombre1 = "Encender";
		}
	}
	
	// ____________________________________________
	// Métodos set & get.
	// ---------
	// Para el color.
	public String getColor() {
		return color;
	}
	public void setColor(String c) {
		color = c;
	}
	
	// ---------
	// Para el mensaje superior.
	public String getMensaje(){
		return mensaje;
	}
	public void setMessage(String m){
		mensaje = m;
	}
	
	// ---------
	// Para el nombre del botón de la izquierda.
	public String getNombre1(){
		return nombre1;
	}
	public void setNombre1(String n){
		nombre1 = n;
	}
	
	// --------
	// Para el nombre del botón de la derecha.
	public String getNombre2(){
		return nombre2;
	}
	public void setNombre2(String n){
		nombre2 = n;
	}
		
	

}
