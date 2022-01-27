package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {
	private List<Cliente> listaClientes;

	public ClienteServicio() {

		this.listaClientes = new ArrayList<Cliente>();
	}
	
	public void listarClientes() {
		//recorrer c/u de los clientes
		for(Cliente cliente:listaClientes) {
			System.out.println(cliente.toString());
		}
	}
	
	/*metodo que permite agregar un cliente a la lista
	 * retorna 1 si se agrega correctamente el cliente sino retorna 0*/
	public int agregarCliente(String run, String nombre, String apellido, int anios) {
		int respuesta=0;
		int tamanoAnterior = listaClientes.size();
		if(run != null && nombre != null && apellido != null ) {
			Cliente cliente = new Cliente(run, nombre, apellido, anios);
			listaClientes.add(cliente);
			int tamanoPosterior = listaClientes.size();
			respuesta = tamanoPosterior - tamanoAnterior;
		}
		return respuesta;
	}
	
	/*Generar un public void del método editarCliente y pasarle los parámetros de la clase Cliente.*/
	public void editarCliente(String run, String nombre, String apellido, String anios, CategoriaEnum nombreCat) {
		//
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	
}
