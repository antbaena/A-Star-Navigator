package matrixLaberinto;

public class PrintBoard { 
    public static void printBoard(Board board){
        for(int i = 0; i < board.FILAS; i++){
            for(int j = 0; j < board.COLUMNAS; j++){
                System.out.print(board.matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
