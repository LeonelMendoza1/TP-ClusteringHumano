package ClusteringHumano;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
	
	// Representamos el grafo por su matriz de adyacencia
	private int [][] A;
	int cantAristas = 0;
	
	// La cantidad de vertices esta predeterminada desde el constructor
	public Grafo(int vertices)
	{
		A = new int[vertices][vertices];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				A[i][j] = -1;
			}
		}
	}
	
	// Agregado de aristas
	public void agregarArista(int i, int j, int peso)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = peso;
		A[j][i] = peso;
		cantAristas++;
	}
	
	// Eliminacion de aristas
	public void eliminarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = -1;
		A[j][i] = -1;
		cantAristas--;
	}
	
	// Informa si existe la arista especificada
	public boolean existeArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		
		boolean existe;
		
		if (A[i][j] >= 0) {
			existe = true;
		}
		else {
			existe = false;
		}
		
		return existe;
	}
	
	// Verifica que sea un vertice valido
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= A.length )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}
	
	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
	
	// Vecinos de un vertice
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);
		
		Set<Integer> ret = new HashSet<Integer>();
		for(int j = 0; j < this.getCantVertices(); ++j) if( i != j )
		{
			if( this.existeArista(i,j) )
				ret.add(j);
		}
		
		return ret;
	}
	
	// Para cambiar el peso de una arista
	public void cambiarPeso (int i, int j, int peso) {
		A[i][j] = peso;
	}
	
	// Busca la arista mayor, la elimina y devuelve la una punta para hacer BFS sobre eso
	public int[] aristaMayor() {
		int[] coordenadas = new int [2];
		int mayor = 0;
		int fila = 0;
		int col = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if(mayor <= A[i][j] ) {
					mayor = A[i][j];
					fila = i;
					col = j;
				}
			}
		}
		coordenadas[0] = fila;
		coordenadas[1] = col;
		
		eliminarArista(fila, col);
		
		return coordenadas;
	}
	
	public int getPeso(int i, int j) {
		return A[i][j];
	}

	public int getCantVertices() {
		return A.length;
	}
	
	public int getCantAristas() {
		return cantAristas;
	}
}
