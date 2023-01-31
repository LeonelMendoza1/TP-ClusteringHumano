package ClusteringHumano;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import org.junit.Test;

public class BFSTest
{
	@Test
	public void alcanzablesDosComponentesTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 1, 0);
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(0, 2, 0);
		grafo.agregarArista(3, 4, 0);
		
		int[] esperado = { 0, 1, 2 };
	    iguales(esperado, BFS.alcanzables(grafo, 1));
	}
	
	@Test
	public void alcanzablesUnaAristaTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(3, 4, 0);
		
		int[] esperado = {3, 4};
		iguales(esperado, BFS.alcanzables(grafo, 3));
	}
	
	public void alcanzablesAisladoTest()
	{
		Grafo grafo = new Grafo(5);
		
		int[] esperado = {1};
		iguales(esperado, BFS.alcanzables(grafo, 1));
	}
	
	public void alcanzablesConexoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 2, 0);
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(1, 3, 0);
		
		int[] esperado = {0, 1, 2, 3};
		iguales(esperado, BFS.alcanzables(grafo, 3));
	}
	
	// Verifica que sean iguales como conjuntos
	public static void iguales(int[] esperado, Set<Integer> obtenido)
	{
		assertEquals(esperado.length, obtenido.size());
			
		for(int i=0; i<esperado.length; ++i)
			assertTrue( obtenido.contains(esperado[i]) );
	}
}