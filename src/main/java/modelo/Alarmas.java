package modelo;

import java.util.ArrayList;
import java.util.List;

public class Alarmas {
	private int IntervaloSonar;
	private List<Alarma> alarmasActivas;
	private List<Alarma> alarmasDesactivadas;
	
	
	
	public Alarmas(int intervaloSonar) {
		super();
		IntervaloSonar = intervaloSonar;
		this.alarmasActivas = new ArrayList<Alarma>();
		this.alarmasDesactivadas = new ArrayList<Alarma>();
	}



	public List<Alarma> alarmasActivas() {
		return alarmasActivas;
	}



	public List<Alarma> alarmasDesactivadas() {
		return alarmasDesactivadas;
	}

	public Alarma alarma(String id){
		for(Alarma alarma : alarmasActivas){
			 if(alarma.getId().equals(id)) {
				 return alarma;
			 }
		}
		for(Alarma alarma : alarmasDesactivadas){
			 if(alarma.getId().equals(id)) {
				 return alarma;
			 }
		}
		return null;
		
	}
	
	public boolean anhadeAlarma(Alarma alarma){
		if(this.alarma(alarma.getId()) == null) {
			alarmasActivas.add(alarma);
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean eliminaAlarma(){
		return false;
		
	}
	
	public Alarma alarmaMasProxima(){
		return null;
		
	}
	
	public Alarma desactivaAlarma(){
		return null;
		
	}
	
	public void activarMelodia(){
		return;
		
	}
	public void desactivarMelodia(){
		return;
		
	}
	
	
	
}
