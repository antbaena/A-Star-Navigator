import java.io.FileNotFoundException;
import matrixLaberinto.*;

public class MainTest {

	public static void main(String[] args) throws FileNotFoundException {
		double numObs = 0.3;
		Board tablero = new Board(numObs);
		int longCamino = new AStarAlgorithm().buscarCamino(tablero.getCasillaInicial()); // Long del camino(para
																							// analisis)
		System.out.println("Buscando camino con " + Math.round(numObs * 100) + "% de obstaculos...");
		if (longCamino == -1) {
			System.err.println("Camino no Disponible");
			PrintBoard.printBoardFile(tablero, "salida.txt");
			System.err.println("Se ha generado un archivo `salida.txt` con el tablero sin camino.");
		} else {
			PrintBoard.printBoardFile(tablero, "salida.txt");
			System.out.println("Se ha generado un archivo `salida.txt` con el camino generado.");
			System.out.println("Longitud del camino: " + longCamino);
		}
	}

}