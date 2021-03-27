package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Aviso extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public Aviso(String aviso) {
		setType(Type.POPUP);
		setTitle("AVISO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(aviso);
		
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("CERRAR");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}
	
	private void cerrar() {
		this.dispose();
	}	


}
