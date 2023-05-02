import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import matrixLaberinto.*;
import nodo.Camino;
import nodo.Nodo;

public class MainTest {

	public static void main(String[] args) {
		System.out.println("Prueba con 0% de obstaculos");
		
		for(int i = 0; i < 100; i++) {
			Board lab = new Board(0);
			int caminoFin = new AStarAlgorithm().buscarCamino(lab.getCasillaInicial());
			if(caminoFin == 0) {
				System.err.println("Camino no Disponible");
			} else {
				PrintBoard.printBoardFile(lab,"output.txt");
				PrintBoard.printBoard(lab);
			}
		}
	}

}
