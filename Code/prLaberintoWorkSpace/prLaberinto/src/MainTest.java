import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import matrixLaberinto.*;
import nodo.Camino;
import nodo.Nodo;

public class MainTest {

	public static void main(String[] args) {
		Board lab = new Board(0.5f);
		//PrintBoard.printBoard(lab);
		//PrintBoard.printBoardHeruistica(lab);
		int caminoFin = new AStarAlgorithm().buscarCamino(lab.getCasillaInicial());
		if(caminoFin == 0) {
			System.err.println("Camino no Disponible");
			PrintBoard.printBoard(lab);
			System.err.println("Camino no Disponible");
		} else {
			PrintBoard.printBoardFile(lab,"output.txt");
			PrintBoard.printBoard(lab);
		}
	}

}
