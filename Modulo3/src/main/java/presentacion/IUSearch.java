package presentacion;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import dominio.Gestion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;

public class IUSearch {

	private JFrame frmBuscarTrabajador;
	private Gestion ges;
	private boolean cargado;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IUSearch window = new IUSearch();
					window.frmBuscarTrabajador.setVisible(true);
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
	public IUSearch() throws Exception {
		initialize();
	}
	
	public void Visible(boolean opc){
		this.frmBuscarTrabajador.setVisible(opc);		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		ges = new Gestion();
		frmBuscarTrabajador = new JFrame();
		frmBuscarTrabajador.setTitle("Buscar Trabajador");
		frmBuscarTrabajador.setResizable(false);
		frmBuscarTrabajador.setBounds(100, 100, 349, 330);
		frmBuscarTrabajador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		frmBuscarTrabajador.getContentPane().add(panel, BorderLayout.CENTER);
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
				
				error = ComprobarNulos();
				if(!error)error = ComprobarFormatos();
				
				if(!error){
					dni = tp_dni.getText();
					try {
						res = ges.BuscarTrabajador(dni);
						if(res!=null){
							tp_nombre.setText(res[1]);
							tp_apellidos.setText(res[2]);
							tp_telefono.setText(res[3]);
							tp_email.setText(res[4]);
							tp_tipoContrato.setText(res[5]);
							tp_sueldo.setText(res[6]);
							tp_numSegSocial.setText(res[7]);
							tp_numCuenta.setText(res[8]);
							JOptionPane.showMessageDialog(null, "Se ha encontrado el trabajador correctamente");
						}
						else	JOptionPane.showMessageDialog(null, "No se ha encontrado un trabajador con ese dni");
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
		
	}
	
	private boolean ComprobarNulos(){
		boolean campoNulo = false;
		
		if(tp_dni.getText().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "No has introducido el dni");
			campoNulo=true;
		}		
		return campoNulo;
	}
	
	private boolean ComprobarFormatos() {
		boolean malFormato=false;
			
		String PATTERN_DNI = "^(\\d{8})([-]?)([A-Z]{1})";
		
		if(!validar(tp_dni.getText(),PATTERN_DNI)){
			JOptionPane.showMessageDialog(null, "Has introducido mal el dni");
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
