import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import matrixLaberinto.*;
import nodo.Camino;
import nodo.Nodo;

public class MainTest {

	public static void main(String[] args) {
<<<<<<< HEAD
		Board lab = new Board(0.5f);
=======
<<<<<<< Updated upstream
		Board lab = new Board(0);
>>>>>>> 1246de81cf90a828bb4799ad7a4001e48b760766
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
=======
		System.out.println("Prueba con 0% de obstaculos");
		for(int i = 0; i < 100; i++) {
			Board lab = new Board(0);
			boolean caminoFin = new AStarAlgorithm().buscarCamino(lab.getCasillaInicial());
			if(caminoFin == false) {
				System.err.println("Camino no Disponible");
			} else {
				PrintBoard.printBoardFile(lab,"output.txt");
				PrintBoard.printBoard(lab);
			}
>>>>>>> Stashed changes
		}
	}

}
