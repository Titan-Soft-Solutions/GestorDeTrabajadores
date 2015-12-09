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
import java.awt.event.WindowAdapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import java.awt.Font;

public class IUDelete {

	private JFrame frmBorrarTrabajador;
	private JTextPane tp_dni;
	private Gestion ges;
	private JLabel lblDni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IUDelete window = new IUDelete();
					window.frmBorrarTrabajador.setVisible(true);
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
	public IUDelete() throws Exception {
		initialize();
	}
	
	public void Visible(boolean opc){
		this.frmBorrarTrabajador.setVisible(opc);		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		ges = new Gestion();
		
		frmBorrarTrabajador = new JFrame();
		frmBorrarTrabajador.setTitle("Borrar Trabajador");
		frmBorrarTrabajador.addWindowListener(new WindowAdapter() {
		});
		frmBorrarTrabajador.setResizable(false);
		frmBorrarTrabajador.setBounds(100, 100, 267, 133);
		frmBorrarTrabajador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		frmBorrarTrabajador.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		tp_dni = new JTextPane();
		tp_dni.setBounds(56, 23, 175, 20);
		panel.add(tp_dni);
		
		JButton bt_borrar = new JButton("Borrar");
		bt_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dni="";
				boolean error=false;
				int confir=JOptionPane.YES_OPTION;
				int res;
				
				error = ComprobarNulos();
				if(!error)error = ComprobarFormatos();
				
				if(!error) confir = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminarlo?", "", JOptionPane.YES_NO_OPTION);
				
				if(!error && (confir != JOptionPane.NO_OPTION)){
					dni = tp_dni.getText();
					try {
						res = ges.BorrarTrabajador(dni);
						if(res==2)	JOptionPane.showMessageDialog(null, "No existe un trabajador con ese dni");
						if(res==1)	JOptionPane.showMessageDialog(null, "Se ha eliminado el trabajador correctamente");
						if(res==0)	JOptionPane.showMessageDialog(null, "No se ha podido eliminar el trabajador");
					} catch (HeadlessException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null,e.toString());
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null,e.toString());
					}
				}
			}
		});
		bt_borrar.setBounds(80, 60, 103, 23);
		panel.add(bt_borrar);
		{
			lblDni = new JLabel("Dni");
			lblDni.setFont(new Font("Calibri", Font.BOLD, 12));
			lblDni.setBounds(22, 24, 31, 20);
			panel.add(lblDni);
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
