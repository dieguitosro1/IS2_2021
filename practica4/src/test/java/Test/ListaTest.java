package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import es.unican.is2.containers.ListaOrdenada;





public class ListaTest {
	private ListaOrdenada<String> lista;

	@Before
	public void constructor() {
		this.lista = new ListaOrdenada<String>();
	}


	@Test
	public void testConstructorCeroElementos() {
		if(lista.size() == 0) {
			assertTrue(true);
		}else {
			fail("No se crea la lista vacia");
		}
	}

	@Test
	public void testPruebaAdd() {
		lista.add("s");
		lista.add("a");
		lista.add("z");
		if(lista.size() == 3) {
			assertTrue(true);
		}else {
			fail("Fallo en el metodo size");
		}

	}
	@Test
	public void testPruebaGet() {
		lista.add("s");
		lista.add("a");
		lista.add("z");
		String elemento = lista.get(0);
		if(elemento.equals("a")) {
			assertTrue(true);
		}else {
			fail("Fallo en el metodo get");
		}
		try {
			elemento = lista.get(-1);
			if(elemento != null) {
				fail("Deja meter negativos");
			}
		}catch( IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		
		try {
			elemento = lista.get(7);
			if(elemento != null) {
				fail("Deja meter pasados de rango");
			}
		}catch( IndexOutOfBoundsException e) {
			assertTrue(true);
		}


	}
	@Test
	public void testPruebaRemove() {
		lista.add("s");
		lista.add("a");
		lista.add("z");
		try {
			lista.remove(-1);
			fail("El metodo borrar permite negativos");
		}catch( IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		
		try {
			lista.remove(7);
			fail("El metodo borrar permite numeros fuera de rango");
		}catch( IndexOutOfBoundsException e) {
			assertTrue(true);
		}
			
		lista.remove(0);
		if(lista.size() == 2) {
			assertTrue(true);
		}else {
			fail("No borra correctamente");
		}
		
		lista.remove(1);
		if(lista.size() == 1) {
			assertTrue(true);
		}else {
			fail("No borra correctamente");
		}
	}
	@Test
	public void testPruebaClear() {
		lista.add("s");
		lista.add("a");
		lista.add("z");
		lista.clear();
		if(lista.size() == 0){
			assertTrue(true);
		}else {
			fail("El metodo clear no funciona correctamente");
		}
	}
	
}
