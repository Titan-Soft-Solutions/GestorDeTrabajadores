package dominio;

public class Trabajador {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private String tipoContrato;
	private String sueldo;
	private String numSegSocial;
	private String numCuenta;

	public Trabajador() {
	}

	public Trabajador(String dni, String nombre, String apellidos, String telefono, String email, String tipoContrato, String sueldo, String numSegSocial, String numCuenta) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.tipoContrato = tipoContrato;
		this.sueldo = sueldo;
		this.numSegSocial = numSegSocial;
		this.numCuenta = numCuenta;
	}

	public String getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public String getTipoContrato() {
		return this.tipoContrato;
	}

	public String getSueldo() {
		return this.sueldo;
	}

	public String getNumSegSocial() {
		return this.numSegSocial;
	}

	public String getNumCuenta() {
		return this.numCuenta;
	}


	public void setDni(String DNI) {
		this.dni = DNI;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setTipoContrato(String tipo) {
		this.tipoContrato = tipo;
	}


	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}


	public void setNumSegSocial(String numSocial) {
		this.numSegSocial = numSocial;
	}


	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

}
