package ArcoirisMainPackage;

import java.io.Serializable;
import java.util.Random;

public class Tablero implements Serializable {

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

    public void setAutorMovimiento(Jugador autorMovimiento) {
        this.AutorMovimiento = autorMovimiento;
    }

    public boolean formaMarco(int fila, int col, Jugador unJugador) {
        char[][] mat = this.getMatriz();

        boolean res;
        if (mat[fila][col] != mat[12 - fila][12 - col]) {
            res = false;
        } else if (mat[fila][col] != mat[col][12 - fila]) {
            res = false;
        } else {
            res = mat[fila][col] == mat[12 - col][fila];
        }

        if (res) {
            mat[6][6] = unJugador.getTipoFicha();
        }

        return res;
    }

    private String convertirPosicionesComida(String datoAConvertir) {
        String result = "x";
        String[] comidas = datoAConvertir.split("-");
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};

        for (int i = 0; i < comidas.length; i += 2) {
            result += letras[Integer.parseInt(comidas[i])] + "" + (Integer.parseInt(comidas[i + 1]) + 1);
        }

        return result;
    }

    public boolean existenMovimientos(Jugador autorMovimiento) {
        boolean resultado = false;
        char[][] mat = this.getMatriz();

        int[] movsX = {-1, 0, 1, 0, -1, 1, 1, -1};
        int[] movsY = {0, 1, 0, -1, 1, 1, -1, -1};

        int nuevaFila = 0;
        int nuevaColumna = 0;
        int contador = 0;

        for (int fila = 0; fila > mat.length; fila++) {
            for (int col = 0; col > mat[0].length; col++) {
                if (mat[fila][col] == autorMovimiento.getTipoFicha()) {

                    if (!resultado) {

                        do {
                            nuevaFila = fila + movsX[contador];
                            nuevaColumna = col + movsY[contador];
                            contador++;

                            if (movimientoValido(fila, col, nuevaFila, nuevaColumna, autorMovimiento)) {
                                resultado = true;//Si encuentro almenos 1 movimiento valido no sigo verificando la matriz
                            }
                        } while (contador < movsX.length);

                        contador = 0;
                        nuevaFila = 0;
                        nuevaColumna = 0;
                    }

                }
            }
        }

        return resultado;
    }

    public boolean movimientoValido(int filaO, int colO, int filaD, int colD, Jugador autorMovimiento) {
        boolean haciaAdentro;
        boolean esDiagonal;
        boolean esRecto;
        boolean estaVacio = true;
        boolean aMarcoInterno;
        boolean resultado;

        char[][] mat = this.getMatriz();

        if (filaD == 6 && colD == 6) {
            resultado = false;
        } else {
            if (mat[filaO][colO] == autorMovimiento.getTipoFicha()) {
                haciaAdentro = Math.abs(6 - filaO) > Math.abs(6 - filaD) || Math.abs(6 - colO) > Math.abs(6 - colD);
                esDiagonal = Math.abs(filaD - filaO) == Math.abs(colD - colO);
                esRecto = filaD == filaO || colD == colO;
                aMarcoInterno = consultaMarco(filaO, colO) < consultaMarco(filaD, colD);

                if (esDiagonal) {
                    int inc = 1;
                    if (filaD > filaO && colD > colO) {
                        while (filaO + inc <= filaD) {
                            if (mat[filaO + inc][colO + inc] != 'O') {
                                estaVacio = false;
                            }
                            inc++;
                        }
                    } else if (filaD < filaO && colD < colO) {
                        while (filaO - inc >= filaD) {
                            if (mat[filaO - inc][colO - inc] != 'O') {
                                estaVacio = false;
                            }
                            inc++;
                        }
                    } else if (filaD > filaO && colD < colO) {
                        while (filaO + inc <= filaD) {
                            if (mat[filaO + inc][colO - inc] != 'O') {
                                estaVacio = false;
                            }
                            inc++;
                        }
                    } else if (filaD < filaO && colD > colO) {
                        while (filaO - inc >= filaD) {
                            if (mat[filaO - inc][colO + inc] != 'O') {
                                estaVacio = false;
                            }
                            inc++;
                        }
                    }

                } else if (esRecto) {
                    int inc = 1;
                    if (filaO == filaD) {
                        if (colO < colD) {
                            while (colO + inc <= colD) {
                                if (mat[filaO][colO + inc] != 'O') {
                                    estaVacio = false;
                                }
                                inc++;
                            }
                        } else {
                            while (colO - inc >= colD) {
                                if (mat[filaO][colO - inc] != 'O') {
                                    estaVacio = false;
                                }
                                inc++;
                            }
                        }

                    } else {
                        if (filaO < filaD) {
                            while (filaO + inc <= filaD) {
                                if (mat[filaO + inc][colO] != 'O') {
                                    estaVacio = false;
                                }
                                inc++;
                            }
                        } else {
                            while (filaO - inc >= filaD) {
                                if (mat[filaO - inc][colO] != 'O') {
                                    estaVacio = false;
                                }
                                inc++;
                            }
                        }

                    }
                }

                resultado = haciaAdentro && (esDiagonal || esRecto) && estaVacio && aMarcoInterno;
            } else {
                resultado = false;
            }
        }

        return resultado;
    }

    public char[][] generarMatrizConFichasEnL(int marcoInicio) {
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

                    if (contador >= 3) {
                        //Este codigo se corre solo para la ultima linea del marco seleccionado
                        unaMatriz[i][j - 2] = 'B';
                        unaMatriz[i][j] = 'B';

                        if (unaMatriz.length - marcoInicio == j) {
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

        insertarPiedras(unaMatriz, marcoInicio);

        return unaMatriz;
    }

    public char[][] generarMatrizConFichasAlAzar(int marcoInicio) {
        char[][] unaMatriz = new char[13][13];

        for (int i = 0; i < unaMatriz.length; i++) {
            for (int j = 0; j < unaMatriz[i].length; j++) {
                unaMatriz[i][j] = 'O';
            }
        }

        int fichas = 0;
        int mitad = 0;

        switch (marcoInicio) {
            case 1:
                fichas = 48;
                mitad = 24;
                break;
            case 2:
                fichas = 40;
                mitad = 20;
                break;
            case 3:
                fichas = 32;
                mitad = 16;
                break;
            case 4:
                fichas = 24;
                mitad = 12;
                break;
        }

        char[] aux = new char[fichas];
        for (int i = 0; i < aux.length; i++) {
            if (i < mitad) {
                aux[i] = 'B';
            } else {
                aux[i] = 'N';
            }
        }

        desordenaArray(aux);

        int fichasRestantes = fichas;

        for (int i = 0; i < unaMatriz.length; i++) {
            for (int j = 0; j < unaMatriz[0].length; j++) {

                if (medirDistanciaMarco(i, j, marcoInicio)) {
                    unaMatriz[i][j] = aux[fichasRestantes - 1];
                    fichasRestantes--;
                }
            }
        }

        return unaMatriz;
    }

    private void desordenaArray(char[] unArray) {
        int j;
        Random random = new Random();
        for (int i = unArray.length - 1; i > 0; i--) {
            j = random.nextInt(i + 1);
            if (j != i) {
                unArray[j] ^= unArray[i];
                unArray[i] ^= unArray[j];
                unArray[j] ^= unArray[i];
            }
        }
    }

    public char[][] generarMatrizConFichasEnI(int marcoInicio) {
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
                    if (i == marcoInicio - 1 && j == marcoInicio - 1) {
                        unaMatriz[i][j] = 'B';
                    } else if (i == marcoInicio - 1 && j != marcoInicio - 1) {
                        unaMatriz[i][j] = 'N';
                    } else if (i == unaMatriz.length - marcoInicio && j != unaMatriz.length - marcoInicio) {
                        unaMatriz[i][j] = 'N';
                    } else if (i == unaMatriz.length - marcoInicio && j == unaMatriz.length - marcoInicio) {
                        unaMatriz[i][j] = 'B';
                    } else {
                        unaMatriz[i][j] = 'B';
                    }
                }
            }

            contador = 0;
            bandera = true;
        }

        insertarPiedras(unaMatriz, marcoInicio);

        return unaMatriz;
    }

    public void insertarPiedras(char[][] mat, int marcoInicio) {

        int cant = 3;

        // defino el mínimo y el máximo para el random
        int min = 1;
        int max = 11;

        Random r = new Random();
        while (cant > 0) {
            int i = r.nextInt(max - min + 1) + min;
            int j = r.nextInt(max - min + 1) + min;
            for (int k = marcoInicio + 1; k < 6; k++) {
                if (medirDistanciaMarco(i, j, k) && mat[i][j] != 'P') {
                    mat[i][j] = 'P';
                    cant--;
                }
            }
        }

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

    public String comerFichas(int fila, int col) {

        char[][] mat = this.getMatriz();
        String resultadoComida = "";

        // defino mis vectores de movimientos
        int[] movsX = {-1, 0, 1, 0, -1, 1, 1, -1};
        int[] movsY = {0, 1, 0, -1, 1, 1, -1, -1};

        // defino las nuevas coordenadas
        int nuevaFila = fila;
        int nuevaColumna = col;

        int contador = 0;

        // creo las banderas que harían llegar al final para esa dirección
        boolean meEncuentro = false;
        boolean encuentroO = false;
        boolean borde = false;
        boolean encuentroP = false;

        for (int i = 0; i < movsX.length; i++) {
            while (!(meEncuentro || encuentroO || borde || encuentroP)) {
                nuevaFila = nuevaFila + movsX[i];
                nuevaColumna = nuevaColumna + movsY[i];
                if (nuevaFila == 0 || nuevaColumna == 0 || nuevaFila == mat.length - 1 || nuevaColumna == mat[0].length - 1) {
                    borde = true;
                } else if (mat[nuevaFila][nuevaColumna] == 'O') {
                    encuentroO = true;
                } else if (mat[nuevaFila][nuevaColumna] == 'P') {
                    encuentroP = true;
                } else if (mat[nuevaFila][nuevaColumna] == mat[fila][col]) {
                    meEncuentro = true;
                }
            }
            if (meEncuentro || (borde && mat[nuevaFila][nuevaColumna] == mat[fila][col])) {
                while (nuevaFila != fila || nuevaColumna != col) {
                    mat[nuevaFila][nuevaColumna] = mat[fila][col];

                    if (contador >= 1) {//Si el contador es mayor a 1 es porque realicé una comida.
                        resultadoComida += nuevaFila + "-" + nuevaColumna + "-";
                    }
                    contador++;

                    nuevaFila = nuevaFila - movsX[i];
                    nuevaColumna = nuevaColumna - movsY[i];
                }
                contador = 0;
            }
            meEncuentro = false;
            encuentroO = false;
            borde = false;
            encuentroP = false;
            nuevaFila = fila;
            nuevaColumna = col;
        }

        if (!resultadoComida.isEmpty()) {
            resultadoComida = convertirPosicionesComida(resultadoComida);
        }

        return resultadoComida;
    }

    public int consultaMarco(int i, int j) {
        int marco = 0;
        if (medirDistanciaMarco(i, j, 1)) {
            marco = 1;
        } else if (medirDistanciaMarco(i, j, 2)) {
            marco = 2;
        } else if (medirDistanciaMarco(i, j, 3)) {
            marco = 3;
        } else if (medirDistanciaMarco(i, j, 4)) {
            marco = 4;
        } else if (medirDistanciaMarco(i, j, 5)) {
            marco = 5;
        } else if (medirDistanciaMarco(i, j, 6)) {
            marco = 6;
        }
        return marco;
    }
}
