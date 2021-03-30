package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window.Type;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Alarma;
import modelo.AlarmaState;
import modelo.ControladorAlarmas;

public class Sonar extends JFrame {

	private JPanel contentPane;
	protected Timer timer = new Timer();
	protected ApagaAlarma apagaAlarmaTask ;
	
	/**
	 * Create the frame.
	 */
	public Sonar(Alarma alarma, ControladorAlarmas controlador) {
		setType(Type.POPUP);
		setTitle("SONANDO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Esta sonando:" +alarma.getId());
		apagaAlarmaTask = new ApagaAlarma(alarma, controlador);
		timer.schedule(apagaAlarmaTask, controlador.getIntervaloSonar());
		
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
	}
	
	public class ApagaAlarma extends TimerTask{
		private ControladorAlarmas controlador;
		private Alarma alarma;
		
		public ApagaAlarma (Alarma a, ControladorAlarmas c) {
			this.controlador = c;
			this.alarma = a;
		}
		
		public void run() {
			alarma.alarmaTerminada();
			controlador.desactivarMelodia();
			apagar();
		}
	}

	public void apagar() {
		apagaAlarmaTask.cancel();
		this.setVisible(false);
	}

}
