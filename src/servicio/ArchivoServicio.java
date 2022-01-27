package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//AGREGADO
import java.util.List;


import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Exportador{

	@Override
	public int exportar(String fileName, List<Cliente> listaClientes) {
		return 0;
		// TODO Auto-generated method stub
	}
	
	
	/*
	 * Crear el método cargarDatos que recibe por parámetro un String fileName, el
	 * cual indica el nombre del archivo a cargar. Se deben realizar las
	 * implementaciones correspondientes al interior del método usando FileReader
	 * y BufferedReader (para lectura de archivos).
	 * retorna:
	 * 0: No hace nada
	 * 1: Carga correctamente
	 *-1: Error archivo no existe
	 *-2: Error al cargar 
	*/
	public int cargarDatos(String ruta, List<Cliente> list) { //nombre del archivo a cargar, LE AGREGUE LA LISTA XQ SINO NO GUARDA 
		int respuesta=0;
		//logica de la carga
		try {
			File archivo = new File(ruta);
			if (archivo.exists()) { //si existe procedemos a cargarlo
				FileReader fileReader = new FileReader(archivo);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String linea = bufferedReader.readLine(); //lectura del archivo
				while (linea != null) {
					String[] arreglo = linea.split(",");
					//Producto producto = new Producto(arreglo[0], arreglo[1], arreglo[2], arreglo[3], arreglo[4],arreglo[5], arreglo[6]);
					 String rut = arreglo[0].replace(" ", "");
					 int anios = Integer.parseInt(arreglo[3].replace(" ", ""));
					 //CategoriaEnum categoria = (Enum) arreglo[4];
					 CategoriaEnum categoria = CategoriaEnum.valueOf(arreglo[4].toUpperCase().replace(" ", ""));
					 //arreglo[4]
					
					Cliente cliente = new Cliente(rut, arreglo[1].replace(" ", ""), arreglo[2].replace(" ", ""), anios);
					cliente.setNombreCategoria(categoria);
					list.add(cliente);
					linea = bufferedReader.readLine();
				}
				bufferedReader.close();
				respuesta = 1;
			} else {	
				respuesta = -1; //archivo no existe
			}
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = -2;
		}
		return respuesta;
	}

}
