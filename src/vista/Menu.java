package vista;

import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;

public class Menu {
	/*
		 * archivoServicio, instancia de ArchivoServicio.
	 exportadorCsv, instancia de ExportarCsv.
	 exportarTxt, instancia de ExportarTxt.
	 Definir un String fileName = “Clientes” (para exportar el archivo)
	 Definir un String fileName1 = “DBClientes.csv” (para importar el archivo)
	 scanner, instancia de Scanner para recibir valores a través del teclado.
	 iniciarMenu, muestra el menu principal y recibe la entrada del teclado a través
	del scanner. Contiene la lógica para denotar los demás métodos en base a la
	entrada del teclado.
	 * */
	
	private ClienteServicio clienteServicio;
	private ArchivoServicio archivoServicio;
	private ExportadorCsv exportadorCsv;
	//private String fileName = "Clientes";
	private String fileName1 = "DBClientes.csv";
	private Scanner scanner;
	
	
	//con constructor declarador de la parte q le faltan a los atributos y con la aprte q falta declarada en los metodos no funciona
	//le quitare los declaradores locales a los metodos SI FUNCIONA!!
	public Menu() {
		clienteServicio = new ClienteServicio();
		scanner = new Scanner(System.in);
		archivoServicio = new ArchivoServicio();
		exportadorCsv = new  ExportadorCsv();
	}

	public void iniciarMenu() {
		int opcion = 0;
		do {
			//menu principal, usa el scanner
			System.out.println("\n1. Listar Clientes \n2. Agregar Cliente \n3. Editar Cliente \n4. Cargar Datos "
					+ "\n5. Exportar Datos \n6. Salir \nIngrese una opción: ");
			try {
				opcion = Integer.parseInt(scanner.nextLine());
				procesarOpcionesMenu(opcion);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ha ocurrido un error de ingreso.");
			}

		}while(opcion != 6);
	}
	
	public void listarClientes() {	
		//clienteServicio = new ClienteServicio();
		if(clienteServicio.getListaClientes().size()==0) {
			System.out.println("Lista vacia");
		}else {
			clienteServicio.listarClientes();
		}		
	}
	
	public void agregarCliente() {
		System.out.println("-------------Crear Cliente-------------");
		System.out.println("Ingresa RUN del Cliente: ");
		String run = scanner.nextLine();
		System.out.println("Ingresa Nombre del Cliente: ");
		String nombre = scanner.nextLine();
		System.out.println("Ingresa Apellido del Cliente: ");
		String apellido = scanner.nextLine();
		System.out.println("Ingresa años como Cliente: ");
		//int anios = scanner.nextInt();
		int anios = Integer.parseInt(scanner.nextLine());
		int retornoAgregarCliente = clienteServicio.agregarCliente(run, nombre, apellido, anios);
		System.out.println("---------------------------------------");
		if(retornoAgregarCliente == 1) {
			System.out.println("Se ha agregado el cliente correctamente.");
		}
		//scanner.close();
	}
	
	public void editarCliente() {
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("Seleccione qué desea hacer: ");
		System.out.println("1.-Cambiar el estado del Cliente ");
		System.out.println("2.-Editar los datos ingresados del Cliente ");
		System.out.println("Ingrese opcion: ");
		System.out.println("----------------------------------------");
		//int opcion = scanner.nextInt();
		int opcion = Integer.parseInt(scanner.nextLine());
		String run;
		if(opcion != 1 && opcion != 2) {
			System.out.println("Opcion invalida");
		}else if(opcion == 1){
			//cambiar estado
			System.out.println("Ingrese RUN del Cliente a editar: ");
			run = scanner.nextLine(); 
			run = run.replace(" ", "");
			editarEstadoCliente(run);
		}else if(opcion == 2) {
			System.out.println("Ingrese RUN del Cliente a editar: ");
			run = scanner.nextLine();
			run = run.replace(" ", "");
			editarDatosCliente(run);
		}
	}
		
	public void editarEstadoCliente(String run) {
		for(Cliente cliente:clienteServicio.getListaClientes()) {		
			if(cliente.getRunCliente().equals(run)) {	
				if(cliente.getNombreCategoria() == CategoriaEnum.ACTIVO) {
					cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
					System.out.println("El estado del cliente paso a ser: INACTIVO");
				}else {
					cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
					System.out.println("El estado del cliente paso a ser: ACTIVO");
				}
			}
		}
	}
	
