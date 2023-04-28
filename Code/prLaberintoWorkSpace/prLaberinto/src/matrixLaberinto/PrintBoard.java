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
        // Creamos una ventana y un panel
        JFrame frame = new JFrame("Laberinto");
        JPanel panel = new JPanel();

        // Creamos una tabla y un modelo de tabla para almacenar los datos de la matriz
        Object[][] data = new Object[board.FILAS][board.COLUMNAS];
        String[] columnNames = new String[board.COLUMNAS];

        for(int i = 0; i < board.COLUMNAS; i++){
            columnNames[i] = "";
        }

        for(int i = 0; i < board.FILAS; i++){
            for(int j = 0; j < board.COLUMNAS; j++){
                data[i][j] = board.matrix[i][j].getEstado();
            }
        }

        JTable table = new JTable(data, columnNames);

        // Agregamos la tabla a un objeto JScrollPane para poder desplazarnos por ella
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 500));

        // Agregamos el JScrollPane al panel y el panel a la ventana
        panel.add(scrollPane);
        frame.getContentPane().add(panel);

        // Hacemos visible la ventana
        frame.pack();
        frame.setVisible(true);
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
