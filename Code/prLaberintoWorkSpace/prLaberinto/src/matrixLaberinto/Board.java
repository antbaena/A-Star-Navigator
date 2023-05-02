package matrixLaberinto;

import java.util.Random;

import nodo.Nodo;

public class Board {
	int FILAS = 60;
	int COLUMNAS = 80;
	double PorcentajeObs = 0.1;
	int NumObs;
	Nodo matrix[][];
	
	
	//Nodos
	Nodo init, goal;
	

	/**
	 * @param matrix
	 */
	public Board(float numObs) {
		inicializarMatriz();
		PorcentajeObs = numObs;
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
			GenerarFinal();
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
			GenerarInicio();
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
			}
		}
		
	}

}
