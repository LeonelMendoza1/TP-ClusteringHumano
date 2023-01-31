package ClusteringHumano;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class GrafoTest {
	@Test
	public void test_ExisteArista() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,3,5);
		assertTrue(grafo.existeArista(2, 3));
		assertTrue(grafo.existeArista(3, 2));
		assertFalse(grafo.existeArista(1, 4));
	}
	
	@Test
	public void test_EliminarArista() 
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,3,5);
		grafo.agregarArista(4,1,2);
		grafo.eliminarArista(3, 2);
		assertFalse(grafo.existeArista(2, 3));
		assertTrue(grafo.existeArista(1, 4));;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.vecinos(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticeExcedidoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.vecinos(5);
	}

	@Test
	public void todosAisladosTest()
	{
		Grafo grafo = new Grafo(5);
		assertEquals(0, grafo.vecinos(2).size());
	}
	
	@Test
	public void verticeUniversalTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 0, 5);
		grafo.agregarArista(1, 2, 5);
		grafo.agregarArista(1, 3, 5);
		
		int[] esperado = {0, 2, 3};
		iguales(esperado, grafo.vecinos(1));
	}
	
	@Test
	public void verticeNormalTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 3, 5);
		grafo.agregarArista(2, 3, 5);
		grafo.agregarArista(2, 4, 5);
		
		int[] esperados = {1, 2};
		iguales(esperados, grafo.vecinos(3));
	}
	
	@Test
	public void verticesVecinosTest() {
		Grafo grafo = new Grafo (5);
		grafo.agregarArista(1, 2, 5);
		grafo.agregarArista(1, 3, 2);
		grafo.agregarArista(1, 0, 1);
		
		Set <Integer> esperados = new HashSet<Integer>();
		esperados.add(2);
		esperados.add(3);
		esperados.add(0);
		
		assertEquals(esperados, grafo.vecinos(1));
	}
	
	@Test
	public void cambiarVerticesTest() {
		Grafo grafo = new Grafo (5);
		grafo.agregarArista(3, 2, 4);
		grafo.cambiarPeso(2, 3, 2);
		assertEquals(2, grafo.getPeso(2, 3));
	}
	
	@Test
	public void aristaMayorTest() {
		Grafo grafo = new Grafo (4);
		grafo.agregarArista(0, 1, 3);
		grafo.agregarArista(0, 2, 1);
		grafo.agregarArista(0, 3, 5);
		grafo.agregarArista(1, 2, 4);
		grafo.agregarArista(1, 3, 2);
		grafo.agregarArista(2, 3, 9);
		
		int[] esperado = new int [2];
		esperado[0] = 3;
		esperado[1] = 2;
		
		assertArrayEquals (esperado, grafo.aristaMayor());
	}
	
	//Para testear igualdad
	public static void iguales(int[] esperado, Set<Integer> obtenido)
	{
		assertEquals(esperado.length, obtenido.size());
			
		for(int i=0; i<esperado.length; ++i)
			assertTrue( obtenido.contains(esperado[i]) );
	}
}