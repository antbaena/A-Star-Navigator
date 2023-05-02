package matrixLaberinto;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class PrintBoard { 

    public static void printBoardHeruistica(Board board){
        for(int i = 0; i < board.FILAS; i++){
            for(int j = 0; j < board.COLUMNAS; j++){
                System.out.print(board.matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void printBoard(Board board){
    	 for(int i = 0; i < board.FILAS; i++){
             for(int j = 0; j < board.COLUMNAS; j++){
                 System.out.print(board.matrix[i][j].getEstado() + " ");
             }
             System.out.println("");
         }
    }

    public static void printBoardFile(Board board, String name){
        try {
            PrintWriter writer = new PrintWriter(new File(name));

            // Imprime la línea superior de la celda
            for(int k = 0; k < board.COLUMNAS; k++){
                writer.print("+---");
            }
            writer.println("+");

            // Imprime el contenido de la celda
            for(int i = 0; i < board.FILAS; i++){
                for(int j = 0; j < board.COLUMNAS; j++){
                    writer.print("| " + board.matrix[i][j].getEstado() + " ");
                }
                writer.println("|");

                // Imprime la línea de separación entre filas
                for(int k = 0; k < board.COLUMNAS; k++){
                    writer.print("+---");
                }
                writer.println("+");
            }

            // Cierra el objeto PrintWriter
            writer.close();

        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}
