package matrixLaberinto;

import java.util.Random;

import nodo.Nodo;

public class Board {
	int FILAS = 60;
	int COLUMNAS = 80;
	double PorcentajeObs = 0.4;
	int NumObs;
	Nodo matrix[][];
	
	
	//Nodos
	Nodo init, goal;
	

	/**
	 * @param matrix
	 */
	public Board() {
		inicializarMatriz();
		NumObs = (int) (FILAS * COLUMNAS * (PorcentajeObs));
		GenerarObstaculos();
		GenerarFinal();
		GenerarInicio();
		asignarHeuristica();
		asignarvecinos();
	}
	
	private void inicializarMatriz() {
		matrix = new Nodo[FILAS][COLUMNAS];
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				matrix[i][j]=new Nodo(i, j);
			}
		}
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
					if (cont == 0 && matrix[i][j].getEstado() != '*') {
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

	public Nodo getCasillaInicial() {
		return init;
		

	}

	public Nodo getCasillaFinal() {
		return goal;
	}
	
	public void asignarHeuristica() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				matrix[i][j].setHeuristica(goal.getCol(), goal.getFil());
			}
		}
	}
//	public void asignarvecinos() {
//		for (int i = 1; i < FILAS-1; i++) {
//			for (int j = 1; j < COLUMNAS-1; j++) {
//				matrix[i][j].asignarVecinos(matrix[i+1][j]);
//				matrix[i][j].asignarVecinos(matrix[i][j+1]);
//				matrix[i][j].asignarVecinos(matrix[i-1][j]);
//				matrix[i][j].asignarVecinos(matrix[i][j-1]);
//			}
//		}
//		matrix[0][0].asignarVecinos(matrix[1][0]);
//		matrix[0][0].asignarVecinos(matrix[0][1]);
//		matrix[FILAS-1][COLUMNAS-1].asignarVecinos(matrix[FILAS][COLUMNAS-2]);
//		matrix[FILAS-1][COLUMNAS-1].asignarVecinos(matrix[FILAS-2][COLUMNAS]);
//		matrix[0][COLUMNAS-1].asignarVecinos(matrix[1][COLUMNAS-1]);
//		matrix[0][COLUMNAS-1].asignarVecinos(matrix[0][COLUMNAS-2]);
//		matrix[FILAS-1][0].asignarVecinos(matrix[FILAS-2][0]);
//		matrix[FILAS-1][0].asignarVecinos(matrix[FILAS-1][1]);
//		for(int i = 1; i < FILAS-1; i++) {
//			matrix[i][0].asignarVecinos(matrix[i+1][0]);
//			matrix[i][0].asignarVecinos(matrix[i][1]);
//			matrix[i][0].asignarVecinos(matrix[i-1][0]);
//			
//			matrix[i][COLUMNAS-1].asignarVecinos(matrix[i+1][COLUMNAS-1]);
//			matrix[i][COLUMNAS-1].asignarVecinos(matrix[i][COLUMNAS-2]);
//			matrix[i][COLUMNAS-1].asignarVecinos(matrix[i-1][COLUMNAS-1]);
//		}
//		for(int j = 1; j < COLUMNAS-1; j++) {
//			matrix[0][j].asignarVecinos(matrix[0][j+1]);
//			matrix[0][j].asignarVecinos(matrix[1][j]);
//			matrix[0][j].asignarVecinos(matrix[0][j-1]);
//			
//			matrix[0][FILAS-1].asignarVecinos(matrix[FILAS-1][j+1]);
//			matrix[0][FILAS-1].asignarVecinos(matrix[FILAS-2][j]);
//			matrix[0][FILAS-1].asignarVecinos(matrix[FILAS-1][j-1]);
//		}
//	}
	
//	private boolean neighbours(Nodo node) {
//		int x = node.getCol(), y = node.getFil();
//		
//		if(x == 0 && y == 0) {
//			matrix[0][0].asignarVecinos(matrix[1][0]);
//			matrix[0][0].asignarVecinos(matrix[0][1]);
//			return false;
//		} else if(x == FILAS-1 && y == COLUMNAS - 1) {
//			matrix[FILAS-1][COLUMNAS-1].asignarVecinos(matrix[FILAS][COLUMNAS-2]);
//			matrix[FILAS-1][COLUMNAS-1].asignarVecinos(matrix[FILAS-2][COLUMNAS]);
//			return false;
//		} else if(x == 0 && y == COLUMNAS-1) {
//			matrix[0][COLUMNAS-1].asignarVecinos(matrix[1][COLUMNAS-1]);
//			matrix[0][COLUMNAS-1].asignarVecinos(matrix[0][COLUMNAS-2]);
//			return false;
//		} else if(x == FILAS-1 && y == 0) {
//			matrix[FILAS-1][0].asignarVecinos(matrix[FILAS-2][0]);
//			matrix[FILAS-1][0].asignarVecinos(matrix[FILAS-1][1]);
//			return false;
//		} else if(x == 0) {
//			matrix[0][y].asignarVecinos(matrix[0][y+1]);
//			matrix[0][y].asignarVecinos(matrix[0][y-1]);
//			matrix[0][y].asignarVecinos(matrix[1][y]);
//			return false;
//		} else if(y == 0) {
//			matrix[x][0].asignarVecinos(matrix[x+1][0]);
//			matrix[x][0].asignarVecinos(matrix[x-1][0]);
//			matrix[x][0].asignarVecinos(matrix[x][1]);
//			return false;
//		} else if(x == FILAS-1) {
//			matrix[FILAS-1][y].asignarVecinos(matrix[FILAS-2][y]);
//			matrix[FILAS-1][y].asignarVecinos(matrix[FILAS-1][y-1]);
//			matrix[FILAS-1][y].asignarVecinos(matrix[FILAS-1][y+1]);
//			return false;
//		} else if(y == COLUMNAS-1) {
//			matrix[x][COLUMNAS-1].asignarVecinos(matrix[x+1][COLUMNAS-1]);
//			matrix[x][COLUMNAS-1].asignarVecinos(matrix[x-1][COLUMNAS-1]);
//			matrix[x][COLUMNAS-1].asignarVecinos(matrix[x][COLUMNAS-2]);
//			return false;
//		}
//		
//		return true;
//	}
	
	public void neighbours(Nodo n){        
        if(n.getFil()-1>=0){                             
            n.asignarVecinos(matrix[n.getFil() - 1][n.getCol()]);
        }
        if(n.getCol()-1>=0){
        	 n.asignarVecinos(matrix[n.getFil()][n.getCol() - 1]);
        }
        if(n.getFil()+1<FILAS){
        	 n.asignarVecinos(matrix[n.getFil() + 1][n.getCol()]);
        }
        if(n.getCol()+1<COLUMNAS){
        	 n.asignarVecinos(matrix[n.getFil()][n.getCol() + 1]);
        }
    }
	
	public void asignarvecinos() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				neighbours(matrix[i][j]);
//				if(neighbours(matrix[i][j])) {
//					matrix[i][j].asignarVecinos(matrix[i-1][j]);
//					matrix[i][j].asignarVecinos(matrix[i+1][j]);
//					matrix[i][j].asignarVecinos(matrix[i][j-1]);
//					matrix[i][j].asignarVecinos(matrix[i][j+1]);
//				}
			}
		}
		
	}

}
