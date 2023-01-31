package ClusteringHumano;

public class Prim {
	
	public static Grafo algoritmoPrim(Grafo grafo) {
		
		int[] visitados = new int[grafo.getCantVertices()];
		int min = 21;	// Una arista no puede pesar 21 o mas
		int u = 0, v = 0;
		Grafo nuevo = new Grafo(grafo.getCantVertices());
		
		for(int i = 0; i < grafo.getCantVertices(); i++){
			visitados[i] = 0;
			for(int j = 0; j < grafo.getCantVertices(); j++){
				if(grafo.getPeso(i, j) == -1){
					grafo.cambiarPeso(i, j, min);
				}
			}
		}
		
		visitados[0] = 1;
		
		for(int counter = 0; counter < grafo.getCantVertices()-1 ; counter++){
			
			min = 21;
			
			for(int i = 0; i < grafo.getCantVertices(); i++){
				if(visitados[i]==1){
					for(int j = 0; j < grafo.getCantVertices(); j++){
						if(visitados[j]==0){
							if(min > grafo.getPeso(i, j)){
								min = grafo.getPeso(i, j);
								u = i;
								v = j;
							}
						}
					}
				}
			}
			
			visitados[v] = 1;
			nuevo.agregarArista(u, v, min);
		}
		return nuevo;
	}
}
