package modelo;

import GUI.Sonar;

public class Sonando extends AlarmaState{
	private Sonar sonar;
	
	public void entryAction (Alarma context, ControladorAlarmas controlador) {
		sonar = new Sonar(context, controlador);
        sonar.setVisible(true);
	}
	
	public void apagar(Alarma context) {
		sonar.apagar();
		context.setState(getEstadoProgramado());
	}
	
	public void exitAction (Alarma context) {
		context.setState(getEstadoProgramado());
	}
}
