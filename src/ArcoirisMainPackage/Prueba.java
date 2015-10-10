package ArcoirisMainPackage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Prueba {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println("*-*-*-*-*- ARCOIRIS -*-*-*-*-*\n");

        mostrarTablero();

        //Creo el Scanner para manejar los datos ingresados por el usuario.        
        Scanner input = new Scanner(System.in);

        //Creo una instancia de Juego con el cual voy a manejar el sistema.
        Juego miJuego = new Juego();

        //*******//
        Jugador j1 = new Jugador("Pepe", "nikPepe", 13);
        Jugador j2 = new Jugador("Juan", "cccccc", 15);
        Jugador j3 = new Jugador("Eliana", "bbbbb", 25);
        Jugador j4 = new Jugador("Lorena", "aaaaaa", 23);
        Jugador j5 = new Jugador("Hector", "adsads", 59);
        
        j4.setGanadas(10);
        j2.setGanadas(5);

        miJuego.agregarJugador(j1);
        miJuego.agregarJugador(j2);
        miJuego.agregarJugador(j3);
        miJuego.agregarJugador(j4);
        miJuego.agregarJugador(j5);
        //*****//

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
                        ConfigurarPartida(input, miJuego);
                        System.out.println("\nPresione enter para continuar...");
                        LeoComando();
                        break;
                    case 3: //Jugar
                        break;
                    case 4: //Ranking
                        miJuego.obtenerRanking();
                        mostrarRanking(miJuego);
                        break;
                    case 5: //Replicar partida
                        break;
                    default:
                        System.out.println("\n¡Error!, Opción no existe");
                        break;
                }
            } catch (InputMismatchException ex) {
                input.nextLine();
                System.out.println("\n¡ERROR!, Solo números son permitidos..." + "¯\\_(ツ)_/¯");
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
        System.out.println("\n(⌐■_■) Registro de nuevo jugador");

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

    public static void ConfigurarPartida(Scanner scr, Juego unJuego) {
        System.out.println("\n(⌐■_■) Configurar partida");

        if (unJuego.getListaDeJugadores().size() >= 2) {
            if (AgregarJugadoresaPartida(scr, unJuego)) {
                String textVar;
                boolean bandera = false;
                
                System.out.println("\nElija el marco donde se distribuiran las fichas iniciales");
                System.out.print("Ingrese 1, 2, 3 o 4 siendo 1 el cuadrado más externo: ");
                while (!bandera) {
                    textVar = scr.nextLine();
                }

            }
        } else {
            System.out.println("\nNo es posible configurar la partida, deben existir al menos 2 jugadores registrados.");
        }
    }

    public static boolean AgregarJugadoresaPartida(Scanner scr, Juego unJuego) {
        boolean resultado = false;

        ArrayList<Jugador> listaJugadores = unJuego.getListaDeJugadores();

        System.out.println("\n****Lista de jugadores****");
        for (int i = 0; i < listaJugadores.size(); i++) {
            System.out.println(i + 1 + ". " + listaJugadores.get(i).toString());
        }

        String textVar;
        int jugadorElejido;
        scr.nextLine();
        boolean bandera = false;

        System.out.print("\nElija jugador A: ");
        while (!bandera) {
            textVar = scr.nextLine();

            if (Pattern.matches("[0-9]+", textVar)) {
                jugadorElejido = Integer.parseInt(textVar);

                if (jugadorElejido > 0 && jugadorElejido <= listaJugadores.size()) {
                    Partida unaPartida = new Partida();
                    unaPartida.agregarJugadorA(listaJugadores.get(jugadorElejido - 1));

                    ArrayList<Jugador> listaSinJugadorSeleccionado = new ArrayList<Jugador>();
                    for (int i = 0; i < listaJugadores.size(); i++) {
                        if (i != (jugadorElejido - 1)) {
                            listaSinJugadorSeleccionado.add(listaJugadores.get(i));
                        }
                    }

                    for (int i = 0; i < listaSinJugadorSeleccionado.size(); i++) {
                        System.out.println(i + 1 + ". " + listaSinJugadorSeleccionado.get(i).toString());
                    }

                    System.out.print("\nElija jugador B: ");
                    while (!bandera) {
                        textVar = scr.nextLine();
                        if (Pattern.matches("[0-9]+", textVar)) {
                            jugadorElejido = Integer.parseInt(textVar);

                            if (jugadorElejido > 0 && jugadorElejido <= listaSinJugadorSeleccionado.size()) {
                                unaPartida.agregarJugadorB(listaSinJugadorSeleccionado.get(jugadorElejido - 1));
                                bandera = true;
                                resultado = bandera;
                            } else {
                                System.out.print("Jugador invalido, elija un jugador de la lista: ");
                            }
                        } else {
                            System.out.print("Solo numeros son permitidos: ");
                        }
                    }
                } else {
                    System.out.print("Jugador invalido, elija un jugador de la lista: ");
                }
            } else {
                System.out.print("Solo numeros son permitidos: ");
            }
        }

        return resultado;
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
    //ToDo: Debo pasale una matriz por parametro
    public static char[][] mostrarTablero() {
        char[][] tablero = new char[13][13];

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = 'O';
            }
        }

        int filas = tablero.length;
        int cols = tablero[0].length;
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
        char[] numeros = {' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', '1', '1', '1', '1'};
        char[] numeros2 = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '0', '1', '2', '3'};

        for (int i = 0; i < numeros.length; i++) {
            System.out.print(" " + numeros[i]);
        }
        System.out.println();
        for (int i = 0; i < numeros2.length; i++) {
            System.out.print(" " + numeros2[i]);
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            System.out.println("  +-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.print(letras[i] + " ");

            for (int j = 0; j < cols; j++) {
                if (medirDistanciaMarco(i, j, 1)) {
                    if (tablero[i][j] == 'B' || tablero[i][j] == 'N') {

                    } else {
                        System.out.print("|" + ANSI_RED + tablero[i][j] + ANSI_RESET);
                    }
                } else if (medirDistanciaMarco(i, j, 2)) {
                    if (tablero[i][j] == 'B' || tablero[i][j] == 'N') {

                    } else {
                        System.out.print("|" + ANSI_PURPLE + tablero[i][j] + ANSI_RESET);
                    }
                } else if (medirDistanciaMarco(i, j, 3)) {
                    if (tablero[i][j] == 'B' || tablero[i][j] == 'N') {

                    } else {
                        System.out.print("|" + ANSI_YELLOW + tablero[i][j] + ANSI_RESET);
                    }
                } else if (medirDistanciaMarco(i, j, 4)) {
                    if (tablero[i][j] == 'B' || tablero[i][j] == 'N') {

                    } else {
                        System.out.print("|" + ANSI_GREEN + tablero[i][j] + ANSI_RESET);
                    }
                } else if (medirDistanciaMarco(i, j, 5)) {
                    if (tablero[i][j] == 'B' || tablero[i][j] == 'N') {

                    } else {
                        System.out.print("|" + ANSI_CYAN + tablero[i][j] + ANSI_RESET);
                    }
                } else if (medirDistanciaMarco(i, j, 6)) {
                    if (tablero[i][j] == 'B' || tablero[i][j] == 'N') {

                    } else {
                        System.out.print("|" + ANSI_BLUE + tablero[i][j] + ANSI_RESET);
                    }
                } else {
                    System.out.print("|" + tablero[i][j]);
                }
            }

            System.out.print("|");
            System.out.println();
        }
        System.out.println("  +-+-+-+-+-+-+-+-+-+-+-+-+-+");

        return tablero;
    }

    public static boolean medirDistanciaMarco(int fila, int columna, int marcoAPintar) {
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

    private static void mostrarRanking(Juego unJuego) {
        System.out.println("*** Ranking de Jugadores ***");
        for (int i = 0; i < unJuego.getListaDeJugadores().size(); i++) {
            Jugador j = unJuego.getListaDeJugadores().get(i);
            System.out.println(j.toString() + " || " + "Ganadas: " + j.getGanadas() + 
                                                   " | Empatadas: " + j.getEmpates() + 
                                                   " | Perdidas: " + j.getPerdidas());
        }
    }
}
