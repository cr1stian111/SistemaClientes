package servicio;

import java.util.List;

import modelo.Cliente;

public abstract class Exportador {
	
	/*los métodos declarados serán
	pertenecientes a cada Exportador bajo el concepto de herencia. Al utilizarlo, se
	instancia alguno de los exportadores en la clase menu ocupando polimorfismo.*/
	
	public abstract int exportar(String fileName, List<Cliente> listaClientes);
}
