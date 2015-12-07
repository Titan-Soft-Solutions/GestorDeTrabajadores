package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import dominio.Gestion;
import java.awt.event.WindowAdapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JLabel;



public class IUAdd {

	private JFrame frame;
	private JTextPane tp_dni;
	private JTextPane tp_nombre;
	private JTextPane tp_apellidos;
	private JTextPane tp_telefono;
	private JTextPane tp_email;
	private Gestion ges;
	private JTextPane tp_sueldo;
	private JTextPane tp_numSegSocial;
	private JTextPane tp_numCuenta;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblTelfono;
	private JLabel lblEmail;
	private JLabel lblTipoContrato;
	private JLabel lblSueldo;
	private JLabel lblNSegSocial;
	private JLabel lblNCuentaBancaria;
	private JTextPane tp_tipoContrato;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IUAdd window = new IUAdd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public IUAdd() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		//Se carga el fichero
		ges = new Gestion();
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
		});
		frame.setBounds(100, 100, 355, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		tp_dni = new JTextPane();
		tp_dni.setText("05934465G");
		tp_dni.setBounds(125, 11, 204, 20);
		panel.add(tp_dni);
		
		tp_nombre = new JTextPane();
		tp_nombre.setText("dsfdsf");
		tp_nombre.setBounds(125, 42, 204, 20);
		panel.add(tp_nombre);
		
		tp_apellidos = new JTextPane();
		tp_apellidos.setText("sdfsdf");
		tp_apellidos.setBounds(125, 73, 204, 20);
		panel.add(tp_apellidos);
		
		tp_telefono = new JTextPane();
		tp_telefono.setText("652358749");
		tp_telefono.setBounds(125, 104, 204, 20);
		panel.add(tp_telefono);
		
		tp_email = new JTextPane();
		tp_email.setText("sdfdsf@sdfsdf.com");
		tp_email.setBounds(125, 137, 204, 20);
		panel.add(tp_email);
		
		tp_sueldo = new JTextPane();
		tp_sueldo.setBounds(125, 203, 204, 20);
		panel.add(tp_sueldo);
		
		tp_numSegSocial = new JTextPane();
		tp_numSegSocial.setText("12345678912345678912");
		tp_numSegSocial.setBounds(125, 236, 204, 20);
		panel.add(tp_numSegSocial);
		
		tp_numCuenta = new JTextPane();
		tp_numCuenta.setText("12345678912345678912");
		tp_numCuenta.setBounds(125, 269, 204, 20);
		panel.add(tp_numCuenta);
		
		JButton button = new JButton("A\u00F1adir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni="";
				String nombre="";
				String apellidos="";
				String telefono="";
				String email="";
				String tipoContrato = "";
				String sueldo = "";
				String numSegSocial = "";
				String numCuenta = "";
				boolean error=false;
				int res;
				
				error = ComprobarNulos();
				if(!error)error = ComprobarFormatos();
				
				if(!error){
					try{
						float aux = Float.valueOf(tp_sueldo.getText());
						if(aux<648.60){
							error=true;
							JOptionPane.showMessageDialog(null, "El sueldo debe ser mayor que el salario minimo interprofesional");
						}
					}
					catch(NumberFormatException e){
						JOptionPane.showMessageDialog(null, "El sueldo debe ser un numero con puntos, no comas");					
					}
				}
				
				
				if(!error){
					dni = tp_dni.getText();
					nombre = tp_nombre.getText();
					apellidos = tp_apellidos.getText();
					telefono = tp_telefono.getText();
					email = tp_email.getText();
					tipoContrato = tp_tipoContrato.getText();
					sueldo = tp_sueldo.getText();
					numSegSocial = tp_numSegSocial.getText();
					numCuenta = tp_numCuenta.getText();
					try {
						res = ges.CrearTrabajador(dni, nombre, apellidos, telefono, email, tipoContrato, sueldo, numSegSocial, numCuenta);
						/*
						 CODIGOS DE RESPUESTA
						 1 - SE HA INSERTADO CORRECTAMENTE
						 0 - NO SE HA PODIDO INSERTAR EL TRABAJADOR
						 2 - EL DNI INSERTADO YA EXISTE
						 3 - EL NUMERO DE LA SEGURIDAD SOCIAL INSERTADO YA EXISTE
						 4 - EL NUMERO DE CUENTA BANCARIA YA EXISTE
						*/
						switch(res){
							case 0:
								JOptionPane.showMessageDialog(null, "No se ha podido insertar el trabajador");
								break;
							case 1:
								JOptionPane.showMessageDialog(null, "Se ha insertado el trabajador correctamente");
								break;
							case 2:
								JOptionPane.showMessageDialog(null, "El Dni introducido ya existe. Inserte uno diferente");
								break;
							case 3:
								JOptionPane.showMessageDialog(null, "El numero de la seguridad social introducido ya existe. Inserte uno diferente");
								break;
							case 4:
								JOptionPane.showMessageDialog(null, "El numero de la cuenta bancaria introducido ya existe. Inserte uno diferente");
								break;
							case 5:
								JOptionPane.showMessageDialog(null, "El dni y el numero de la seguridad introducidos ya existen. Inserte unos diferentes");
								break;
							case 6:
								JOptionPane.showMessageDialog(null, "El dni y el numero de la cuenta bancaria introducidos ya existen. Inserte unos diferentes");
								break;
							case 7:
								JOptionPane.showMessageDialog(null, "El numero de la seguridad social y el numero de la cuenta bancaria introducidos ya existen. Inserte unos diferentes");
								break;
							case 9:
								JOptionPane.showMessageDialog(null, "El dni, el numero de la seguridad social y el numero de la cuenta bancaria introducidos ya existen. Inserte unos diferentes");
								break;
						}
					} catch (HeadlessException e) {
						JOptionPane.showMessageDialog(null, e.toString());
						e.printStackTrace();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.toString());
						e.printStackTrace();
					}
				}				
			}
		});
		button.setBounds(127, 316, 89, 23);
		panel.add(button);
		{
			lblDni = new JLabel("DNI");
			lblDni.setBounds(10, 11, 105, 20);
			panel.add(lblDni);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(10, 42, 105, 20);
			panel.add(lblNombre);
		}
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 73, 105, 20);
		panel.add(lblApellidos);
		
		lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(10, 104, 105, 20);
		panel.add(lblTelfono);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 137, 105, 20);
		panel.add(lblEmail);
		
		lblTipoContrato = new JLabel("Tipo Contrato");
		lblTipoContrato.setBounds(10, 172, 105, 20);
		panel.add(lblTipoContrato);
		
		lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(10, 203, 105, 20);
		panel.add(lblSueldo);
		
		lblNSegSocial = new JLabel("N. Seg. Social");
		lblNSegSocial.setBounds(10, 236, 105, 20);
		panel.add(lblNSegSocial);
		
		lblNCuentaBancaria = new JLabel("N. Cuenta Banc.");
		lblNCuentaBancaria.setBounds(10, 269, 105, 20);
		panel.add(lblNCuentaBancaria);
		{
			tp_tipoContrato = new JTextPane();
			tp_tipoContrato.setBounds(125, 168, 204, 20);
			panel.add(tp_tipoContrato);
		}

	}
	
	private boolean ComprobarNulos(){
		boolean campoNulo = false;
		
		if(tp_dni.getText().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "No has introducido el dni");
			campoNulo=true;
		}
		if(tp_nombre.getText().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "No has introducido el nombre");
			campoNulo=true;
		}
		if(tp_apellidos.getText().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "No has introducido los apellidos");
			campoNulo=true;
		}
		if(tp_telefono.getText().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "No has introducido el teléfono");
			campoNulo=true;
		}
		if(tp_email.getText().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "No has introducido el email");
			campoNulo=true;
		}
		if(tp_sueldo.getText().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "No has introducido el sueldo");
			campoNulo=true;
		}
		if(tp_numSegSocial.getText().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "No has introducido el número de la seguridad social");
			campoNulo=true;
		}
		if(tp_numCuenta.getText().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "No has introducido el número de cuenta");
			campoNulo=true;
		}		
		
		return campoNulo;
	}
	
	private boolean ComprobarFormatos() {
		boolean malFormato=false;
		
		String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";		
		String PATTERN_DNI = "^(\\d{8})([-]?)([A-Z]{1})";		
		String PATTERN_TELEFONO = "^[6]\\d{8}";		
		String PATTERN_NUMSEGSOCIAL = "^\\d{12}";		
		String PATTERN_NUMCUENTA = "^\\d{20}";
		
		if(!validar(tp_dni.getText(),PATTERN_DNI)){
			JOptionPane.showMessageDialog(null, "Has introducido mal el dni");
			malFormato=true;
		}
		if(!validar(tp_telefono.getText(),PATTERN_TELEFONO)){
			JOptionPane.showMessageDialog(null, "Has introducido mal el teléfono");
			malFormato=true;
		}
		if(!validar(tp_email.getText(),PATTERN_EMAIL)){
			JOptionPane.showMessageDialog(null, "Has introducido mal el email");
			malFormato=true;
		}
		if(!validar(tp_numSegSocial.getText(),PATTERN_NUMSEGSOCIAL)){
			JOptionPane.showMessageDialog(null, "Has introducido mal el número de la seguridad social");
			malFormato=true;
		}
		if(!validar(tp_numCuenta.getText(),PATTERN_NUMCUENTA)){
			JOptionPane.showMessageDialog(null, "Has introducido mal el número de cuenta");
			malFormato=true;
		}
		
		return malFormato;
	}
    private boolean validar(String campo, String PATTERN) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(campo);
        return matcher.matches();
 
    }
}
