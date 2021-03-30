package modelo;

import static java.time.temporal.ChronoUnit.MILLIS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.Timer;

import GUI.Sonar;

public class ControladorAlarmas {
	private int IntervaloSonar;
	private List<Alarma> alarmasActivas;
	private List<Alarma> alarmasDesactivadas;
	private Alarma proxima;
	private Timer timerSiguiente;
	
	
	
	
	public ControladorAlarmas(int intervaloSonar) {
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
	
	public void eliminaAlarma(String id){
		Alarma alarma = alarma(id);
		if(alarmasActivas.contains(alarma)) {
			alarmasActivas.remove(alarma);
		}else {
			alarmasDesactivadas.remove(alarma(id));
		}
		alarma.borraAlarma();
	}
	
	public int alarmaMasProxima(){
		LocalTime ahora = LocalTime.now();
		Alarma masProxima = null;
		int tiempoMinimo = (int) Float.POSITIVE_INFINITY;
		for (Alarma a: alarmasActivas) {
			int tiempo = (int) MILLIS.between(ahora, a.getHora());
			if(tiempo > 0) {
				if(tiempo < tiempoMinimo) {
					tiempoMinimo = tiempo;
					masProxima = a;
				}
			}
			
		}
		proxima = masProxima;
		return tiempoMinimo;
	}
	

	public void activarMelodia(){
		proxima.sonar(this);
		
		
	}
	public void desactivarMelodia(){
		proxima.apagar();
		cambioProxima();
		
	}
	
	public void desactivarAlarma(String id) {
		Alarma alarma = alarma(id);
		alarmasActivas.remove(alarma);
		alarmasDesactivadas.add(alarma);
		alarma.alarmaOff(this);
	}



	public void activaAlarma(String id) {
		Alarma alarma = alarma(id);
		alarmasDesactivadas.remove(alarma);
		alarmasActivas.add(alarma);
		alarma.alarmaOn();
		
	}



	public int getIntervaloSonar() {
		return IntervaloSonar;
	}



	public void setIntervaloSonar(int intervaloSonar) {
		IntervaloSonar = intervaloSonar;
	}
	
	public void cambioProxima() {
		if(timerSiguiente != null) {
			timerSiguiente.stop();
		}
		int tiempo = alarmaMasProxima();
		if (tiempo <0)return;
		timerSiguiente = new Timer (tiempo, new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	activarMelodia();
		        
		     }
		});
		timerSiguiente.start();
	}
}
