package modelo;

public class Programado extends AlarmaState{

	
	public void alarmaOff (Alarma context) {
		context.setState(getEstadoDesprogramado());
	}
	
	public void borraAlarma (Alarma context) {
		context.setState(getEstadoBorrada());
	}
	
	public void sonar (Alarma context, ControladorAlarmas controlador) {
		context.setState(getEstadoSonando());
		getEstadoSonando().entryAction(context, controlador );
	}
	
}
