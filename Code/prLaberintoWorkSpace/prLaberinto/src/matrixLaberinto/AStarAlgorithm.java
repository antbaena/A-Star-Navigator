package matrixLaberinto;

import java.util.*;

import nodo.Camino;
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
	private ArrayList<Nodo> caminoFinal;
	
	public Camino buscarCamino(Nodo init) {
		init.setG(0);
		init.setF(init.getHeuristica());
		nodosAEvaluar.add(init);
		while(!nodosAEvaluar.isEmpty()) {
			// current node (minus cost)
			actual = nodosAEvaluar.iterator().next();
			
			if(actual.getEstado()=='G')
				return reconstruirCamino(actual); 
			
			nodosAEvaluar.remove(actual);
			nodosEvaluados.add(actual);
			
			for(Nodo vecino : actual.vecinos) {
			
				boolean containsNotEv = nodosAEvaluar.contains(vecino);
				if(nodosEvaluados.contains(vecino) || vecino.getEstado() == '*') continue;
				gTentativo = actual.getG() + 1; // the distancia between a node and its neighbour is always 1
				if(!containsNotEv || gTentativo < vecino.getG()) {
					nodosVisitados.put(vecino, actual);
					vecino.setG(gTentativo);
					vecino.setF(vecino.getG() + vecino.getHeuristica());
					if(!containsNotEv)
						nodosAEvaluar.add(vecino);
				}
			}
			
			
		}
		return null;
	}
	
	public Camino reconstruirCamino(Nodo fin) {
		Nodo node = fin;
		Camino camino = new Camino();
		while(node != null) {
			if(node.getEstado() == ' ')
				node.setEstado('+');
			camino.prependWayPoint(node);
			node = nodosVisitados.getOrDefault(node,null);
		}
		
		return camino;
	}
	
	
}
