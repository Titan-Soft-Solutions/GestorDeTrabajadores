package presentacion;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextPane;

import dominio.Gestion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;

public class IUModify {

	private JFrame frmModificarTrabajador;
	private Gestion ges;
	private JTextPane tp_dni;
	private JTextPane tp_numCuenta;
	private JTextPane tp_numSegSocial;
	private JTextPane tp_sueldo;
	private JTextPane tp_tipoContrato;
	private JTextPane tp_email;
	private JTextPane tp_telefono;
	private JTextPane tp_apellidos;
	private JTextPane tp_nombre;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JButton btnActualizar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IUModify window = new IUModify();
					window.frmModificarTrabajador.setVisible(true);
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
	public IUModify() throws Exception {
		initialize();
	}
	
	public void Visible(boolean opc){
		this.frmModificarTrabajador.setVisible(opc);		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		ges = new Gestion();
		frmModificarTrabajador = new JFrame();
		frmModificarTrabajador.setTitle("Modificar Trabajador");
		frmModificarTrabajador.setResizable(false);
		frmModificarTrabajador.setBounds(100, 100, 349, 366);
		frmModificarTrabajador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		frmModificarTrabajador.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		tp_dni = new JTextPane();
		tp_dni.setBounds(67, 11, 155, 20);
		panel.add(tp_dni);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dni="";
				boolean error=false;
				String[] res;
				
				error = ComprobarNulos(true);
				if(!error)error = ComprobarFormatos(true);
				
				if(!error){
					dni = tp_dni.getText();
					try {
						res = ges.BuscarTrabajador(dni);
						if(res!=null){
							tp_nombre.setText(res[1]);
							tp_nombre.setEditable(true);
							tp_apellidos.setText(res[2]);
							tp_apellidos.setEditable(true);
							tp_telefono.setText(res[3]);
							tp_telefono.setEditable(true);
							tp_email.setText(res[4]);
							tp_email.setEditable(true);
							tp_tipoContrato.setText(res[5]);
							tp_tipoContrato.setEditable(true);
							tp_sueldo.setText(res[6]);
							tp_sueldo.setEditable(true);
							tp_numSegSocial.setText(res[7]);
							tp_numSegSocial.setEditable(true);
							tp_numCuenta.setText(res[8]);
							tp_numCuenta.setEditable(true);
							JOptionPane.showMessageDialog(null, "Se ha encontrado el trabajador correctamente");
							tp_dni.setEditable(false);
						}
						else{
							JOptionPane.showMessageDialog(null, "No se ha encontrado un trabajador con ese dni");
							Limpiar();
						}
					} catch (HeadlessException ex) {
						ex.printStackTrace();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				
			}
		});
		btnBuscar.setBounds(240, 11, 89, 23);
		panel.add(btnBuscar);
		{
			tp_numCuenta = new JTextPane();
			tp_numCuenta.setEditable(false);
			tp_numCuenta.setBounds(125, 269, 204, 20);
			panel.add(tp_numCuenta);
		}
		{
			tp_numSegSocial = new JTextPane();
			tp_numSegSocial.setEditable(false);
			tp_numSegSocial.setBounds(125, 236, 204, 20);
			panel.add(tp_numSegSocial);
		}
		{
			tp_sueldo = new JTextPane();
			tp_sueldo.setEditable(false);
			tp_sueldo.setBounds(125, 203, 204, 20);
			panel.add(tp_sueldo);
		}
		{
			tp_tipoContrato = new JTextPane();
			tp_tipoContrato.setEditable(false);
			tp_tipoContrato.setBounds(125, 168, 204, 20);
			panel.add(tp_tipoContrato);
		}
		{
			tp_email = new JTextPane();
			tp_email.setEditable(false);
			tp_email.setBounds(125, 137, 204, 20);
			panel.add(tp_email);
		}
		{
			tp_telefono = new JTextPane();
			tp_telefono.setEditable(false);
			tp_telefono.setBounds(125, 104, 204, 20);
			panel.add(tp_telefono);
		}
		{
			tp_apellidos = new JTextPane();
			tp_apellidos.setEditable(false);
			tp_apellidos.setBounds(125, 73, 204, 20);
			panel.add(tp_apellidos);
		}
		{
			tp_nombre = new JTextPane();
			tp_nombre.setEditable(false);
			tp_nombre.setBounds(125, 42, 204, 20);
			panel.add(tp_nombre);
		}
		{
			label = new JLabel("N. Cuenta Banc.");
			label.setBounds(10, 269, 105, 20);
			panel.add(label);
		}
		{
			label_1 = new JLabel("N. Seg. Social");
			label_1.setBounds(10, 236, 105, 20);
			panel.add(label_1);
		}
		{
			label_2 = new JLabel("Sueldo");
			label_2.setBounds(10, 203, 105, 20);
			panel.add(label_2);
		}
		{
			label_3 = new JLabel("Tipo Contrato");
			label_3.setBounds(10, 172, 105, 20);
			panel.add(label_3);
		}
		{
			label_4 = new JLabel("Email");
			label_4.setBounds(10, 137, 105, 20);
			panel.add(label_4);
		}
		{
			label_5 = new JLabel("Teléfono");
			label_5.setBounds(10, 104, 105, 20);
			panel.add(label_5);
		}
		{
			label_6 = new JLabel("Apellidos");
			label_6.setBounds(10, 73, 105, 20);
			panel.add(label_6);
		}
		{
			label_7 = new JLabel("Nombre");
			label_7.setBounds(10, 42, 105, 20);
			panel.add(label_7);
		}
		{
			label_8 = new JLabel("DNI");
			label_8.setBounds(10, 11, 47, 20);
			panel.add(label_8);
		}		
		{
			btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
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
					
					error = ComprobarNulos(false);
					if(!error)error = ComprobarFormatos(false);
					
					if(!error){
						try{
							float aux = Float.valueOf(tp_sueldo.getText());
							if(aux<648.60){
								error=true;
								JOptionPane.showMessageDialog(null, "El sueldo debe ser mayor que el salario minimo interprofesional");
							}
						}
						catch(NumberFormatException ex){
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
							res = ges.ModificarTrabajador(dni, nombre, apellidos, telefono, email, tipoContrato, sueldo, numSegSocial, numCuenta);
							/*
							 CODIGOS DE RESPUESTA
							 1 - SE HA INSERTADO CORRECTAMENTE
							 0 - NO SE HA PODIDO INSERTAR EL TRABAJADOR
							 2 - EL SS INSERTADO YA EXISTE
							 3 - EL CC SOCIAL INSERTADO YA EXISTE
							 4 - EL SS y CC YA EXISTEn
							*/
							switch(res){
								case 0:
									JOptionPane.showMessageDialog(null, "No se ha podido actualizar el trabajador");
									break;
								case 1:
									JOptionPane.showMessageDialog(null, "Se ha actualizado el trabajador correctamente");
									break;
								case 2:
									JOptionPane.showMessageDialog(null, "El numero de la seguridad social introducido ya existe. Inserte uno diferente");
									break;
								case 3:
									JOptionPane.showMessageDialog(null, "El numero de la cuenta bancaria introducido ya existe. Inserte uno diferente");
									break;
								case 5:
									JOptionPane.showMessageDialog(null, "El numero de la seguridad social y el numero de la cuenta bancaria introducidos ya existen. Inserte unos diferentes");
									break;
							}
						} catch (HeadlessException ex) {
							JOptionPane.showMessageDialog(null, "No se ha podido conectar con la base de datos");
							ex.printStackTrace();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "No se ha podido conectar con la base de datos");
							ex.printStackTrace();
						}
					}	
				}
			});
			btnActualizar.setBounds(206, 300, 105, 23);
			panel.add(btnActualizar);
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Limpiar();
				}
			});
			btnLimpiar.setBounds(38, 300, 105, 23);
			panel.add(btnLimpiar);
		}
		
	}
	
	private boolean ComprobarNulos(boolean soloDni){
		boolean campoNulo = false;
		
		if(soloDni){
			if(tp_dni.getText().compareTo("")==0){
				JOptionPane.showMessageDialog(null, "No has introducido el dni");
				campoNulo=true;
			}
		}
		else{
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
			if(tp_tipoContrato.getText().compareTo("")==0){
				JOptionPane.showMessageDialog(null, "No has introducido el tipo de contrato");
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
		}
		
		
		
		return campoNulo;
	}
	
	private boolean ComprobarFormatos(boolean soloDni) {
		boolean malFormato=false;
		
		String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";		
		String PATTERN_DNI = "^(\\d{8})([-]?)([A-Z]{1})";		
		String PATTERN_TELEFONO = "^[6]\\d{8}";		
		String PATTERN_NUMSEGSOCIAL = "^\\d{12}";		
		String PATTERN_NUMCUENTA = "^\\d{20}";
		
		if(soloDni){
			if(!validar(tp_dni.getText(),PATTERN_DNI)){
				JOptionPane.showMessageDialog(null, "Has introducido mal el dni");
				malFormato=true;
			}
		}
		else{
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
    private void Limpiar(){
    	tp_nombre.setText("");
		tp_nombre.setEditable(false);
		tp_apellidos.setText("");
		tp_apellidos.setEditable(false);
		tp_telefono.setText("");
		tp_telefono.setEditable(false);
		tp_email.setText("");
		tp_email.setEditable(false);
		tp_tipoContrato.setText("");
		tp_tipoContrato.setEditable(false);
		tp_sueldo.setText("");
		tp_sueldo.setEditable(false);
		tp_numSegSocial.setText("");
		tp_numSegSocial.setEditable(false);
		tp_numCuenta.setText("");
		tp_numCuenta.setEditable(false);
		tp_dni.setEditable(true);
    }
}
