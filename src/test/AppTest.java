package test;



import static org.junit.jupiter.api.Assertions.*;


import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;


@DisplayName("Clase de testing")

class AppTest {
	
	private ClienteServicio clienteServicio = new ClienteServicio();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
	private ExportadorCsv exportadorCsv = new ExportadorCsv();
	private ExportadorTxt exportadorTxt = new ExportadorTxt();
	private static Logger logger = Logger.getLogger("test.AppTest");
	
	/*Método agrearClienteTest para verificar el funcionamiento de agregarCliente
	(se debe agregar un cliente para que el test corra de manera correcta)*/
	@Test
	public void agregarClienteTest() {
		logger.info("********Test agregar cliente*******");
		int retornoAgregarCliente = clienteServicio.agregarCliente("123456", "brayan", "killer", 20);
		assertEquals(1, retornoAgregarCliente);
	}
	

	
	@Test
	public void agregarClienteNullTest() {
		logger.info("****Test agregar cliente null****");
		int retornoAgregarCliente = clienteServicio.agregarCliente(null,null,null,0);
		assertEquals(0, retornoAgregarCliente);
	}
	
	
	//cargarDatos, archivo servicio
	
	@Test 
	public void cargarDatosTest() {
		logger.info("*******Test cargar datos*********");
		//HAY QUE ARREGLAR LA RUTA, AGREGARLE LO QUE FALTA CONCATENANDOLO
		int retornoCargarDatos = archivoServicio.cargarDatos("src/DBClientes.csv", clienteServicio.getListaClientes());
		assertEquals(1, retornoCargarDatos); //-2
	}
	
	@Test
	public void exportarDatosCsvTest() {
		logger.info("*******Test exportar datos .csv*******");
		int retornoCargarDatos = archivoServicio.cargarDatos("src/DBClientes.csv", clienteServicio.getListaClientes());
		if(retornoCargarDatos == 1) {
			int retornoExportarDatosCsv = exportadorCsv.exportar("src", clienteServicio.getListaClientes());
			//LA LISTA ESTA VACIA, EL PROBLEMA ES OTRO
			
			assertEquals(1, retornoExportarDatosCsv);
		}else {
			logger.info("Ocurrio un error al testear el metodo exportar .csv");
		}

	}
	
	@Test 
	public void exportarDatosTxtTest() {
		logger.info("*******Test exportar datos .txt*******");
		int retornoCargarDatos = archivoServicio.cargarDatos("src/DBClientes.csv", clienteServicio.getListaClientes());
		if(retornoCargarDatos == 1) {
			int retornoExportarDatosTxt = exportadorTxt.exportar("src", clienteServicio.getListaClientes());
			//LA LISTA ESTA VACIA, EL PROBLEMA ES OTRO
			assertEquals(1, retornoExportarDatosTxt);
		}else {
			logger.info("Ocurrio un error al testear el metodo exportar .txt");
		}
	}

	
	@BeforeAll
	static void init() {
		logger.info("------------INICIO DEL TEST------------");
	}
	
	@AfterAll
	static void end() {
		logger.info("--------------FIN DEL TEST--------------");
	}

}
