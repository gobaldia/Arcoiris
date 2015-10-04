
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
    
    
    
}
