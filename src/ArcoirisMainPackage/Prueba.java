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
        System.out.println(ANSI_PURPLE + "	  	        []  ,----.___\n" + ANSI_GREEN
                + "		      __||_/___      '.\n" + ANSI_GREEN
                + "		     / O||    /|       )\n" + ANSI_YELLOW
                + "		    /   \"\"   / /   =._/\n" + ANSI_YELLOW
                + "		   /________/ /\n" + ANSI_CYAN
                + "		   |________|/   " + ANSI_RESET);

        System.out.println(ANSI_PURPLE + "     _                            _          _       \n" + ANSI_PURPLE
                + "    / \\     _ __    ___    ___   (_)  _ __  (_)  ___ \n" + ANSI_GREEN
                + "   / _ \\   | '__|  / __|  / _ \\  | | | '__| | | / __|\n" + ANSI_YELLOW
                + "  / ___ \\  | |    | (__  | (_) | | | | |    | | \\__ \\\n" + ANSI_CYAN
                + " /_/   \\_\\ |_|     \\___|  \\___/  |_| |_|    |_| |___/\n"
                + "                                                     " + ANSI_RESET);

        //mostrarTablero();
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

        Partida part1 = new Partida();
        part1.agregarJugadorA(j5);
        part1.agregarJugadorB(j1);
        part1.setCantidadMovimientos(10);
        part1.setDistribucionInicialFichas(1);//1.2.3
        part1.setMarcoInicio(1);//1.2.3.4
        part1.setTipoFinPartida(1);//1.2

        Partida part2 = new Partida();
        part2.agregarJugadorA(j2);
        part2.agregarJugadorB(j3);
        part2.setCantidadMovimientos(10);
        part2.setDistribucionInicialFichas(2);//1.2.3
        part2.setMarcoInicio(3);//1.2.3.4
        part2.setTipoFinPartida(2);//1.2

        Partida part3 = new Partida();
        part3.agregarJugadorA(j1);
        part3.agregarJugadorB(j4);
        part3.setCantidadMovimientos(10);
        part3.setDistribucionInicialFichas(3);//1.2.3
        part3.setMarcoInicio(4);//1.2.3.4
        part3.setTipoFinPartida(1);//1.2

        miJuego.agregarPartida(part1);
        miJuego.agregarPartida(part2);
        miJuego.agregarPartida(part3);

        //*****//
        int opcion = -1;

        //Manejo de menu
        while (opcion != 0) {
            try {
                System.out.println();
                mostrarMenuPrincipal();

                opcion = input.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo del juego...");
                        break;
                    case 1:// Registrar Jugador
                        crearJugador(input, miJuego);
                        System.out.println("\nPresione enter para continuar...");
                        leoComando();
                        break;
                    case 2: // Configurar partida
                        configurarPartida(input, miJuego);
                        System.out.println("\nPresione enter para continuar...");
                        leoComando();
                        break;
                    case 3: //Jugar                        
                        Jugar(input, miJuego);
                        System.out.println("\nPresione enter para continuar...");
                        leoComando();
                        break;
                    case 4: //Ranking
                        miJuego.obtenerRanking();
                        mostrarRanking(miJuego);
                        System.out.println("\nPresione enter para continuar...");
                        leoComando();
                        break;
                    case 5: //Replicar partida
                        break;
                    default:
                        System.out.println(ANSI_RED + "\n¡Error!, Opción no existe");
                        break;
                }
            } catch (InputMismatchException ex) {
                input.nextLine();
                System.out.println(ANSI_RED + "\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯" + ANSI_RESET);
            }
        }//Fin while
    }

    //*************************************************************************//
    //*************************************************************************//
    //******************  JUGAR  ********************************************//
    public static void Jugar(Scanner scr, Juego unJuego) {
        try {
            if (unJuego.getListaDePartidas().size() > 0) {
                System.out.println("\n~~~~~~~~~~•~~~~~~~~~~•~~~~~~~~~~~");
                System.out.println("(◣_◢) INICIO DE LA PARTIDA (◣_◢)");

                //Obtengo la ultima partida configurada
                ArrayList<Partida> listaDePartidas = unJuego.ordenarPartidasDesc();
                Partida partidaActual = listaDePartidas.get(0);
                Jugador jugadorA = partidaActual.getJugadorA();
                Jugador jugadorB = partidaActual.getJugadorB();
                
                jugadorA.setTipoFicha('N');
                jugadorB.setTipoFicha('B');
                
                System.out.println("\n       " + jugadorA.getAlias() + " vs " + jugadorB.getAlias());

                System.out.println("\n-> Objetivo: " + partidaActual.obtenerTipoFinDePartida());
                System.out.println();
                mostrarTablero(partidaActual.getListaDeTableros().get(0).getMatriz());
                partidaActual.setTableroActual(partidaActual.getListaDeTableros().get(0));
                
                scr.nextLine();
                boolean movimientoEsValido = false;
                boolean turnoJugador = true;
                boolean bandera = false;
                String txtVar;

                while (partidaActual.getCantidadMovimientos() > 0) {

                    if (turnoJugador) {//Mueve jugador A
                        System.out.println("\n• Turno de " + jugadorA.getAlias() + " (Fichas Negras)");
                        System.out.print("Indique la ficha de origen y el destino hacia quieres moverla ejemplo A1-C1: ");

                        while (!bandera) {
                            txtVar = scr.nextLine();

                            if (!(txtVar.toUpperCase().equals("X"))) {
                                String[] movimientosOrigenDestino = partidaActual.ValidarPosicionesExisten(txtVar);

                                if (!(movimientosOrigenDestino[0].isEmpty())) {
                                    //Si el origen y destino ingresado por el usuario es coherente con la matriz lo convierto de a numeros
                                    int[] posicionOrigen = partidaActual.convertirColumnaFila(movimientosOrigenDestino[0]);
                                    int[] posicionDestino = partidaActual.convertirColumnaFila(movimientosOrigenDestino[1]);

                                    Tablero tableroClon = (Tablero)partidaActual.getTableroActual().clone();
                                    
                                    movimientoEsValido = tableroClon.movimientoValido(posicionOrigen[0], posicionOrigen[1], posicionDestino[0], posicionDestino[1], tableroClon.getMatriz(), jugadorA);
                                    if(movimientoEsValido){
                                        //Cambio la ficha al lugar que me movi
                                        tableroClon.getMatriz()[posicionDestino[0]][posicionDestino[1]] = jugadorA.getTipoFicha();
                                        tableroClon.getMatriz()[posicionOrigen[0]][posicionOrigen[1]] = 'O';
                                        
                                        //Verifico si puedo comer fichas..
                                        tableroClon.comerFichas(posicionDestino[0], posicionDestino[1], tableroClon.getMatriz());
                                        
                                        //Verifico si formo un marco
                                        tableroClon.formaMarco(posicionDestino[0], posicionDestino[1], tableroClon.getMatriz());
                                        
                                        mostrarTablero(tableroClon.getMatriz());
                                        
                                    } else {
                                        System.out.print("\nError!, movimiento no valido.\nIngrese otros valores: ");
                                    }
                                } else {
                                    System.out.print("Error!, Movimiento no valido. Debe ingresar por ejemplo 'FilaColumnaOrigen-FilaColumnaDestino'. \nIngrese otros valores: ");
                                }
                            } else {
                                partidaActual.setCantidadMovimientos(1);
                                jugadorA.setPerdidas(jugadorA.getPerdidas() + 1);
                                partidaActual.setGanador(jugadorB);
                                bandera = true;
                            } 
                        }
                    } else {//Mueve jugador B
                        System.out.println("\n-> Turno de " + jugadorB.getAlias() + " (Fichas blancas)");
                    }

                    partidaActual.setCantidadMovimientos(partidaActual.getCantidadMovimientos() - 1);
                }

            } else {
                System.out.println("No existe ninguna partida configurada.");
            }
        } catch (Exception ex) {
            System.out.println("Ocurrió un error catastrófico: " + ex);
        }
    }

    public static void JugarConConfiguracionA() {

    }

    //*************************************************************************//
    //*************************************************************************//
    //******************  METODOS DEL MENÚ  ***********************************//
    public static void mostrarMenuPrincipal() {
        System.out.println("~~~~~~~• MENÚ PRINCIPAL •~~~~~~~");
        System.out.println("• [1]Registrar jugador");
        System.out.println("• [2]Configurar partida");
        System.out.println("• [3]JUGAR");
        System.out.println("• [4]Ranking");
        System.out.println("• [5]Replicar partida");
        System.out.println("• [0]Salir");
        System.out.println("~~~~~~~~~~•~~~~~~~~~~•~~~~~~~~~~");
        System.out.print("      -> Ingrese opción: ");
    }

    public static void crearJugador(Scanner scr, Juego unJuego) {
        System.out.println("\n~~~~~~~~~~•~~~~~~~~~~•~~~~~~~~~~~");
        System.out.println("(⌐■_■) Registro de nuevo jugador");

        String unNombre;
        String unAlias;
        int unaEdad;
        String textVar;

        scr.nextLine();
        Jugador unJugador = new Jugador();

        System.out.println("\n~~~~• Ingrese datos del Jugador •~~~~");
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
                        System.out.print(ANSI_RED + "\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯\n" + ANSI_RESET + "\nIngrese una edad válida: ");
                    }
                }
            }
        }
    }

    public static void configurarPartida(Scanner scr, Juego unJuego) {
        System.out.println("\n~~~~~~~~~~•~~~~~~~~~~•~~~~~~~~~~");
        System.out.println("(⌐■_■) Configurar partida");

        if (unJuego.getListaDeJugadores().size() >= 2) {
            Partida unaPartida = new Partida();

            if (agregarJugadoresaPartida(scr, unJuego, unaPartida)) {
                String textVar;
                int opcionElegida;
                boolean bandera = false;

                System.out.println("\n¿En que marco se distribuirán las fichas inicialmente?");
                System.out.print("Ingrese 1, 2, 3 o 4 siendo 1 el marco más externo: ");
                while (!bandera) {
                    textVar = scr.nextLine();

                    if (Pattern.matches("[0-9]+", textVar)) {
                        opcionElegida = Integer.parseInt(textVar);
                        if (opcionElegida > 0 && opcionElegida <= 4) {
                            unaPartida.setMarcoInicio(opcionElegida);

                            System.out.println("\n¿De que forma se distribuirán las fichas inicialmente?");
                            System.out.println("1. Al azar.");
                            System.out.println("2. En 'I', borde superior e inferior en negro N y bordes laterales blancos B.");
                            System.out.println("3. En 'L', borde izquierdo e inferior blanco, borde superior y derecho negro.");
                            System.out.print("  -> Elija una opción: ");

                            while (!bandera) {
                                textVar = scr.nextLine();

                                if (Pattern.matches("[0-9]+", textVar)) {
                                    opcionElegida = Integer.parseInt(textVar);

                                    if (opcionElegida > 0 && opcionElegida <= 3) {
                                        unaPartida.setDistribucionInicialFichas(opcionElegida);
                                        unaPartida.generarTableroInicial(opcionElegida, unaPartida.getMarcoInicio());

                                        System.out.println("\n¿De que forma desea finalizar el juego?");
                                        System.out.println("1. Ambos jugadores se quedan sin jugadas.");
                                        System.out.println("2. Primero en ocupar el centro.");
                                        System.out.print("  -> Elija una opción: ");

                                        while (!bandera) {
                                            textVar = scr.nextLine();

                                            if (Pattern.matches("[0-9]+", textVar)) {
                                                opcionElegida = Integer.parseInt(textVar);

                                                if (opcionElegida > 0 && opcionElegida <= 2) {
                                                    unaPartida.setTipoFinPartida(opcionElegida);
                                                    unJuego.agregarPartida(unaPartida);
                                                    System.out.println("\nSe configuró la partida exitosamente!");
                                                    bandera = true;//Termino el bucle, y vuelvo al menú
                                                } else {
                                                    System.out.print("Opción incorrecta, elija otra: ");
                                                }
                                            } else {
                                                System.out.print(ANSI_RED + "\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯\n" + ANSI_RESET + "\nIngrese una opción válida: ");
                                            }
                                        }
                                    } else {
                                        System.out.print("Opción incorrecta, elija otra: ");
                                    }
                                } else {
                                    System.out.print(ANSI_RED + "\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯\n" + ANSI_RESET + "\nIngrese una opción válida: ");
                                }
                            }
                        } else {
                            System.out.print("Opción incorrecta, elija otra: ");
                        }
                    } else {
                        System.out.print(ANSI_RED + "\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯\n" + ANSI_RESET + "\nIngrese una opción válida: ");
                    }
                }
            }
        } else {
            System.out.println("\nNo es posible configurar la partida, deben existir al menos 2 jugadores registrados.");
        }
    }

    public static boolean agregarJugadoresaPartida(Scanner scr, Juego unJuego, Partida unaPartida) {
        boolean resultado = false;

        ArrayList<Jugador> listaJugadores = unJuego.getListaDeJugadores();

        System.out.println("\n****Lista de jugadores****\n");
        for (int i = 0; i < listaJugadores.size(); i++) {
            System.out.println(i + 1 + ". " + listaJugadores.get(i).toString());
        }

        String textVar;
        int jugadorElejido;
        scr.nextLine();
        boolean bandera = false;

        System.out.print("  -> Elija jugador A: ");
        while (!bandera) {
            textVar = scr.nextLine();

            if (Pattern.matches("[0-9]+", textVar)) {
                jugadorElejido = Integer.parseInt(textVar);

                if (jugadorElejido > 0 && jugadorElejido <= listaJugadores.size()) {
                    unaPartida.agregarJugadorA(listaJugadores.get(jugadorElejido - 1));
                    
                    ArrayList<Jugador> listaSinJugadorSeleccionado = new ArrayList<Jugador>();
                    for (int i = 0; i < listaJugadores.size(); i++) {
                        if (i != (jugadorElejido - 1)) {
                            listaSinJugadorSeleccionado.add(listaJugadores.get(i));
                        }
                    }

                    System.out.println();
                    for (int i = 0; i < listaSinJugadorSeleccionado.size(); i++) {
                        System.out.println(i + 1 + ". " + listaSinJugadorSeleccionado.get(i).toString());
                    }

                    System.out.print("  -> Elija jugador B: ");
                    while (!bandera) {
                        textVar = scr.nextLine();
                        if (Pattern.matches("[0-9]+", textVar)) {
                            jugadorElejido = Integer.parseInt(textVar);

                            if (jugadorElejido > 0 && jugadorElejido <= listaSinJugadorSeleccionado.size()) {
                                unaPartida.agregarJugadorB(listaSinJugadorSeleccionado.get(jugadorElejido - 1));
                                bandera = true;
                                resultado = bandera;
                            } else {
                                System.out.print("Jugador no existe, elija un jugador de la lista: ");
                            }
                        } else {
                            System.out.print(ANSI_RED + "\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯\n" + ANSI_RESET + "\nIngrese una opción válida: ");
                        }
                    }
                } else {
                    System.out.print("Jugador no existe, elija un jugador de la lista: ");
                }
            } else {
                System.out.print(ANSI_RED + "\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯\n" + ANSI_RESET + "\nIngrese una opción válida: ");
            }
        }

        return resultado;
    }

    private static void mostrarRanking(Juego unJuego) {
        System.out.println("*** Ranking de Jugadores ***");
        for (int i = 0; i < unJuego.getListaDeJugadores().size(); i++) {
            Jugador j = unJuego.getListaDeJugadores().get(i);
            System.out.println(j.toString() + " || " + "Ganadas: " + j.getGanadas()
                    + " | Empatadas: " + j.getEmpates()
                    + " | Perdidas: " + j.getPerdidas());
        }
    }

    //*************************************************************************//
    //*************************************************************************//
    //******************   MOSTRAR TABLERO  ************************************//
    public static char[][] mostrarTablero(char[][] unTablero) {
        try {
            int filas = unTablero.length;
            int cols = unTablero[0].length;
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
                        if (unTablero[i][j] == 'B' || unTablero[i][j] == 'N') {
                            System.out.print("|" + unTablero[i][j]);
                        } else {
                            System.out.print("|" + ANSI_RED + unTablero[i][j] + ANSI_RESET);
                        }
                    } else if (medirDistanciaMarco(i, j, 2)) {
                        if (unTablero[i][j] == 'B' || unTablero[i][j] == 'N') {
                            System.out.print("|" + unTablero[i][j]);
                        } else {
                            System.out.print("|" + ANSI_PURPLE + unTablero[i][j] + ANSI_RESET);
                        }
                    } else if (medirDistanciaMarco(i, j, 3)) {
                        if (unTablero[i][j] == 'B' || unTablero[i][j] == 'N') {
                            System.out.print("|" + unTablero[i][j]);
                        } else {
                            System.out.print("|" + ANSI_YELLOW + unTablero[i][j] + ANSI_RESET);
                        }
                    } else if (medirDistanciaMarco(i, j, 4)) {
                        if (unTablero[i][j] == 'B' || unTablero[i][j] == 'N') {
                            System.out.print("|" + unTablero[i][j]);
                        } else {
                            System.out.print("|" + ANSI_GREEN + unTablero[i][j] + ANSI_RESET);
                        }
                    } else if (medirDistanciaMarco(i, j, 5)) {
                        if (unTablero[i][j] == 'B' || unTablero[i][j] == 'N') {
                            System.out.print("|" + unTablero[i][j]);
                        } else {
                            System.out.print("|" + ANSI_CYAN + unTablero[i][j] + ANSI_RESET);
                        }
                    } else if (medirDistanciaMarco(i, j, 6)) {
                        if (unTablero[i][j] == 'B' || unTablero[i][j] == 'N') {
                            System.out.print("|" + unTablero[i][j]);
                        } else {
                            System.out.print("|" + ANSI_BLUE + unTablero[i][j] + ANSI_RESET);
                        }
                    } else {
                        System.out.print("|" + unTablero[i][j]);
                    }
                }

                System.out.print("|");
                System.out.println();
            }
            System.out.println("  +-+-+-+-+-+-+-+-+-+-+-+-+-+");

        } catch (Exception ex) {
            System.out.println("Ocurrió un error catastrófico: " + ex.getMessage());
        }

        return unTablero;
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

    //*************************************************************************//
    //*************************************************************************//
    //******************   METODOS EXTRA  *************************************//    
    //Este método se utiliza para esperar que el usuario presione la tecla Enter para continuar
    private static void leoComando() {
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("¡Error inesperado!, " + e.toString());
        }
    }
}
