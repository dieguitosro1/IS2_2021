package es.unican.is2.seguros.model;

import java.time.LocalDate;

public class Seguro {

	private LocalDate fechaUltimoSiniestro;
	private int potenciaCV;
	private Cobertura cobertura;
	private Cliente cliente;

	public Seguro(int potencia, Cliente cliente, Cobertura cobertura) {
		if (cobertura == null || cliente == null) {
			throw new DatoIncorrectoException() ;
		}
		this.potenciaCV = potencia;
		this.cliente = cliente;
		this.cobertura = cobertura;

	}



	public LocalDate getFechaUltimoSiniestro() {
		return fechaUltimoSiniestro;
	}



	public void setFechaUltimoSiniestro(LocalDate fechaUltimoSiniestro) {
		this.fechaUltimoSiniestro = fechaUltimoSiniestro;
	}



	public double precio() {
		double precio = 0;

		//Precio base
		switch(cobertura) {
		case TERCEROS:
			precio += 400;
			break;
		case TODORIESGO:
			precio += 1000;
			break;
		case TERCEROSLUNAS:
			precio += 600;
			break;
		}

		//Añadir Potencia
		if (potenciaCV < 0) {
			throw new DatoIncorrectoException() ;
		}else if(this.potenciaCV >= 90 && this.potenciaCV <=110) {
			precio = precio * 1.05;
		}else if(this.potenciaCV > 110) {
			precio = precio * 1.20;
		}
		LocalDate ahora = LocalDate.now();

		//Añadir siniestralidad
		if(fechaUltimoSiniestro != null) {
			//Existe una fecha de siniestro
			if(ahora.isBefore(fechaUltimoSiniestro)) {
				//Caso de que este mal introducida y sea una fecha futura
				throw new DatoIncorrectoException() ;
			}
			if(ahora.minusYears(1).getYear() > fechaUltimoSiniestro.getYear()) {
				//caso ha pasado mas de un año
				if(ahora.minusYears(3).getYear() < fechaUltimoSiniestro.getYear()) {
					//Caso han pasado menos de tres años
					precio += 50;
				}
			}else {
				//caso ha pasado menos de un año
				precio += 200;
			}
		}

		//Minusvalia

		if(cliente.isMinusvalia()) {
			precio = precio * 0.75;
		}



		return precio;
	}

}
