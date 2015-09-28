package ArcoirisMainPackage;

public class Juego {
    
    public static void main(String[] args){
        mostrarTablero();
    }
    
    public static char[][] mostrarTablero(){
        char[][] tablero = new char[15][14];
        int filas = tablero.length;
        int cols = tablero[0].length;
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
        char[] numeros = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '1', '1', '1', '1'};
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j > 0) {
                    tablero[i][j] = numeros[j+1];
                }
//                tablero[i][j] = 'o';
            }
        }
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
        
        
        return tablero;
    }
}
