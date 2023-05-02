import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import matrixLaberinto.*;
import nodo.Camino;
import nodo.Nodo;

public class MainTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter("data.csv");
		int error, error2;
		Board lab;
		int caminoFin;
		
		for(double n = 0; n <= 1; n += 0.03) {
			error = 0;
			error2 = 0;
			pw.print(String.format("%.2f;", n));
			for(int i = 0; i < 100; i++) {
				try {
					lab = new Board(n);
					caminoFin = new AStarAlgorithm().buscarCamino(lab.getCasillaInicial());
					if(caminoFin == 0) {
						pw.print(-1+";");
						error++;
					} else {
						pw.print(caminoFin+";");
					}
				} catch(Exception e) {
					pw.print(-2+";");
					error2++;
				}
			}
			pw.println(String.format("%d;%d;%d", error, error2, (100 - error - error2)));
		}
		pw.close();
	}

}
