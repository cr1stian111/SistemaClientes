package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador{
	/*Se deben realizar las implementaciones correspondientes al interior del método
	usando PrintWriter y Filewriter para exportación de archivos*/
	

	@Override
	public int exportar(String fileName, List<Cliente> listaClientes) {
		int resultado = 0;
		if(listaClientes.size()>0) {
			File archivo = new File(fileName + "/clientes.txt");  	
			try {
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
				e.printStackTrace();
				resultado = -1;
			}
		}else {
			resultado = -2;
		}
		return resultado;
	
	}

}
