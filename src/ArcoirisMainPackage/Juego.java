package ArcoirisMainPackage;

public class Juego {
    
    public static void main(String[] args){
        mostrarTablero("I", 1);
    }
    
    public static char[][] mostrarTablero(String modalidad, int cuadradoExterior){
        char[][] tablero = new char[15][14];
        int filas = tablero.length;
        int cols = tablero[0].length;
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
        char[] numeros = {' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', '1', '1', '1', '1'};
        char[] numeros2 = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', '1', '2', '3'};
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0) {
                    tablero[i][j] = numeros[j];
                } else if (i == 1) {
                    tablero[i][j] = numeros2[j];
                } else if (j == 0) {
                    tablero[i][j] = letras[i-2];
                } else {
                    if (modalidad.equals("I") && cuadradoExterior == 1) {
                            if (j == 1 && i < filas) {
                                tablero[i][j] = 'B';
                        }
                        } else {
                        tablero[i][j] = 'o';
                    }
                    
                }           }
        }
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (i < 2) {
                    System.out.print(tablero[i][j] + " ");
                } else {
                System.out.print(tablero[i][j] + "|");
                }
            }
            System.out.println("");
            if (i > 0) {
                System.out.println(" +-+-+-+-+-+-+-+-+-+-+-+-+-+");
            }
        }
        
        
        return tablero;
    }
}
