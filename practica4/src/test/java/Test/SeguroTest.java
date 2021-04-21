package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Test;

import es.unican.is2.seguros.model.Cliente;
import es.unican.is2.seguros.model.Cobertura;
import es.unican.is2.seguros.model.DatoIncorrectoException;
import es.unican.is2.seguros.model.Seguro;

public class SeguroTest {
	private Seguro seguro;

	@Test
	public void testConstructor() {
		Cliente cliente = new Cliente("Pepe", "11232258S", true);
		seguro = new Seguro(80,cliente,Cobertura.TODORIESGO);
		assertTrue(seguro.getFechaUltimoSiniestro() == null);
	}

	@Test
	public void testCaso1() {

		try{
			Cliente cliente = new Cliente("Pepe", "11232258S", true);
			seguro = new Seguro(80,cliente,Cobertura.TODORIESGO);
			LocalDate date = LocalDate.of(2021, 1, 15);
			seguro.setFechaUltimoSiniestro(date);
			if(seguro.precio() == 900) {
				assertTrue(true);
			}else {
				fail("No se ha obtenido el precio deseado");
			}
		} catch (DatoIncorrectoException e) {
			fail("No deberia lanzar la excepcion");
			
		}
	}
	@Test
	public void testCaso2() {

		try{
			Cliente cliente = new Cliente("Pepe", "11232258S", false);
			seguro = new Seguro(80,cliente,Cobertura.TERCEROS);
			LocalDate date = LocalDate.of(2019, 1, 15);
			seguro.setFechaUltimoSiniestro(date);
			double precio = seguro.precio() ;
			assertTrue(precio == 450);
		} catch (DatoIncorrectoException e) {
			fail("No deberia lanzar la excepcion");
		}
	}
	@Test
	public void testCaso3() {

		try{
			Cliente cliente = new Cliente("Pepe", "11232258S", true);
			seguro = new Seguro(95,cliente,Cobertura.TERCEROSLUNAS);
			LocalDate date = LocalDate.of(2015, 1, 15);
			seguro.setFechaUltimoSiniestro(date);
			assertTrue(seguro.precio() == 472.5);
		} catch (DatoIncorrectoException e) {
			fail("No deberia lanzar la excepcion");
		}
	}
	@Test
	public void testCaso4() {

		try{
			Cliente cliente = new Cliente("Pepe", "11232258S", false);
			seguro = new Seguro(95,cliente,Cobertura.TERCEROS);
			LocalDate date = LocalDate.of(2015, 1, 15);
			seguro.setFechaUltimoSiniestro(date);
			assertTrue(seguro.precio() == 420);
		} catch (DatoIncorrectoException e) {
			fail("No deberia lanzar la excepcion");
		}
	}
	@Test
	public void testCaso5() {

		try{
			Cliente cliente = new Cliente("Pepe", "11232258S", true);
			seguro = new Seguro(120,cliente,Cobertura.TODORIESGO);
			LocalDate date = LocalDate.of(2021, 1, 15);
			seguro.setFechaUltimoSiniestro(date);
			assertTrue(seguro.precio() == 1050);
		} catch (DatoIncorrectoException e) {
			fail("No deberia lanzar la excepcion");
		}
	}
	@Test
	public void testCaso6() {

		try{
			Cliente cliente = new Cliente("Pepe", "11232258S", false);
			seguro = new Seguro(120,cliente,Cobertura.TERCEROSLUNAS);
			LocalDate date = LocalDate.of(2021, 1, 15);
			seguro.setFechaUltimoSiniestro(date);
			assertTrue(seguro.precio() == 920);
		} catch (DatoIncorrectoException e) {
			fail("No deberia lanzar la excepcion");
		}
	}
	@Test
	public void testCaso7() {

		try{
			Cliente cliente = new Cliente("Pepe", "11232258S", true);
			seguro = new Seguro(80,cliente,Cobertura.TERCEROS);
			LocalDate date = LocalDate.of(2021, 1, 15);
			seguro.setFechaUltimoSiniestro(date);
			assertTrue(seguro.precio() == 450);
		} catch (DatoIncorrectoException e) {
			fail("No deberia lanzar la excepcion");
		}
	}
	@Test
	public void testCaso8() {
		try{
			Cliente cliente = new Cliente("Pepe", "11232258S", true);
			seguro = new Seguro(80,cliente,Cobertura.TODORIESGO);
			LocalDate date = LocalDate.of(2022, 1, 15);
			seguro.setFechaUltimoSiniestro(date);
			seguro.precio();
		} catch (DatoIncorrectoException e) {
			assertTrue(true);
		}
	}
	@Test
	public void testCaso9() {
		try{
			Cliente cliente = new Cliente("Pepe", "11232258S", false);
			seguro = new Seguro(95,cliente,null);
			LocalDate date = LocalDate.of(2015, 1, 15);
			seguro.setFechaUltimoSiniestro(date);
			seguro.precio();
		} catch (DatoIncorrectoException e) {
			assertTrue(true);
		}
	}
	@Test
	public void testCaso10() {
		try{
			Cliente cliente = null;
			seguro = new Seguro(120,cliente,Cobertura.TODORIESGO);
			LocalDate date = LocalDate.of(2021, 1, 15);
			seguro.setFechaUltimoSiniestro(date);
			seguro.precio();
		} catch (DatoIncorrectoException e) {
			assertTrue(true);
		}

	}
	@Test
	public void testCaso11() {
		try{
			Cliente cliente = new Cliente("Pepe", "11232258S",false );
			seguro = new Seguro(-30,cliente,Cobertura.TODORIESGO);
			LocalDate date = LocalDate.of(2021, 1, 15);
			seguro.setFechaUltimoSiniestro(date);
			seguro.precio();
		} catch (DatoIncorrectoException e) {
			assertTrue(true);
		}
	}
}
