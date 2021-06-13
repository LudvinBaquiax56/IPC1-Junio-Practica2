package src.Prestamo;

public class Prestamo {

	private int idPelicula;
	private int idCliente;
	private int diasPrestamo;

	public Prestamo (int idPelicula, int idCliente, int diasPrestamo){
		this.idPelicula = idPelicula;
		this.idCliente = idCliente;
		this.diasPrestamo = diasPrestamo; 
	}

	public int getIdPelicula(){
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula){
		this.idPelicula = idPelicula;
	}

	public int getIdCliente(){
		return idCliente;
	}

	public void setIdCliente(int idCliente){
		this.idCliente = idCliente;
	}

	public int getDiasPrestamo(){
		return diasPrestamo;
	}

	public void setDiasPrestamo(int diasPrestamo){
		this.diasPrestamo = diasPrestamo;
	}

	public String mostrarDatos(){
		return idPelicula + "--" + idCliente + "--" + diasPrestamo;
	}
}