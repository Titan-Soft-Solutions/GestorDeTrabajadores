package dominio;

public class GestionSearch {
	
	private Trabajador t;
	private TrabajadorDAO tdao;
	
	public GestionSearch() throws Exception{
		tdao = TrabajadorDAO.getTrabajadorDAO();
	}
	
	public String[] BuscarTrabajador(String dni) throws Exception{
		t = new Trabajador();	
		t.setDni(dni);
		String[] t_aux=null;
		
		t = tdao.Read(t);
		if(t!=null){
			t_aux = new String[9];
			t_aux[0] = t.getDni();
			t_aux[1] = t.getNombre();
			t_aux[2] = t.getApellidos();
			t_aux[3] = t.getTelefono();
			t_aux[4] = t.getEmail();
			t_aux[5] = t.getTipoContrato();
			t_aux[6] = t.getSueldo();
			t_aux[7] = t.getNumSegSocial();
			t_aux[8] = t.getNumCuenta();
		}		
				
		return t_aux;
	}

}
