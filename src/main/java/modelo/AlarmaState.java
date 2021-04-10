package modelo;

import java.sql.Time;

public abstract class AlarmaState {
	private static Desprogramado estadoDesprogramado = new Desprogramado();
	private static Programado estadoProgramado = new Programado();
	private static Sonando estadoSonando = new Sonando();
	private static Borrada estadoBorrada = new Borrada();
	
	public static AlarmaState init(Alarma alarma) {
		return estadoProgramado;
	}
	public void nuevaAlarma(String id, Time hora, Alarma context) {}
	
	public void borraAlarma(Alarma alarma) {}
	
	public void apagar (Alarma context) {}
	
	public void alarmaOff (Alarma alarma) {}
	
	public void alarmaOn (Alarma context) {}
	
	public void sonar (Alarma context, ControladorAlarmas controlador) {}
	
	public static Desprogramado getEstadoDesprogramado() {
		return estadoDesprogramado;
	}
	public static void setEstadoDesprogramado(Desprogramado estadoDesprogramado) {
		AlarmaState.estadoDesprogramado = estadoDesprogramado;
	}
	public static Programado getEstadoProgramado() {
		return estadoProgramado;
	}
	public static void setEstadoProgramado(Programado estadoProgramado) {
		AlarmaState.estadoProgramado = estadoProgramado;
	}
	public static Sonando getEstadoSonando() {
		return estadoSonando;
	}
	public static void setEstadoSonando(Sonando estadoSonando) {
		AlarmaState.estadoSonando = estadoSonando;
	}
	public static Borrada getEstadoBorrada() {
		return estadoBorrada;
	}
	public static void setEstadoBorrada(Borrada estadoBorrada) {
		AlarmaState.estadoBorrada = estadoBorrada;
	}
	public void exitAction(Alarma alarma) {
	}
	
	
}
