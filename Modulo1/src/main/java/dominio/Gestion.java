package dominio;

import dominio.GestionAdd;

public class Gestion {
	
	private GestionAdd gesAdd;
	
	public Gestion() throws Exception{
		gesAdd = new GestionAdd();
	}
	
	public int CrearTrabajador(String dni, String nombre, String apellidos, String telefono, String email, String tipoContrato, String sueldo, String numSegSocial, String numCuenta) throws Exception{
		
		return gesAdd.CrearTrabajador(dni, nombre, apellidos, telefono, email, tipoContrato, sueldo, numSegSocial, numCuenta );
		
	}

}
