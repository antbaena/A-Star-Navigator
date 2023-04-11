package matrixLaberinto;

import java.util.Random;

public class Board {
	int FILAS = 60;
	int COLUMNAS = 80;
	double PorcentajeObs = 0.3;
	int NumObs;
	int matrix[][];

	/**
	 * @param matrix
	 */
	public Board() {
		matrix = new int[FILAS][COLUMNAS];
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
					if (cont == 0 && matrix[i][j] != 1) {
						matrix[i][j] = 1;
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

		if (matrix[x][y] != 1) {
			matrix[x][y] = 3;
		} else {
			throw new RuntimeException("ERROR la casilla final coincide con un obstaculo");
		}
	}

	public void GenerarInicio() {
		Random rd = new Random();
		int y = rd.nextInt(COLUMNAS);
		int x = rd.nextInt(FILAS);

		if (matrix[x][y] != 1 && matrix[x][y] != 3) {
			matrix[x][y] = 4;
		} else {
			throw new RuntimeException("ERROR la casilla inicial coincide con un obstaculo o casilla final");
		}
	}

	public int NumObstaculos() {
		int cont = 0;
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				if (matrix[i][j] == 1) {
					cont++;
				}

			}

		}

		return cont;
	}

	public void getCasillaInicial() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				if (matrix[i][j] == 3) {
					System.out.println("(" + i + "," + j + ")");
				}
			}
		}

	}

	public void getCasillaFinal() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				if (matrix[i][j] == 4) {
					System.out.println("(" + i + "," + j + ")");
				}
			}
		}
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
