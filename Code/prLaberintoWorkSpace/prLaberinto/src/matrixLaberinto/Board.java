package matrixLaberinto;

import java.util.Random;

import nodo.Nodo;

public class Board {
	int FILAS = 60;
	int COLUMNAS = 80;
	double PorcentajeObs = 0.3;
	int NumObs;
	Nodo matrix[][];
	
	
	//Nodos
	Nodo init, goal;
	

	/**
	 * @param matrix
	 */
	public Board() {
		matrix = new Nodo[FILAS][COLUMNAS];
		NumObs = (int) (FILAS * COLUMNAS * (PorcentajeObs));
		GenerarObstaculos();
		GenerarFinal();
		GenerarInicio();
	}

	public void GenerarObstaculos() {
		while (NumObs > 0) {
			Random rd = new Random();
			int cont = rd.nextInt((COLUMNAS * FILAS));
			boolean find = false;
			int i = 0;
			while (!find && i < FILAS) {
				int j = 0;
				while (!find && j < COLUMNAS) {
					if (cont == 0 && matrix[i][j].getEstado()=='*') {
						matrix[i][j].setEstado('*');
						NumObs--;
						find = !find;
					} else {
						cont--;
					}
					j++;
				}
				i++;
			}
		}
	}

	public void GenerarFinal() {
		Random rd = new Random();
		int y = rd.nextInt(COLUMNAS);
		int x = rd.nextInt(FILAS);

		if ( matrix[x][y].getEstado() !='*') {
			goal = matrix[x][y];
			matrix[x][y].setEstado('G');
		} else {
			throw new RuntimeException("ERROR la casilla final coincide con un obstaculo");
		}
	}

	public void GenerarInicio() {
		Random rd = new Random();
		int y = rd.nextInt(COLUMNAS);
		int x = rd.nextInt(FILAS);

		if ( matrix[x][y].getEstado()!='*' &&  matrix[x][y].getEstado()!='G') {
			init = matrix[x][y];
			matrix[x][y].setEstado('I');
		} else {
			throw new RuntimeException("ERROR la casilla inicial coincide con un obstaculo o casilla final");
		}
	}

	public int NumObstaculos() {
		int cont = 0;
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				if (matrix[i][j].getEstado()=='*') {
					cont++;
				}

			}

		}

		return cont;
	}

	public void getCasillaInicial() {
		System.out.println(init.getCol() +" "	+	init.getFil());
		

	}

	public void getCasillaFinal() {
		System.out.println(goal.getCol() +" "	+	goal.getFil());
	}

	public void print() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
