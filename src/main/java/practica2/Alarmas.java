package practica2;

import java.util.ArrayList;
import java.util.List;

public class Alarmas {
	private int IntervaloSonar;
	private List<AlarmaState> alarmasActivas;
	private List<AlarmaState> alarmasDesactivadas;
	
	
	
	public Alarmas(int intervaloSonar) {
		super();
		IntervaloSonar = intervaloSonar;
		this.alarmasActivas = new ArrayList<AlarmaState>();
		this.alarmasDesactivadas = new ArrayList<AlarmaState>();
	}



	public List<AlarmaState> alarmasActivas() {
		return alarmasActivas;
	}



	public List<AlarmaState> alarmasDesactivadas() {
		return alarmasDesactivadas;
	}

	public AlarmaState alarma(){
		return null;
		
	}
	
	public boolean anhadeAlarma(){
		return false;
		
	}
	
	public boolean eliminaAlarma(){
		return false;
		
	}
	
	public AlarmaState alarmaMasProxima(){
		return null;
		
	}
	
	public AlarmaState desactivaAlarma(){
		return null;
		
	}
	
	public void activarMelodia(){
		return;
		
	}
	public void desactivarMelodia(){
		return;
		
	}
	
	
}
