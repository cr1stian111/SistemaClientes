package modelo;

//import 

public class Cliente {
	/*
	 * String runCliente
	 String nombreCliente
	 String apellidoCliente
	 String aniosCliente (se puede cambiar a int si lo desea)
	 CategoriaEnum nombreCategoria
	 Generar el constructor con parámetros
	 Generar los getter y setter correspondientes
	 Generar el toString para los parámetros

	 * */
	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private int aniosCliente;
	private CategoriaEnum nombreCategoria;
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente) {
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria.ACTIVO;
		//this.nombreCategoria = nombreCategoria;
	}
	public String getRunCliente() {
		return runCliente;
	}
	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public int getAniosCliente() {
		return aniosCliente;
	}
	public void setAniosCliente(int aniosCliente) {
		this.aniosCliente = aniosCliente;
	}
	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	@Override
	public String toString() {
		String retorno = "\n-------------Datos del Cliente-------------\nRun del Cliente: " + runCliente + "\nNombre del Cliente: " + nombreCliente + "\nApellido del Cliente: "
				+ apellidoCliente + "\nAños como Cliente: " + aniosCliente + "\nCategoria del Cliente: " + nombreCategoria + "\n-------------------------------------------";
		//QUITARLE EL FORMATO
		return retorno;
	}
	
	
	
}
