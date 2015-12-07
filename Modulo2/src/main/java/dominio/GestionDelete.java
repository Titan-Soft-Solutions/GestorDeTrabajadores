package dominio;

public class GestionDelete {
	
	private Trabajador t;
	private TrabajadorDAO tdao;
	
	public GestionDelete() throws Exception{
		tdao = TrabajadorDAO.getTrabajadorDAO();
	}
	
	public int BorrarTrabajador(String dni) throws Exception{
		t = new Trabajador();	
		t.setDni(dni);
		return tdao.Detele(t);
	}

}
