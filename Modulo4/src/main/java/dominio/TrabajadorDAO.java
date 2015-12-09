package dominio;

import java.util.Vector;

import persistencia.Agente;

public class TrabajadorDAO {
	
	protected static TrabajadorDAO mInstancia = null;
	private Agente a;
	
	public static TrabajadorDAO getTrabajadorDAO() throws Exception {
        if (mInstancia == null) {
            mInstancia = new TrabajadorDAO();
        }
        return mInstancia;
    }
	
	public int Create(Trabajador t) throws Exception{
		String SQL_Consulta;
		boolean insertar=true;
		Vector<Object> res;	
		int r=0;
        a = Agente.getAgente();
  
        SQL_Consulta = "SELECT DNI FROM Trabajador WHERE DNI = '"+t.getDni()+"';";
        res = a.select(SQL_Consulta);
        if(!res.isEmpty()){
        	r += 2;
        	insertar=false;
        }
        
        SQL_Consulta = "SELECT NumSegSocial FROM Trabajador WHERE NumSegSocial = '"+t.getNumSegSocial()+"';";
        res = a.select(SQL_Consulta);
        if(!res.isEmpty()){
        	r += 3;
        	insertar=false;
        }
        
        SQL_Consulta = "SELECT NumCuenta FROM Trabajador WHERE NumCuenta = '"+t.getNumCuenta()+"';";
        res = a.select(SQL_Consulta);
        if(!res.isEmpty()){
        	r += 4;
        	insertar=false;
        }
        
        if (insertar){
            SQL_Consulta = "INSERT INTO Trabajador(DNI, Nombre, Apellidos, Telefono, Email, TipoContrato, Sueldo, NumSegSocial, NumCuenta)"
            		+ " VALUES('"+t.getDni()+ "','" +t.getNombre()+ "','" +t.getApellidos()+ "','" +t.getTelefono()+ "','" +t.getEmail()+ "','" +t.getTipoContrato()+ "','" +t.getSueldo()+ "','" +t.getNumSegSocial()+ "','" +t.getNumCuenta()+ "');";           
            r = a.insert(SQL_Consulta);    
        }
        
		
		return r;
	}
	
	public int Detele(Trabajador t) throws Exception{
		int r=0;
		Vector<Object> res;	
		a = Agente.getAgente();
		boolean borrar=true;
		
		String SQL_Consulta = "SELECT DNI FROM Trabajador WHERE DNI = '"+t.getDni()+"';";
        res = a.select(SQL_Consulta);
        if(res.isEmpty()){
        	r = 2;
        	borrar=false;
        }
		
        if(borrar){
        	String SQL_Delete = "DELETE FROM Trabajador WHERE DNI = '"+t.getDni()+"'";
    		r = a.delete(SQL_Delete);
        }
		
		return r;
	}
	
	public Trabajador Read(Trabajador t) throws Exception{
		Trabajador t_encontrado = null;		
		String SQL_Consulta;
		Vector<Object> res;	
        a = Agente.getAgente();
  
        SQL_Consulta = "SELECT DNI, Nombre, Apellidos, Telefono, Email, TipoContrato, Sueldo, NumSegSocial, NumCuenta FROM Trabajador WHERE DNI = '"+t.getDni()+"';";
        res = a.select(SQL_Consulta);
        if(!res.isEmpty()){
        	Object vec_reg[] = (Object[]) res.remove(0);
        	t_encontrado = new Trabajador(vec_reg[0].toString(), vec_reg[1].toString(), vec_reg[2].toString(), vec_reg[3].toString(), vec_reg[4].toString(), 
        			vec_reg[5].toString(), vec_reg[6].toString(), vec_reg[7].toString(), vec_reg[8].toString());
        }
		
		return t_encontrado;
	}
	
	public int Update(Trabajador t) throws Exception{
		int r=0;
		Vector<Object> res;
		String SQL_Consulta, SQL_UPDATE;
		a = Agente.getAgente();
        boolean act=true;
        
        SQL_Consulta = "SELECT NumSegSocial FROM Trabajador WHERE NumSegSocial = '"+t.getNumSegSocial()+"' AND NOT DNI = '"+t.getDni()+"';";
        res = a.select(SQL_Consulta);
        if(!res.isEmpty()){
        	r += 2;
        	act=false;
        }
        
        SQL_Consulta = "SELECT NumCuenta FROM Trabajador WHERE NumCuenta = '"+t.getNumCuenta()+"' AND NOT DNI = '"+t.getDni()+"';";
        res = a.select(SQL_Consulta);
        if(!res.isEmpty()){
        	r += 3;
        	act=false;
        }
		
        if(act){
        	SQL_UPDATE = "UPDATE Trabajador SET Nombre = '"+t.getNombre()+"', Apellidos = '"+t.getApellidos()+"', "
    				+ "Telefono = '"+t.getTelefono()+"', Email = '"+t.getEmail()+"', TipoContrato = '"+t.getTipoContrato()+"'"
    						+ ", Sueldo = '"+t.getSueldo()+"', NumSegSocial = '"+t.getNumSegSocial()+"', NumCuenta = '"+t.getNumCuenta()+"' WHERE DNI = '"+t.getDni()+"'";
    		r = a.update(SQL_UPDATE);
        }
		
		return r;
	}

}
