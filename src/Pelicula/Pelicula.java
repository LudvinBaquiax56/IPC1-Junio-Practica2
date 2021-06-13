package src.Pelicula;

public class Pelicula {

	private int id;
	private String nombre;
	private int anio;
	private String categoria;
	private boolean disponible;

	public Pelicula (int id, String nombre, int anio, String categoria, boolean disponible){
		this.id = id;
		this.nombre = nombre;
		this.anio = anio;
		this.categoria = categoria;
		this.disponible = disponible; 
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public int getAnio(){
		return anio;
	}

	public void setAnio(int anio){
		this.anio = anio;
	}

	public String getCategoria(){
		return categoria;
	}

	public void setCategoria(String categoria){
		this.categoria = categoria;
	}

	public boolean getDisponible(){
		return disponible;
	}

	public void setDisponible(boolean disponible){
		this.disponible = disponible;
	}

	public void cambiarEstado(){
		this.disponible = (!disponible);
	}

	public String mostrarDatos(){
		return id + "--" + nombre + "--" + anio + "--" + categoria + "--" + disponible;
	}
}