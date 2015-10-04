package ArcoirisMainPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Prueba {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println("*-*-*-*-*- ARCOIRIS -*-*-*-*-*\n");

        //Creo el Scanner para manejar los datos ingresados por el usuario.        
        Scanner input = new Scanner(System.in);

        //Creo una instancia de Juego con el cual voy a manejar el sistema.
        Juego miJuego = new Juego();

        int opcion = -1;

        //Manejo de menu
        while (opcion != 0) {
            try {
                System.out.println();
                MostrarMenuPrincipal();

                opcion = input.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo del juego...");
                        break;
                    case 1:// Registrar Jugador
                        CrearJugador(input, miJuego);
                        System.out.println("\nPresione enter para continuar...");
                        LeoComando();
                        break;
                    case 2: // Configurar partida
                        break;
                    case 3: //Jugar
                        break;
                    case 4: //Ranking
                        break;
                    case 5: //Replicar partida
                        break;
                    default:
                        System.out.println("\n¡Error!, Opción no existe");
                        break;
                }
            } catch (InputMismatchException ex) {
                input.nextLine();
                System.out.println("\n¡ERROR!, Solo números son permitidos...");
            }
        }//Fin while
    }

    public static void MostrarMenuPrincipal() {
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

    public static void CrearJugador(Scanner scr, Juego unJuego) {
        System.out.println("\n(⌐■_■) Registrar un nuevo jugador en el sistema");

        String unNombre;
        String unAlias;
        int unaEdad;
        String textVar;

        scr.nextLine();
        Jugador unJugador = new Jugador();

        System.out.println("\n****Ingrese datos del Jugador****");
        System.out.print("Ingrese su nombre: ");
        unNombre = scr.nextLine();
        unJugador.setNombre(unNombre);

        System.out.print("Ingrese un alias: ");
        boolean bandera = false;
        while (!bandera) {
            textVar = scr.nextLine();
            unJugador.setAlias(textVar);

            //Verifico que no exista otro operador con la misma cédula
            if (unJuego.existeJugador(unJugador)) {
                System.out.print("El alias ya existe, por favor ingrese otro: ");
            } else {
                System.out.print("Ingrese su edad: ");

                while (!bandera) {
                    textVar = scr.nextLine();

                    //Verifico que el usuario solo ingrese números
                    if (Pattern.matches("[0-9]+", textVar)) {
                        unaEdad = Integer.parseInt(textVar);

                        //Valido que sea una cantidad de años coherente
                        if (unaEdad >= 0 && unaEdad < 100) {
                            unJugador.setEdad(unaEdad);

                            unJuego.getListaDeJugadores().add(unJugador);
                            System.out.println("\nRegistro exitoso!");
                            bandera = true;//Termino el bucle, y vuelvo al menú
                        } else {
                            System.out.print("Por favor ingrese una edad real: ");
                        }
                    } else {
                        System.out.print("Solo números son permitidos, ingrese otra edad: ");
                    }
                }
            }
        }
    }

    //Este método se utiliza para esperar que el usuario presione la tecla Enter para continuar
    private static void LeoComando() {
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("¡Error inesperado!, " + e.toString());
        }
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
     * //**********************************************
     */
}
