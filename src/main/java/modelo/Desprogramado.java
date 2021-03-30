package modelo;

public class Desprogramado extends AlarmaState {
	
	public void alarmaOn (Alarma context) {
		context.setState(getEstadoProgramado());
	}
	
	public void borraAlarma (Alarma context) {
		context.setState(getEstadoBorrada());
	}
}
