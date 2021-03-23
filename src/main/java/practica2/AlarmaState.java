package practica2;

import java.sql.Time;

public abstract class AlarmaState {
	private static Desprogramado estadoDesprogramado = new Desprogramado();
	private static Programado estadoProgramado = new Programado();
	private static Sonando estadoSonando = new Sonando();
	
	
	public void nuevaAlarma(String id, Time hora, Alarmas context) {
		
	}
	
	public void borraAlarma(String id, Alarmas context) {
		
	}
	
	public void apagar (Alarmas context) {
		
	}
	
	public void alarmaOff (String id, Alarmas context) {
		
	}
	
	public void alarmaOn (String id, Alarmas context) {
		
	}
}
