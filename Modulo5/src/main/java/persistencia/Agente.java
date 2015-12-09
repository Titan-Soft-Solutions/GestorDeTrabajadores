package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

//import org.hsqldb.Statement;

public class Agente {

    //instancia del agente
    protected static Agente mInstancia = null;

    private Connection conn;
    private Statement st;

    //Constructor
    public static Agente getAgente() throws Exception {
        if (mInstancia == null) {
            mInstancia = new Agente();
        }
        return mInstancia;
    }
    private Agente() throws Exception{
    	conectar();
    }
    
    //Metodo para realizar la conexion a la base de datos 
    private void conectar() throws Exception {
    	String driver = "jdbc:ucanaccess://";
    	String bbdd = "bbdd.mdb";
    	conn=DriverManager.getConnection(driver+bbdd);
    }

    
    //Metodo para desconectar de la base de datos
    public void desconectar() throws Exception{
    	conn.close();
    }
    
    //Metodo para realizar una insercion en la base de datos
    public int insert(String SQL) throws Exception{
    	st = conn.createStatement();
    	return st.executeUpdate(SQL);
    }

    //Metodo para realizar una eliminacion en la base de datos
    public int delete(String SQL) throws Exception{
    	st = conn.createStatement();    	
    	return st.executeUpdate(SQL);
    }
    
    //Metodo para realizar una actualizacion en la base de datos
    public int update(String SQL) throws Exception{
    	st = conn.createStatement();    	
    	return st.executeUpdate(SQL);
    }
    
    
	public Vector<Object> select(String SQL) throws Exception{
		
		Vector<Object> v = new Vector<Object>();
		int num_col;
		
		st = conn.createStatement();
        ResultSet res = st.executeQuery(SQL);
        num_col = res.getMetaData().getColumnCount();
        
        while(res.next()){
        	Object vec_reg[] = new Object[num_col];
        	for(int i=0;i<num_col;i++){
        		vec_reg[i] = res.getString(i+1);
        	}
        	v.add(vec_reg);        	
        }
            
        return v;            
	}
}