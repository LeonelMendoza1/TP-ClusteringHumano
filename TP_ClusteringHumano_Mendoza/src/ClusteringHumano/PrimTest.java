package ClusteringHumano;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PrimTest {
	Grafo grafo;
	
	@Before
	public void setUp() throws Exception {
		grafo = new Grafo(4);
		grafo.agregarArista(0, 1, 9);
		grafo.agregarArista(0, 2, 5);
		grafo.agregarArista(0, 3, 9);
		grafo.agregarArista(1, 2, 8);
		grafo.agregarArista(1, 3, 6);
		grafo.agregarArista(2, 3, 4);
		grafo = Prim.algoritmoPrim(grafo);
	}

	@Test
	public void test_CantAristas() {
		int aristasPrim = grafo.getCantAristas();
		
		assertEquals(3 ,aristasPrim);
	}
	
	@Test
	public void test_CaminoMin() {
		
		assertTrue(grafo.existeArista(0, 2));
		assertTrue(grafo.existeArista(1, 3));
		assertTrue(grafo.existeArista(3, 2));
	}	
}