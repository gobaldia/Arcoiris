package ArcoirisMainPackage;

public class Juego {
    
    public static void main(String[] args){
        mostrarTablero();
    }
    
    public static char[][] mostrarTablero(){
        char[][] tablero = new char[15][14];
        int filas = tablero.length;
        int cols = tablero[0].length;
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                tablero[i][j] = 'o';
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
