package dominio;

public class GestionAdd {
	
	private Trabajador t;
	private TrabajadorDAO tdao;
	
	public GestionAdd() throws Exception{
		tdao = TrabajadorDAO.getTrabajadorDAO();
	}
	
	public int CrearTrabajador(String dni, String nombre, String apellidos, String telefono, String email, String tipoContrato, String sueldo, String numSegSocial, String numCuenta) throws Exception{
		t = new Trabajador(dni, nombre, apellidos, telefono, email, tipoContrato, sueldo, numSegSocial, numCuenta);		
		return tdao.Create(t);
	}

}
