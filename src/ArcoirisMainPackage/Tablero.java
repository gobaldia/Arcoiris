
package ArcoirisMainPackage;

public class Tablero {
    private char[][] matriz;
    private String posicionOrigen;
    private String posicionDestino;
    private String resultadoAccion;
    private Jugador AutorMovimiento;

    public char[][] getMatriz() {
        return this.matriz;
    }

    public void setMatriz(char[][] unaMatriz) {
        this.matriz = unaMatriz;
    }

    public String getPosicionOrigen() {
        return this.posicionOrigen;
    }

    public void setPosicionOrigen(String posicionOrigen) {
        this.posicionOrigen = posicionOrigen;
    }

    public String getPosicionDestino() {
        return posicionDestino;
    }

    public void setPosicionDestino(String posicionDestino) {
        this.posicionDestino = posicionDestino;
    }

    public String getResultadoAccion() {
        return resultadoAccion; 
    }

    public void setResultadoAccion(String resultadoAccion) {
        this.resultadoAccion = resultadoAccion;
    }

    public Jugador getAutorMovimiento() {
        return AutorMovimiento;
    }

    public void setAutorMovimiento(Jugador AutorMovimiento) {
        this.AutorMovimiento = AutorMovimiento;
    }
    
    public boolean formaMarco(int fila, int col, char[][] mat){
        boolean res;
        if (mat[fila][col] != mat[12-fila][12-col]) {
            res = false;
        } else if (mat[fila][col] != mat[col][12-fila]) {
            res = false;
        } else res = mat[fila][col] == mat[12-col][fila];
        return res;
    }
    
    public boolean movimientoValido(int filaO, int colO, int filaD, int colD, char[][] mat){
        boolean haciaAdentro;
        boolean esDiagonal;
        boolean esRecto;
        boolean estaVacio = true;
        
        haciaAdentro = filaD >= 12-colO && filaD >= colO && colD >= colO && colD >= 12-colO;
        esDiagonal = filaD - filaO == colD - colO;
        esRecto = filaD == filaO || colD == colO;
        
        if (esDiagonal) {
            int inc = 1;
            while (inc <= filaD) {                
                if (mat[filaO + inc][colO + inc] != 'o') {
                    estaVacio = false;
                }
                inc++;
            }
        } else if (esRecto) {
            int inc = 1;
            if (filaO == filaD) {
                while (inc <= colD) {                    
                    if (mat[filaO][colD + inc] != 'o') {
                        estaVacio = false;
                    }
                }
            } else {
                while (inc <= filaD) {                    
                    if (mat[filaD + inc][colD] != 'o') {
                        estaVacio = false;
                    }
                }
            }
        }
        
        
        return haciaAdentro && (esDiagonal || esRecto) && estaVacio;
    }
    
}
