import matrixLaberinto.*;

public class MainTest {

	public static void main(String[] args) {
		Board lab = new Board();
		lab.GenerarObstaculos();
		PrintBoard.printBoard(lab);
		
		lab.getCasillaFinal();
		lab.getCasillaInicial();
	}

}
