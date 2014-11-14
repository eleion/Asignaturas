package prueba;

public class Cliente {
	// Atributos.
	private GestorFiltros gestorFiltros;
	
	// Métodos.
	
	/**
	 * Inicializa un gestor de filtros.
	 * */
	Cliente(){
		this.gestorFiltros = new GestorFiltros();
	}
	
	/**
	 * Asigna un neuvo gestor de filtros pasado por parámetro.
	 * @param gestorFiltros: Nuevo gestor de filtros.
	 * */
	public void setGestorFiltros(GestorFiltros gestorFiltros) {
		this.gestorFiltros = gestorFiltros;
	}
	
	/**
	 * Envia la petición al gestor de filtros.
	 * */
	public void enviarPeticion(double n){
		// Que ejecute los filtros.
		gestorFiltros.ejecutar(n);
	}
	
}

