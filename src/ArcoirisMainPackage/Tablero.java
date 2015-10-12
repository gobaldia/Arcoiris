
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
    
    public char[][] generarMatrizEnL(int marcoInicio) {
        char[][] unaMatriz = new char[13][13];
        
        for (int i = 0; i < unaMatriz.length; i++) {
            for (int j = 0; j < unaMatriz[i].length; j++) {
                unaMatriz[i][j] = 'O';
            }
        }
        
        boolean bandera = true;
        int contador = 0;

        for (int i = 0; i < unaMatriz.length; i++) {
            for (int j = 0; j < unaMatriz[0].length; j++) {
                
                if (medirDistanciaMarco(i, j, marcoInicio)) {
                    //Manejo las fichas dentro del marco que se pasa por parametro
                    bandera = !bandera;
                    
                    if(contador >= 3){
                        //Este codigo se corre solo para la ultima linea del marco seleccionado
                        unaMatriz[i][j-2] = 'B';
                        unaMatriz[i][j] = 'B';
                        
                        if(unaMatriz.length - marcoInicio == j) {
                            unaMatriz[i][j] = 'N';
                        }                        
                    } else {
                        if (bandera) {
                        unaMatriz[i][j] = 'N';
                        bandera = false;
                        } else {
                            unaMatriz[i][j] = 'B';
                        }
                    }
                    
                    if (i > 6) {
                        contador++;
                    }
                }
            }
            
            contador = 0;
            bandera = true;
        }

        return unaMatriz;
    }
    
    private boolean medirDistanciaMarco(int fila, int columna, int marcoAPintar) {
        boolean bandera = false;

        switch (marcoAPintar) {
            case 1:
                if ((fila == 0 && (columna >= 0 && columna <= 12))
                        || (columna == 0 && (fila >= 0 && fila <= 12))) {
                    bandera = true;
                } else if ((fila == 12 && (columna >= 0 && columna <= 12))
                        || (columna == 12 && (fila >= 0 && fila <= 12))) {
                    bandera = true;
                }
                break;
            case 2:
                if ((fila == 1 && (columna >= 1 && columna <= 11))
                        || (columna == 1 && (fila >= 1 && fila <= 11))) {
                    bandera = true;
                } else if ((fila == 11 && (columna >= 1 && columna <= 11))
                        || (columna == 11 && (fila >= 1 && fila <= 11))) {
                    bandera = true;
                }
                break;
            case 3:
                if ((fila == 2 && (columna >= 2 && columna <= 10))
                        || (columna == 2 && (fila >= 2 && fila <= 10))) {
                    bandera = true;
                } else if ((fila == 10 && (columna >= 2 && columna <= 10))
                        || (columna == 10 && (fila >= 2 && fila <= 10))) {
                    bandera = true;
                }
                break;
            case 4:
                if ((fila == 3 && (columna >= 3 && columna <= 9))
                        || (columna == 3 && (fila >= 3 && fila <= 9))) {
                    bandera = true;
                } else if ((fila == 9 && (columna >= 3 && columna <= 9))
                        || (columna == 9 && (fila >= 3 && fila <= 9))) {
                    bandera = true;
                }
                break;
            case 5:
                if ((fila == 4 && (columna >= 4 && columna <= 8))
                        || (columna == 4 && (fila >= 4 && fila <= 8))) {
                    bandera = true;
                } else if ((fila == 8 && (columna >= 4 && columna <= 8))
                        || (columna == 8 && (fila >= 4 && fila <= 8))) {
                    bandera = true;
                }
                break;
            case 6:
                if ((fila == 5 && (columna >= 5 && columna <= 7))
                        || (columna == 5 && (fila >= 5 && fila <= 7))) {
                    bandera = true;
                } else if ((fila == 7 && (columna >= 5 && columna <= 7))
                        || (columna == 7 && (fila >= 5 && fila <= 7))) {
                    bandera = true;
                }
                break;
            default:
                break;
        }

        return bandera;
    }
}
