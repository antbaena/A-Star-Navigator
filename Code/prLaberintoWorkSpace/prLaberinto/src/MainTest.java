import matrixLaberinto.*;

public class MainTest {

	public static void main(String[] args) {
		Board lab = new Board();
		PrintBoard.printBoard(lab);
		lab.getCasillaFinal();
		lab.getCasillaInicial();
	}

}
