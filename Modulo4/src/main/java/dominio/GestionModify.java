package dominio;

public class GestionModify {
	
	private Trabajador t;
	private TrabajadorDAO tdao;
	
	public GestionModify() throws Exception{
		tdao = TrabajadorDAO.getTrabajadorDAO();
	}
	
	public int ModificarTrabajador(String dni, String nombre, String apellidos, String telefono, String email, String tipoContrato, String sueldo, String numSegSocial, String numCuenta) throws Exception{
		t = new Trabajador(dni, nombre, apellidos, telefono, email, tipoContrato, sueldo, numSegSocial, numCuenta);		
		return tdao.Update(t);
	}

}
