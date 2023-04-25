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
			actual = nodosAEvaluar.iterator().next();
			//current
			if(actual.getEstado()=='G')
				break; 
			nodosAEvaluar.remove(actual);
			nodosEvaluados.add(actual);
			// node change -> public ArrayList vecinos;
			for(Nodo vecino : actual.vecinos) {
				if(nodosEvaluados.contains(vecino)) continue;
				//gTentativo = actual.getG() + Nodo.DistanciaManhattan(ve);
			}
			
			
		}
	}
	
}
