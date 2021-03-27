package modelo;

import java.sql.Time;

public abstract class AlarmaState {
	private static Desprogramado estadoDesprogramado = new Desprogramado();
	private static Programado estadoProgramado = new Programado();
	private static Sonando estadoSonando = new Sonando();
	
	public static AlarmaState init(Alarma alarma) {
		return estadoProgramado;
	}
	public void nuevaAlarma(String id, Time hora, Alarma context) {
		
	}
	
	public void borraAlarma(String id, Alarma context) {
		
	}
	
	public void apagar (Alarma context) {
		
	}
	
	public void alarmaOff (Alarmas context) {
		
	}
	
	public void alarmaOn (Alarma context) {
		
	}

	
}
