package ArcoirisMainPackage;

public class Prueba {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println("*-*-*-*-*- ARCOIRIS -*-*-*-*-*\n");
        menuPrincipal();
        
//        mostrarTablero("I", 1);
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        mostrarTablero2();
    }

    
    public static void menuPrincipal(){
        System.out.println("****** MENU PRINCIPAL ******");
        System.out.println("• [1]Registrar jugador");
        System.out.println("• [2]Configurar partida");
        System.out.println("• [3]JUGAR");
        System.out.println("• [4]Ranking");
        System.out.println("• [5]Replicar partida");
        System.out.println("• [0]Salir");
        System.out.println("****************************");
        System.out.print("      -> Ingrese opción: ");
        
    }
    
    
    
    //**********************************************
    //**********************************************
    //***********************************************/
    public static char[][] mostrarTablero(String modalidad, int cuadradoExterior) {
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
                    tablero[i][j] = letras[i - 2];
                } else {
                    if (modalidad.equals("I") && cuadradoExterior == 1) {
                        if (j == 1 && i < filas) {
                            tablero[i][j] = 'B';
                        }
                    } else {
                        tablero[i][j] = 'o';
                    }

                }
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (i < 2) {
                    System.out.print(tablero[i][j] + " ");
                } else {
                    System.out.print(tablero[i][j] + "|");
                }
            }

            for (int j = 0; j < cols; j++) {
                if (i > 1 && j > 0) {
                    System.out.print("|" + tablero[i][j]);
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }

            if (i > 1) {
                System.out.print("|");
            }

            if (i == tablero.length - 1) {
                System.out.println();
                System.out.println("  +-+-+-+-+-+-+-+-+-+-+-+-+-+");
            }

            System.out.println("");
            if (i > 0) {
                System.out.println(" +-+-+-+-+-+-+-+-+-+-+-+-+-+");
            }
        }
        return tablero;
    }

    //Gabriel agregue este porque al hacer pull tenia mil conflictos.. luego lo vemos.. este muestra bien el tablero..
    //me falta pintarlo q no tuve tiempo y no se porque no me anda la pintada >.<!
    public static char[][] mostrarTablero2() {
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
                    tablero[i][j] = letras[i - 2];
                } else {
                    tablero[i][j] = 'O';
                }
            }
        }

        for (int i = 0; i < filas; i++) {
            if (i > 1) {
                System.out.println("  +-+-+-+-+-+-+-+-+-+-+-+-+-+");
            } else if (i == 0 || i == 1) {
                System.out.print(" ");
            }

            for (int j = 0; j < cols; j++) {
                if (i > 1 && j > 0) {
                    System.out.print("|" + tablero[i][j]);
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }

            if (i > 1) {
                System.out.print("|");
            }

            if (i == tablero.length - 1) {
                System.out.println();
                System.out.println("  +-+-+-+-+-+-+-+-+-+-+-+-+-+");
            }

            System.out.println("");
        }
        return tablero;
    }

    /**
     * **********************************************
     * //**********************************************
    //**********************************************
     */
}