	public void editarDatosCliente(String run) {
		for(Cliente cliente:clienteServicio.getListaClientes()) {
			if(cliente.getRunCliente().equals(run)) {
				System.out.println("----Actualizando datos del Cliente-----");
				System.out.println("1.-El RUN del Cliente es: " + cliente.getRunCliente());
				System.out.println("2.-El Nombre del Cliente es: " + cliente.getNombreCliente());
				System.out.println("3.-El Apellido del Cliente es: " + cliente.getApellidoCliente());
				System.out.println("4.-Los años como Cliente son: " + cliente.getAniosCliente());
				System.out.println("Ingrese opcion a editar de los datos del cliente:");
				System.out.println("----------------------------------------");
				int opcion = scanner.nextInt(); 
				opcionesEditarCliente(cliente, opcion);
				break; //este estaba mal ubicado
			}
			
		}
	}
	
	
	public void opcionesEditarCliente(Cliente cliente, int opcion) {
		String respuesta="Datos cambiados con éxito";
		Scanner scanner = new Scanner(System.in); 
		System.out.println("----------------------------------------");
		String nuevo = "";
		switch (opcion) {
		case 1:
			System.out.println("Ingrese el nuevo RUN del cliente: ");
			nuevo = scanner.nextLine();
			cliente.setRunCliente(nuevo);
			break;
		case 2:
			System.out.println("Ingrese el nuevo Nombre del cliente: ");
			nuevo = scanner.nextLine();
			cliente.setNombreCliente(nuevo);
			break;
		case 3:
			System.out.println("Ingrese el nuevo Apellido del cliente: ");
			nuevo = scanner.nextLine();
			cliente.setApellidoCliente(nuevo);
			break;
		case 4:
			System.out.println("Ingrese la nueva cantidad de años como cliente: ");
			int anios = scanner.nextInt();
			cliente.setAniosCliente(anios);
			break;
		default:
			System.out.println("Opcion invalida");
			respuesta = "No se pudieron editar los datos del cliente.";
			break;
		}
		System.out.println("----------------------------------------");
		System.out.println(respuesta);
		//scanner.close();
	}
	
	
	
	public void cargarDatos() {
		String respuesta = "";
		//toma de datos por consola
		System.out.println("---------Cargar Datos en Windows---------------");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo "+fileName1+": (ej: src)");
		//String ruta = "C:/Users/cr/eclipse-workspace/SistemaDeClientes/src/DBClientes.csv"; NO FUNKO
		//String ruta = "src/DBClientes.csv";
		String ruta = scanner.nextLine();
		ruta = ruta + "/" + fileName1;  
		int retorno = archivoServicio.cargarDatos(ruta, clienteServicio.getListaClientes());
		System.out.println("-----------------------------------------------");
		if(retorno == 1) {
			respuesta = "Datos cargados correctamente en la lista";
		}else if(retorno == -1) {
			respuesta = "El archivo indicado no existe en la ruta especificada";
		}else if(retorno == -2) {
			respuesta = "Ocurrio un error al cargar el archivo";
		}else {
			respuesta = "Ocurrio un error inesperado";
		}
		System.out.println(respuesta);
	}
	
	public void exportarDatos() {
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println("Ingrese una opción para exportar:");
		System.out.println("----------------------------------");
		int opcion = Integer.parseInt(scanner.nextLine());
		if(opcion == 1) {
			exportarDatosFormatoEspecifico("csv");
		}else if(opcion == 2) {
			exportarDatosFormatoEspecifico("txt");
		}else {
			System.out.println("Opcion invalida");
		}
	}
	
	
	public void exportarDatosFormatoEspecifico(String formato) {
		System.out.println("---------Exportar Datos en Windows---------------");
		System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes."+formato+" (ej: src):  ");
		//System.out.println("src");
		String ruta = scanner.nextLine();
		int resultado = 0;
		if(formato.equalsIgnoreCase("csv")) {
			resultado = exportadorCsv.exportar(ruta, clienteServicio.getListaClientes());
		}else if(formato.equalsIgnoreCase("txt")) {
			ExportadorTxt exportadorTxt = new ExportadorTxt();
			resultado = exportadorTxt.exportar(ruta, clienteServicio.getListaClientes());
		}
		System.out.println("-----------------------------------------------");
		if(resultado == 1) {
			System.out.println("Datos de clientes exportados correctamente en formato ."+formato);
		}else if(resultado == -1) {
			System.out.println("Ocurrio un error al exportar el archivo ."+formato);
		}else if(resultado == -2) {
			System.out.println("No hay clientes que exportar");
		}else {
			System.out.println("Ocurrio un error inesperado al exportar el archivo ." +formato);
		}
	}
	
	public void terminarPrograma() {
		System.out.println("  Saliendo... \n");
		System.out.println("--Programa finalizado--");
	}
	
	public  void procesarOpcionesMenu(int opcion) {
				switch (opcion) {
				case 1:
					listarClientes();
					break;
				case 2:
					agregarCliente();
					break;
				case 3:
					editarCliente();
					break;
				case 4:
					cargarDatos();
					break;
				case 5:
					exportarDatos();
					break;
				case 6:
					terminarPrograma();
					break;
				default:
					System.out.println("Opcion invalida. Por favor ingrese una opcion del 1 al 6");
					break;
				}			
	}
}
