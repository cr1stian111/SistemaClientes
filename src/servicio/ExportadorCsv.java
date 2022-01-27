package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import modelo.Cliente;

public class ExportadorCsv extends Exportador{


	/*Crear una clase ExportadorCsv en el package servicio, que contenga un método
	exportar, cuyos parámetros serán String fileName y una List<Cliente> listaClientes.
	Se deben realizar las implementaciones correspondientes al interior del método
	usando PrintWriter y Filewriter para la exportación de archivos.*/
	@Override
	public int exportar(String fileName, List<Cliente> listaClientes) {
		int resultado = 0; 
		//File archivo = new File("src/"+nombreDirectorio+"/"+nombreFichero+".txt");
		if(listaClientes.size()>0) {
			try {
				File archivo = new File(fileName + "/clientes.csv"); 
				archivo.createNewFile();
				FileWriter fileWrite=new FileWriter(archivo);
				BufferedWriter bufferedWrite=new BufferedWriter(fileWrite);
				
				for(Cliente cliente:listaClientes) {
					String texto = cliente.toString();
					bufferedWrite.write(texto);
					bufferedWrite.newLine();
				}
				bufferedWrite.close();
				resultado = 1;
			} catch (Exception e) {
				resultado = -1;
				e.printStackTrace();
			}
		}else {
			resultado = -2;
		}
		return resultado;
	}
	
}
