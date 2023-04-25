package matrixLaberinto;

import java.util.*;

import nodo.Nodo;

/*
 * We'll use for this problem the A* algorithm
 * */
public class AStarAlgorithm {
	
	private Set<Nodo> nodosEvaluados = new HashSet<>(); 
	private Set<Nodo> nodosAEvaluar = new TreeSet<>();
	private Map<Nodo, Nodo> nodosVisitados = new HashMap<>();
	private int gTentativo = 0;
	private Nodo actual;
	
	public void buscarCamino() {
		while(!nodosAEvaluar.isEmpty()) {
			// current node (minus cost)
			actual = nodosAEvaluar.iterator().next();
			if(actual.getEstado()=='G')
				break; 
			nodosAEvaluar.remove(actual);
			nodosEvaluados.add(actual);
			for(Nodo vecino : actual.vecinos) {
				boolean contains = nodosEvaluados.contains(vecino);
				if(contains) continue;
				gTentativo = actual.getG() + 1; // the distancia between a node and its neighbour is always 1
				if(!contains || gTentativo < vecino.getG()) {
					nodosVisitados.put(vecino, actual);
					vecino.setG(gTentativo);
					vecino.setF(vecino.getG() + vecino.getHeuristica());
					if(contains)
						nodosAEvaluar.add(vecino);
				}
			}
			
			
		}
	}
	
}
