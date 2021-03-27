package modelo;

import java.util.Date;

public class Alarma {
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public AlarmaState getState() {
		return state;
	}

	public void setState(AlarmaState state) {
		this.state = state;
	}

	private String id;
	private Date hora;
	private AlarmaState state;
	
	public Alarma(String id, Date hora) {
		this.id = id;
		this.hora = hora;
		this.state = AlarmaState.init(this);
	}
	
	public void borraAlarma() {
	}
	
	
	public void apagar() {	
	}
	
	public void alarmaOn() {
		
	}
	
	public void alarmaOff() {
		
	}

}
