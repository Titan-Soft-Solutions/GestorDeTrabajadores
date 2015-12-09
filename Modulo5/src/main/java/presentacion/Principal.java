package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class Principal {

	private JFrame frmAgendaMonolitica;
	private JTextField txtAgendaMonolitica;
	private IUAdd windowadd;
	private IUDelete windowdelete;
	private IUModify windowmodify;
	private IUSearch windowsearch;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmAgendaMonolitica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaMonolitica = new JFrame();
		frmAgendaMonolitica.setTitle("Agenda Monolitica");
		frmAgendaMonolitica.setResizable(false);
		frmAgendaMonolitica.setBounds(100, 100, 233, 222);
		frmAgendaMonolitica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jpanel = new JPanel();
		jpanel.setBackground(new Color(204, 204, 255));
		frmAgendaMonolitica.getContentPane().add(jpanel, BorderLayout.CENTER);
		jpanel.setLayout(null);
		
		JButton bt_add = new JButton("Añadir Trabajador");
		bt_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					windowadd = new IUAdd();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				windowadd.Visible(true);				
			}
		});
		bt_add.setBounds(33, 42, 154, 23);
		jpanel.add(bt_add);
		
		JButton bt_remove = new JButton("Borrar Trabajador");
		bt_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					windowdelete = new IUDelete();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				windowdelete.Visible(true);
			}
		});
		bt_remove.setBounds(33, 76, 154, 23);
		jpanel.add(bt_remove);
		
		JButton bt_modify = new JButton("Modificar Trabajador");
		bt_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					windowmodify = new IUModify();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				windowmodify.Visible(true);
			}
		});
		bt_modify.setBounds(33, 110, 154, 23);
		jpanel.add(bt_modify);
		
		JButton btnBuscarContacto = new JButton("Buscar Trabajador");
		btnBuscarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					windowsearch = new IUSearch();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				windowsearch.Visible(true);
			}
		});
		btnBuscarContacto.setBounds(33, 144, 154, 23);
		jpanel.add(btnBuscarContacto);
		
		txtAgendaMonolitica = new JTextField();
		txtAgendaMonolitica.setForeground(new Color(255, 255, 255));
		txtAgendaMonolitica.setBackground(new Color(204, 204, 255));
		txtAgendaMonolitica.setEditable(false);
		txtAgendaMonolitica.setFont(new Font("Calibri", Font.BOLD, 14));
		txtAgendaMonolitica.setText("Gestor de Tabajadores 1.0");
		txtAgendaMonolitica.setBounds(30, 11, 168, 20);
		jpanel.add(txtAgendaMonolitica);
		txtAgendaMonolitica.setColumns(10);
	}
}
