package matrixLaberinto;

import java.util.*;

import nodo.Camino;
import nodo.Nodo;

/*
 * We'll use for this problem the A* algorithm
 * */
public class AStarAlgorithm {
	
	private HashSet<Nodo> nodosEvaluados = new HashSet<>(); 
	private HashSet<Nodo> nodosAEvaluar = new HashSet<>();
	private int gTentativo = 0;
	private Nodo actual;
	
	public Nodo menorNodo(HashSet<Nodo> nodosAEvaluar){        
        int t;
        Iterator<Nodo> it = nodosAEvaluar.iterator();
        if(it.hasNext()) {
            Nodo menor = it.next();
            while (it.hasNext()) {
                Nodo sig = it.next();   
                t = sig.getF();             
                    if (t <= menor.getF()) { 
                    menor = sig;
                }
            }
            return menor;
        }
        else{
            throw new RuntimeException();
        }

}
	
	public Camino buscarCamino(Nodo init) {
		init.setG(0);
		init.setF(init.getHeuristica());
		init.setBestprev(init);
		nodosAEvaluar.add(init);
		while(!nodosAEvaluar.isEmpty()) {
			// current node (minus cost)
			actual = menorNodo(nodosAEvaluar);
			
			if(actual.getEstado()=='G')
				return reconstruct_path(actual.getBestprev() , actual); 
			
			nodosAEvaluar.remove(actual);	
			nodosEvaluados.add(actual);
			
			for(Nodo vecino : actual.vecinos) {
			
				if(nodosEvaluados.contains(vecino)) continue;
				if(vecino.getEstado() != '*') {
					gTentativo = actual.getG() + 1; // the distancia between a node and its neighbour is always 1
					if(!nodosAEvaluar.contains(vecino) || gTentativo < vecino.getG()) {
						vecino.setBestprev(actual);
						vecino.setG(gTentativo);
						vecino.setF(vecino.getG() + vecino.getHeuristica());
						if(!nodosAEvaluar.contains(vecino)) {
							nodosAEvaluar.add(vecino);
						}
					
					}
				}
				
			}
				
		}
		return null;
	}
	
	public Camino reconstruct_path(Nodo padre,Nodo current) {  // función que reconstruye el camino óptimo calulado accediendo al nodo padre de forma iterativa
        Nodo aux = current;
        while(padre.getEstado() !='I'){
            if(aux.getEstado() != 'G'){
                aux.setEstado( '+'); 
            }
            aux = padre;
            padre = aux.getBestprev();
        }
        if(aux.getEstado() != 'G'){
            aux.setEstado('+');
        }
        return null;
    }
	
	public void pintarCamino(Camino camino) {
		for(int i = 1; i<camino.getLength() - 1; i++) {
			camino.getCoordenadasCamino(i).setEstado('+');
		}
	}
	
	
}
