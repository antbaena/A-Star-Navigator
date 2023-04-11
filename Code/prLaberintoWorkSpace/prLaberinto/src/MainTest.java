import matrixLaberinto.*;

public class MainTest {

	public static void main(String[] args) {
		Board lab = new Board();
		lab.GenerarObstaculos();
		lab.print();
		lab.getCasillaFinal();
		lab.getCasillaInicial();
	}

}
