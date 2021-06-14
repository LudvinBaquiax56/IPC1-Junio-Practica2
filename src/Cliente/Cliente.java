package src.Cliente;

public class Cliente {

	private String nombre;
	private int id;
	private int telefono;
	private boolean tienePrestado;

	public Cliente (String nombre, int id, int telefono, boolean tienePrestado){
		this.nombre = nombre;
		this.id = id;
		this.telefono = telefono;
		this.tienePrestado = tienePrestado; 
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getTelefono(){
		return telefono;
	}

	public void setTelefono(int telefono){
		this.telefono = telefono;
	}

	public boolean getTienePrestado(){
		return tienePrestado;
	}

	public void setTienePrestado(boolean tienePrestado){
		this.tienePrestado = tienePrestado;
	}

	public void cambiarEstado(){
		this.tienePrestado = (!tienePrestado);
	}

	public String disponibilidad(){
		if (tienePrestado) {
			return "Sin prestamo";
		} else {
			return "Con prestamo activo";
		}
	}
	public String mostrarDatos(){
		return nombre + "--" + id + "--" + telefono + "--" + disponibilidad();
	}
}