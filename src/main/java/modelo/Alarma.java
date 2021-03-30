package modelo;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.Date;

public class Alarma {
	private String id;
	private LocalTime hora;
	private AlarmaState state;
	
	public Alarma(String id, LocalTime hora) {
		this.id = id;
		this.hora = hora;
		this.state = AlarmaState.init(this);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public AlarmaState getState() {
		return state;
	}

	public void setState(AlarmaState state) {
		this.state = state;
	}

	public void borraAlarma() {
		state.borraAlarma(this);
	}
	
	
	public void apagar() {	
		state.apagar(this);
	}
	
	public void alarmaOn() {
		state.alarmaOn(this);
		
	}
	
	public void alarmaOff(ControladorAlarmas controladorAlarmas) {
		state.alarmaOff(this);
		
	}
	
	public void sonar(ControladorAlarmas context) {
		state.sonar(this, context);
	}

	public void alarmaTerminada() {
		state.exitAction(this);
	}


	
	

}
