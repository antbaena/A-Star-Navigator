import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import matrixLaberinto.*;
import nodo.Camino;
import nodo.Nodo;

public class MainTest {

	public static void main(String[] args) {
		Board lab = new Board(0);
		//PrintBoard.printBoard(lab);
		//PrintBoard.printBoardHeruistica(lab);
		boolean caminoFin = new AStarAlgorithm().buscarCamino(lab.getCasillaInicial());
		if(caminoFin == false) {
			System.err.println("Camino no Disponible");
			PrintBoard.printBoard(lab);
			System.err.println("Camino no Disponible");
		} else {
			PrintBoard.printBoardFile(lab,"output.txt");
			PrintBoard.printBoard(lab);
		}
	}

}
