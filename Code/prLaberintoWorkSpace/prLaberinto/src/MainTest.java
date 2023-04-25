import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import matrixLaberinto.*;
import nodo.Camino;
import nodo.Nodo;

public class MainTest {

	public static void main(String[] args) {
		Board lab = new Board();
		PrintBoard.printBoard(lab);
		PrintBoard.printBoardHeruistica(lab);
		Camino caminoFin = new AStarAlgorithm().buscarCamino(lab.getCasillaInicial());;
		
	}

}
