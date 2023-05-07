package nodo;

import java.util.ArrayList;

public class Nodo {
	private char estado;
	private int fil;
	private int col;
	private Nodo bestprev;
	private int g, f, h;
	public ArrayList<Nodo> vecinos;

	public Nodo(int fil, int col) {
		this.col = col;
		this.estado = ' ';
		this.fil = fil;
		g = f = h = -1; // Inicializamos todas la variables de la función a -1
		bestprev = null;
		vecinos = new ArrayList<>();
	}

	public char getEstado() {
		return estado;
	}

	public int getFil() {
		return fil;
	}

	public int getCol() {
		return col;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getHeuristica() {
		return h;
	}

	public void setBestprev(Nodo nodo) {
		bestprev = nodo;
	}

	public Nodo getBestprev() {
		return bestprev;
	}

	public void setHeuristica(int c, int f) {
		h = DistanciaManhattan(f, c, fil, col);
		// Establecemos como nuestra función heurística la Distancia de Manhattan
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public void asignarVecinos(Nodo n) {
		vecinos.add(n); // Añadimos los vecinos a su respectivo ArrayList
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	private int DistanciaManhattan(int f, int c, int fo, int co) {
		return Math.abs(f - fo) + Math.abs(c - co);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(h);
		return sb.toString();
	}

	// Métodos necesarios para la ordenación y búsquedas en los ArrayLists

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Nodo a) && a.fil == f && a.col == col;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(fil) + Integer.hashCode(col);
	}
}