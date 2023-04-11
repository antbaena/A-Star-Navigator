import matrixLaberinto.*;
public class MainTest {

	public static void main(String[] args) {
		Laberinto lab = new Laberinto();
		lab.GenerarObstaculos();
		lab.print();
		lab.getCasillaFinal();
		lab.getCasillaInicial();
	}

}
