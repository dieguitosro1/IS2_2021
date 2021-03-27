package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;

import modelo.Alarma;
import modelo.Alarmas;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField txtIdAlarma;
	private DefaultListModel modelActivas = new DefaultListModel<String>();;
	private DefaultListModel modelDesactivadas = new DefaultListModel<String>();;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final Alarmas controladorAlarmas = new Alarmas(10);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("Aplicacion de alarmas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(22, 22, 389, 437);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblIdAlarma = new JLabel("Id Alarma:");
		lblIdAlarma.setBounds(0, 30, 130, 20);
		panel_1.add(lblIdAlarma);
		
		txtIdAlarma = new JTextField();
		txtIdAlarma.setBounds(79, 30, 86, 20);
		panel_1.add(txtIdAlarma);
		txtIdAlarma.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Hora Alarma:");
		lblNewLabel.setBounds(0, 61, 75, 14);
		panel_1.add(lblNewLabel);
		
		final JSpinner spinnerHora = new JSpinner();
		spinnerHora.setBounds(79, 58, 86, 20);
		SpinnerDateModel model = new SpinnerDateModel();
		model.setCalendarField(Calendar.MINUTE); 
		spinnerHora.setModel(model); 
		spinnerHora.setEditor(new JSpinner.DateEditor(spinnerHora, "h:mm a"));
		panel_1.add(spinnerHora);
		
		JButton btnNuevaAlarma = new JButton("Nueva Alarma");
		btnNuevaAlarma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtIdAlarma.getText().trim().equals("")) {
					//TODO mostarr aviso
					System.out.println("No hay nombre de alarma");
					String aviso = "No hay nombre de alarma";
					Aviso ventana = new Aviso(aviso);
					ventana.setVisible(true);
					return;
				}
				String id = txtIdAlarma.getText().trim();
				Date hora = (Date) spinnerHora.getValue();
				Alarma alarma = new Alarma(id, hora);
				if(controladorAlarmas.anhadeAlarma(alarma)) {
					System.out.println("Alarma añadida correctamente");
					modelActivas.addElement(id);
				}else {
					//TODO mostarr aviso
					System.out.println("Error al añadir alarma");
					return;
				}
					
			}
		});
		btnNuevaAlarma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNuevaAlarma.setBounds(0, 107, 165, 23);
		panel_1.add(btnNuevaAlarma);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnApagar.setBounds(20, 151, 130, 80);
		panel_1.add(btnApagar);
		
		JLabel lblNewLabel_1 = new JLabel("Alarmas Activas");
		lblNewLabel_1.setBounds(258, 11, 121, 14);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(252, 30, 95, 115);
		panel_1.add(panel_2);
		
		JList listActivas = new JList();
		listActivas.setModel(modelActivas);
		panel_2.add(listActivas);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(252, 205, 95, 115);
		panel_1.add(panel_2_1);
		
		JList listDesactivadas = new JList();
		listDesactivadas.setModel(modelDesactivadas);
		panel_2_1.add(listDesactivadas);
		
		JLabel lblNewLabel_1_1 = new JLabel("Alarmas Desactivadas");
		lblNewLabel_1_1.setBounds(242, 184, 137, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnAlarmaOff = new JButton("OFF");
		btnAlarmaOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAlarmaOff.setBounds(218, 331, 62, 23);
		panel_1.add(btnAlarmaOff);
		
		JButton btnAlarmaOn = new JButton("ON");
		btnAlarmaOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAlarmaOn.setBounds(313, 331, 53, 23);
		panel_1.add(btnAlarmaOn);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnEliminar.setBounds(252, 383, 89, 23);
		panel_1.add(btnEliminar);
	}
}
