package dominio;


public class Gestion {
	
	private GestionAdd gesAdd;
	private GestionDelete gesDelete;
	private GestionSearch gesSearch;
	private GestionModify gesModify;
	
	public Gestion() throws Exception{
		gesAdd = new GestionAdd();
		gesDelete = new GestionDelete();
		gesSearch = new GestionSearch();
		gesModify = new GestionModify();
	}
	
	public int CrearTrabajador(String dni, String nombre, String apellidos, String telefono, String email, String tipoContrato, String sueldo, String numSegSocial, String numCuenta) throws Exception{		
		return gesAdd.CrearTrabajador(dni, nombre, apellidos, telefono, email, tipoContrato, sueldo, numSegSocial, numCuenta );		
	}
	
	public int BorrarTrabajador(String dni) throws Exception{
		return gesDelete.BorrarTrabajador(dni);
	}
	
	public String[] BuscarTrabajador(String dni) throws Exception{
		return gesSearch.BuscarTrabajador(dni);
	}
	
	public int ModificarTrabajador(String dni, String nombre, String apellidos, String telefono, String email, String tipoContrato, String sueldo, String numSegSocial, String numCuenta) throws Exception{		
		return gesModify.ModificarTrabajador(dni, nombre, apellidos, telefono, email, tipoContrato, sueldo, numSegSocial, numCuenta );		
	}

}
