package ArcoirisMainPackage;

public class Juego {
     public static final String ANSI_RED = "\u001B[31m";
     public static final String ANSI_RESET = "\u001B[0m";
    
    public static void main(String[] args){
        mostrarTablero();
    }
    
    public static char[][] mostrarTablero(){
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
                    tablero[i][j] = 'O';
                }
            }
        }
        
        for (int i = 0; i < filas; i++) {            
            if(i > 1){
                System.out.println("  +-+-+-+-+-+-+-+-+-+-+-+-+-+");
            } else if( i == 0 || i == 1){
                System.out.print(" ");
            }
            
            for (int j = 0; j < cols; j++) {
                if(i > 1 && j > 0){
                    System.out.print("|" + tablero[i][j]);
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            
            if(i > 1){
                System.out.print("|");
            }
            
            if(i == tablero.length -1){
                System.out.println();
                System.out.println("  +-+-+-+-+-+-+-+-+-+-+-+-+-+");
            }

            System.out.println("");
        }
        return tablero;
    }
}
