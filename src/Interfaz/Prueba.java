package Interfaz;

import ArcoirisMainPackage.Juego;
import ArcoirisMainPackage.Jugador;
import ArcoirisMainPackage.Partida;
import ArcoirisMainPackage.Tablero;
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

        //Creo el Scanner para manejar los datos ingresados por el usuario.        
        Scanner input = new Scanner(System.in);

        //Creo una instancia de Juego con el cual voy a manejar el sistema.
        Juego miJuego = new Juego();

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
                        replicarPartida(input, miJuego);
                        System.out.println("\nPresione enter para continuar...");
                        leoComando();
                        break;
                    default:
                        System.out.println("\n¡Error!, Opción no existe");
                        break;
                }
            } catch (InputMismatchException ex) {
                input.nextLine();
                System.out.println("\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯");
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

                //Genero una nueva partida en caso de quere volver a jugar antes de configurar una nueva.
                Partida proximaPartida = new Partida();
                proximaPartida.setJugadorA(partidaActual.getJugadorA());
                proximaPartida.setJugadorB(partidaActual.getJugadorB());
                proximaPartida.setMarcoInicio(partidaActual.getMarcoInicio());
                proximaPartida.setDistribucionInicialFichas(partidaActual.getDistribucionInicialFichas());
                proximaPartida.setTipoFinPartida(partidaActual.getTipoFinPartida());
                proximaPartida.generarTableroInicial(partidaActual.getDistribucionInicialFichas(), partidaActual.getMarcoInicio());

                Jugador jugadorA = partidaActual.getJugadorA();
                Jugador jugadorB = partidaActual.getJugadorB();

                jugadorA.setTipoFicha('N');
                jugadorB.setTipoFicha('B');

                System.out.println("\n       " + jugadorA.getAlias() + " vs " + jugadorB.getAlias());

                System.out.println("\n-> Objetivo: " + partidaActual.obtenerTipoFinDePartida());
                System.out.println();
                mostrarTablero(partidaActual.getListaDeTableros().get(0).getMatriz());
                partidaActual.setTableroActual(partidaActual.getListaDeTableros().get(0));

                if (partidaActual.getTipoFinPartida() == 1) { //Hasta que no hayan mas movimientos
                    jugarPorCantidadDeMovimientos(scr, partidaActual, jugadorA, jugadorB);
                } else { //Primero en conquistar el centro gana
                    jugarConquistaElCentro(scr, partidaActual, jugadorA, jugadorB);
                }

                unJuego.getListaDePartidas().add(proximaPartida);
            } else {
                System.out.println("No existe ninguna partida configurada.");
            }
        } catch (Exception ex) {
            System.out.println("Ocurrió un error catastrófico: " + ex);
        }
    }

    public static void jugarConquistaElCentro(Scanner scr, Partida unaPartida, Jugador jugadorA, Jugador jugadorB) {
        try {
            scr.nextLine();
            boolean movimientoEsValido = false;
            boolean turnoJugador = true;
            boolean bandera = false;
            boolean formaMarco = false;
            boolean conquistoCentro = false;
            String txtVar;

            while (!conquistoCentro) {

                if (turnoJugador) {//Mueve jugador A
                    System.out.println("\n• Turno de " + jugadorA.getAlias() + " (Fichas Negras)");
                    System.out.print("Indique origen y el destino hacia donde mover la ficha.\nEjemplo 'A1-C3'\nIngrese opción: ");

                    while (!bandera) {
                        txtVar = scr.nextLine();

                        if (!(txtVar.toUpperCase().equals("X"))) {
                            String[] movimientosOrigenDestino = unaPartida.ValidarPosicionesExisten(txtVar);

                            if (!(movimientosOrigenDestino[0].isEmpty())) {
                                //Si el origen y destino ingresado por el usuario es coherente con la matriz lo convierto de a numeros
                                int[] posicionOrigen = unaPartida.convertirColumnaFila(movimientosOrigenDestino[0]);
                                int[] posicionDestino = unaPartida.convertirColumnaFila(movimientosOrigenDestino[1]);

                                char[][] matrizClon = new char[13][13];
                                for (int i = 0; i < matrizClon.length; i++) {
                                    for (int j = 0; j < matrizClon[0].length; j++) {
                                        matrizClon[i][j] = unaPartida.getTableroActual().getMatriz()[i][j];
                                    }
                                }

                                Tablero tableroClon = new Tablero();
                                tableroClon.setMatriz(matrizClon);

                                if (posicionDestino[0] != 6 && posicionDestino[1] != 6) {
                                    movimientoEsValido = tableroClon.movimientoValido(posicionOrigen[0], posicionOrigen[1], posicionDestino[0], posicionDestino[1], jugadorA);
                                    if (movimientoEsValido) {
                                        //Cambio la ficha al lugar que me movi
                                        tableroClon.getMatriz()[posicionDestino[0]][posicionDestino[1]] = jugadorA.getTipoFicha();
                                        tableroClon.getMatriz()[posicionOrigen[0]][posicionOrigen[1]] = 'O';

                                        //Verifico si puedo comer fichas..
                                        String resultadoComida = tableroClon.comerFichas(posicionDestino[0], posicionDestino[1]);

                                        //Verifico si formo un marco
                                        formaMarco = tableroClon.formaMarco(posicionDestino[0], posicionDestino[1], jugadorA);

                                        mostrarTablero(tableroClon.getMatriz());
                                        tableroClon.setAutorMovimiento(jugadorA);

                                        //Debo de formatear los numeros para mostrar un mensaje acorde de lo sucedido en la comida
                                        //Limpio la accion del clon anterior
                                        tableroClon.setResultadoAccion("");
                                        if (!resultadoComida.isEmpty() && formaMarco) {
                                            tableroClon.setResultadoAccion("Desplazamiento con captura y ocupación del centro: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " " + resultadoComida + "*");
                                            conquistoCentro = true;

                                            System.out.print("~~~~~~~~~• FIN DEL JUEGO •~~~~~~~~~ FIN DEL JUEGO\nResultado: " + jugadorA.getAlias() + " es el ganador!");
                                            jugadorA.setGanadas(jugadorA.getGanadas() + 1);
                                            jugadorB.setPerdidas(jugadorB.getPerdidas() + 1);

                                        } else if (!resultadoComida.isEmpty()) {
                                            tableroClon.setResultadoAccion("Desplazamiento con captura: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " " + resultadoComida);
                                        } else if (formaMarco) {
                                            tableroClon.setResultadoAccion("Desplazamiento con ocupación del centro: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " *");
                                            conquistoCentro = true;
                                            System.out.print("~~~~~~~~~• FIN DEL JUEGO •~~~~~~~~~ FIN DEL JUEGO\nResultado: " + jugadorA.getAlias() + " es el ganador!");
                                            jugadorA.setGanadas(jugadorA.getGanadas() + 1);
                                            jugadorB.setPerdidas(jugadorB.getPerdidas() + 1);

                                        } else {
                                            tableroClon.setResultadoAccion("Desplazamiento simple: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1]);
                                        }

                                        unaPartida.setTableroActual(tableroClon);
                                        System.out.println("\n• Resultado de la acción anterior: " + tableroClon.getResultadoAccion());
                                        unaPartida.getListaDeTableros().add(tableroClon);
                                        bandera = true;

                                    } else {
                                        System.out.print("\nError!, movimiento no valido.\nIngrese otros valores: ");
                                    }
                                } else {
                                    System.out.print("\nError!, movimiento no valido, no puede moverse al centro directamente.\nIngrese otros valores: ");
                                }
                            } else {
                                System.out.print("Error!, Movimiento no valido. Debe ingresar por ejemplo 'FilaColumnaOrigen-FilaColumnaDestino'. \nIngrese otros valores: ");
                            }
                        } else {
                            conquistoCentro = true;
                            jugadorA.setPerdidas(jugadorA.getPerdidas() + 1);
                            jugadorB.setGanadas(jugadorB.getGanadas() + 1);
                            unaPartida.setGanador(jugadorB);
                            bandera = true;
                            System.out.println("\n(ノಠ益ಠ)ノ彡┻━┻ FIN DEL JUEGO! \nGanador: " + ANSI_GREEN + jugadorB.getAlias() + ANSI_RESET);
                        }
                    }

                    bandera = false;
                    turnoJugador = !turnoJugador;
                    movimientoEsValido = false;
                    formaMarco = false;

                } else {//Mueve jugador B
                    System.out.println("\n• Turno de " + jugadorB.getAlias() + " (Fichas blancas)");
                    System.out.print("Indique la ficha de origen y el destino hacia donde mover ficha.\nEjemplo 'A1-C3'\nIngrese opción: ");

                    while (!bandera) {
                        txtVar = scr.nextLine();

                        if (!(txtVar.toUpperCase().equals("X"))) {
                            String[] movimientosOrigenDestino = unaPartida.ValidarPosicionesExisten(txtVar);

                            if (!(movimientosOrigenDestino[0].isEmpty())) {
                                //Si el origen y destino ingresado por el usuario es coherente con la matriz lo convierto de a numeros
                                int[] posicionOrigen = unaPartida.convertirColumnaFila(movimientosOrigenDestino[0]);
                                int[] posicionDestino = unaPartida.convertirColumnaFila(movimientosOrigenDestino[1]);

                                char[][] matrizClon = new char[13][13];
                                for (int i = 0; i < matrizClon.length; i++) {
                                    for (int j = 0; j < matrizClon[0].length; j++) {
                                        matrizClon[i][j] = unaPartida.getTableroActual().getMatriz()[i][j];
                                    }
                                }

                                Tablero tableroClon = new Tablero();
                                tableroClon.setMatriz(matrizClon);

                                if (posicionDestino[0] != 6 && posicionDestino[1] != 6) {
                                    movimientoEsValido = tableroClon.movimientoValido(posicionOrigen[0], posicionOrigen[1], posicionDestino[0], posicionDestino[1], jugadorB);
                                    if (movimientoEsValido) {
                                        //Cambio la ficha al lugar que me movi
                                        tableroClon.getMatriz()[posicionDestino[0]][posicionDestino[1]] = jugadorB.getTipoFicha();
                                        tableroClon.getMatriz()[posicionOrigen[0]][posicionOrigen[1]] = 'O';

                                        //Verifico si puedo comer fichas..
                                        String resultadoComida = tableroClon.comerFichas(posicionDestino[0], posicionDestino[1]);

                                        //Verifico si formo un marco
                                        formaMarco = tableroClon.formaMarco(posicionDestino[0], posicionDestino[1], jugadorB);

                                        tableroClon.setAutorMovimiento(jugadorB);
                                        mostrarTablero(tableroClon.getMatriz());

                                        //Debo de formatear los numeros para mostrar un mensaje acorde de lo sucedido en la comida
                                        //Limpio la accion del clon anterior
                                        tableroClon.setResultadoAccion("");
                                        if (!resultadoComida.isEmpty() && formaMarco) {
                                            tableroClon.setResultadoAccion("Desplazamiento con captura y ocupación del centro: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " " + resultadoComida + "*");

                                            System.out.print("~~~~~~~~~• FIN DEL JUEGO •~~~~~~~~~ \nResultado: " + jugadorB.getAlias() + " es el ganador!");
                                            jugadorB.setGanadas(jugadorB.getGanadas() + 1);
                                            jugadorA.setPerdidas(jugadorA.getPerdidas() + 1);
                                            conquistoCentro = true;

                                        } else if (!resultadoComida.isEmpty()) {
                                            tableroClon.setResultadoAccion("Desplazamiento con captura: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " " + resultadoComida);
                                        } else if (formaMarco) {
                                            tableroClon.setResultadoAccion("Desplazamiento con ocupación del centro: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " *");

                                            System.out.print("~~~~~~~~~• FIN DEL JUEGO •~~~~~~~~~ FIN DEL JUEGO\nResultado: " + jugadorB.getAlias() + " es el ganador!");
                                            jugadorB.setGanadas(jugadorB.getGanadas() + 1);
                                            jugadorA.setPerdidas(jugadorA.getPerdidas() + 1);
                                            conquistoCentro = true;

                                        } else {
                                            tableroClon.setResultadoAccion("Desplazamiento simple: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1]);
                                        }

                                        System.out.println("\n• Resultado de la accion anterior: " + tableroClon.getResultadoAccion());

                                        unaPartida.setTableroActual(tableroClon);
                                        unaPartida.getListaDeTableros().add(tableroClon);
                                        bandera = true;

                                    } else {
                                        System.out.print("\nError!, movimiento no valido.\nIngrese otros valores: ");
                                    }
                                } else {
                                    System.out.print("\nError!, movimiento no valido, no puede moverse al centro directamente.\nIngrese otros valores: ");
                                }
                            } else {
                                System.out.print("Error!, Movimiento no valido. \nDebe ingresar por ejemplo 'FilaColumnaOrigen-FilaColumnaDestino'. \nIngrese otros valores: ");
                            }
                        } else {
                            conquistoCentro = true;
                            jugadorA.setGanadas(jugadorA.getGanadas() + 1);
                            jugadorB.setPerdidas(jugadorB.getPerdidas() + 1);
                            unaPartida.setGanador(jugadorA);
                            bandera = true;
                            System.out.println("\n(ノಠ益ಠ)ノ彡┻━┻ FIN DEL JUEGO! \nGanador: " + ANSI_GREEN + jugadorA.getAlias() + ANSI_RESET);
                        }
                    }

                    bandera = false;
                    turnoJugador = !turnoJugador;
                    movimientoEsValido = false;
                    formaMarco = false;
                }

                unaPartida.setCantidadMovimientos(unaPartida.getCantidadMovimientos() - 1);
            }
        } catch (Exception ex) {
            System.out.println("Ocurrió un error catastrófico: " + ex);
        }
    }

    public static void jugarPorCantidadDeMovimientos(Scanner scr, Partida unaPartida, Jugador jugadorA, Jugador jugadorB) {
        try {
            scr.nextLine();
            boolean movimientoEsValido = false;
            boolean formaMarco = false;
            boolean turnoJugador = true;
            boolean bandera = false;
            boolean dioenX = false;
            String txtVar;

            while (unaPartida.getCantidadMovimientos() > 0) {

                if (turnoJugador) {//Mueve jugador A
                    System.out.println("\n• Turno de " + jugadorA.getAlias() + " (Fichas Negras)");
                    System.out.print("Indique origen y el destino hacia donde mover ficha.\nEjemplo 'A1-C3'\nIngrese opción: ");

                    while (!bandera) {
                        txtVar = scr.nextLine();

                        if (!(txtVar.toUpperCase().equals("X"))) {
                            String[] movimientosOrigenDestino = unaPartida.ValidarPosicionesExisten(txtVar);

                            if (!(movimientosOrigenDestino[0].isEmpty())) {
                                //Si el origen y destino ingresado por el usuario es coherente con la matriz lo convierto de a numeros
                                int[] posicionOrigen = unaPartida.convertirColumnaFila(movimientosOrigenDestino[0]);
                                int[] posicionDestino = unaPartida.convertirColumnaFila(movimientosOrigenDestino[1]);

                                char[][] matrizClon = new char[13][13];
                                for (int i = 0; i < matrizClon.length; i++) {
                                    for (int j = 0; j < matrizClon[0].length; j++) {
                                        matrizClon[i][j] = unaPartida.getTableroActual().getMatriz()[i][j];
                                    }
                                }

                                Tablero tableroClon = new Tablero();
                                tableroClon.setMatriz(matrizClon);

                                if (posicionDestino[0] != 6 && posicionDestino[1] != 6) {
                                    movimientoEsValido = tableroClon.movimientoValido(posicionOrigen[0], posicionOrigen[1], posicionDestino[0], posicionDestino[1], jugadorA);
                                    if (movimientoEsValido) {
                                        //Cambio la ficha al lugar que me movi
                                        tableroClon.getMatriz()[posicionDestino[0]][posicionDestino[1]] = jugadorA.getTipoFicha();
                                        tableroClon.getMatriz()[posicionOrigen[0]][posicionOrigen[1]] = 'O';

                                        //Verifico si puedo comer fichas..
                                        String resultadoComida = tableroClon.comerFichas(posicionDestino[0], posicionDestino[1]);

                                        //Verifico si formo un marco
                                        formaMarco = tableroClon.formaMarco(posicionDestino[0], posicionDestino[1], jugadorA);

                                        tableroClon.setAutorMovimiento(jugadorA);
                                        mostrarTablero(tableroClon.getMatriz());

                                        //Debo de formatear los numeros para mostrar un mensaje acorde de lo sucedido en la comida
                                        //Limpio la accion del clon anterior
                                        tableroClon.setResultadoAccion("");
                                        if (!resultadoComida.isEmpty() && formaMarco) {
                                            tableroClon.setResultadoAccion("Desplazamiento con captura y ocupación del centro: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " " + resultadoComida + "*");
                                        } else if (!resultadoComida.isEmpty()) {
                                            tableroClon.setResultadoAccion("Desplazamiento con captura: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " " + resultadoComida);
                                        } else if (formaMarco) {
                                            tableroClon.setResultadoAccion("Desplazamiento con ocupación del centro: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " *");
                                        } else {
                                            tableroClon.setResultadoAccion("Desplazamiento simple: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1]);
                                        }

                                        System.out.println("\n• Resultado de la accion anterior: " + tableroClon.getResultadoAccion());
                                        unaPartida.setTableroActual(tableroClon);
                                        unaPartida.getListaDeTableros().add(tableroClon);
                                        bandera = true;

                                    } else {
                                        System.out.print("\nError!, movimiento no valido.\nIngrese otros valores: ");
                                    }
                                } else {
                                    System.out.print("\nError!, movimiento no valido, no puede moverse al centro directamente.\nIngrese otros valores: ");
                                }
                            } else {
                                System.out.print("Error!, Movimiento no valido. Debe ingresar por ejemplo 'FilaColumnaOrigen-FilaColumnaDestino'. \nIngrese otros valores: ");
                            }
                        } else {
                            unaPartida.setCantidadMovimientos(1);
                            jugadorA.setPerdidas(jugadorA.getPerdidas() + 1);
                            jugadorB.setGanadas(jugadorB.getGanadas() + 1);
                            unaPartida.setGanador(jugadorB);
                            bandera = true;
                            dioenX = true;
                            System.out.println("\n(ノಠ益ಠ)ノ彡┻━┻ FIN DEL JUEGO! \nGanador: " + ANSI_GREEN + jugadorB.getAlias() + ANSI_RESET);
                        }
                    }

                    bandera = false;
                    turnoJugador = !turnoJugador;
                    movimientoEsValido = false;
                    formaMarco = false;
                } else {//Mueve jugador B
                    System.out.println("\n-> Turno de " + jugadorB.getAlias() + " (Fichas blancas)");
                    System.out.print("Indique la ficha de origen y el destino hacia donde mover ficha.\nEjemplo 'A1-C3'\nIngrese opción: ");

                    while (!bandera) {
                        txtVar = scr.nextLine();

                        if (!(txtVar.toUpperCase().equals("X"))) {
                            String[] movimientosOrigenDestino = unaPartida.ValidarPosicionesExisten(txtVar);

                            if (!(movimientosOrigenDestino[0].isEmpty())) {
                                //Si el origen y destino ingresado por el usuario es coherente con la matriz lo convierto de a numeros
                                int[] posicionOrigen = unaPartida.convertirColumnaFila(movimientosOrigenDestino[0]);
                                int[] posicionDestino = unaPartida.convertirColumnaFila(movimientosOrigenDestino[1]);

                                char[][] matrizClon = new char[13][13];
                                for (int i = 0; i < matrizClon.length; i++) {
                                    for (int j = 0; j < matrizClon[0].length; j++) {
                                        matrizClon[i][j] = unaPartida.getTableroActual().getMatriz()[i][j];
                                    }
                                }

                                Tablero tableroClon = new Tablero();
                                tableroClon.setMatriz(matrizClon);

                                if (posicionDestino[0] != 6 && posicionDestino[1] != 6) {
                                    movimientoEsValido = tableroClon.movimientoValido(posicionOrigen[0], posicionOrigen[1], posicionDestino[0], posicionDestino[1], jugadorB);
                                    if (movimientoEsValido) {
                                        //Cambio la ficha al lugar que me movi
                                        tableroClon.getMatriz()[posicionDestino[0]][posicionDestino[1]] = jugadorB.getTipoFicha();
                                        tableroClon.getMatriz()[posicionOrigen[0]][posicionOrigen[1]] = 'O';

                                        //Verifico si puedo comer fichas..
                                        String resultadoComida = tableroClon.comerFichas(posicionDestino[0], posicionDestino[1]);

                                        //Verifico si formo un marco
                                        formaMarco = tableroClon.formaMarco(posicionDestino[0], posicionDestino[1], jugadorA);

                                        tableroClon.setAutorMovimiento(jugadorB);
                                        mostrarTablero(tableroClon.getMatriz());

                                        //Debo de formatear los numeros para mostrar un mensaje acorde de lo sucedido en la comida
                                        //Limpio la accion del clon anterior
                                        tableroClon.setResultadoAccion("");
                                        if (!resultadoComida.isEmpty() && formaMarco) {
                                            tableroClon.setResultadoAccion("Desplazamiento con captura y ocupación del centro: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " " + resultadoComida + "*");
                                        } else if (!resultadoComida.isEmpty()) {
                                            tableroClon.setResultadoAccion("Desplazamiento con captura: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " " + resultadoComida);
                                        } else if (formaMarco) {
                                            tableroClon.setResultadoAccion("Desplazamiento con ocupación del centro: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1] + " *");
                                        } else {
                                            tableroClon.setResultadoAccion("Desplazamiento simple: " + movimientosOrigenDestino[0] + "-" + movimientosOrigenDestino[1]);
                                        }

                                        System.out.println("\n• Resultado de la accion anterior: " + tableroClon.getResultadoAccion());
                                        unaPartida.setTableroActual(tableroClon);
                                        unaPartida.getListaDeTableros().add(tableroClon);
                                        bandera = true;

                                    } else {
                                        System.out.print("\nError!, movimiento no valido.\nIngrese otros valores: ");
                                    }
                                } else {
                                    System.out.print("\nError!, movimiento no valido, no puede moverse al centro directamente.\nIngrese otros valores: ");
                                }
                            } else {
                                System.out.print("Error!, Movimiento no valido. Debe ingresar por ejemplo 'FilaColumnaOrigen-FilaColumnaDestino'. \nIngrese otros valores: ");
                            }
                        } else {
                            unaPartida.setCantidadMovimientos(1);
                            jugadorB.setPerdidas(jugadorB.getPerdidas() + 1);
                            jugadorA.setGanadas(jugadorA.getGanadas() + 1);
                            unaPartida.setGanador(jugadorA);
                            bandera = true;
                            dioenX = true;
                            System.out.println("\n(ノಠ益ಠ)ノ彡┻━┻ FIN DEL JUEGO! \nGanador: " + ANSI_GREEN + jugadorA.getAlias() + ANSI_RESET);
                        }
                    }

                    bandera = false;
                    turnoJugador = !turnoJugador;
                    movimientoEsValido = false;
                    formaMarco = false;
                }

                unaPartida.setCantidadMovimientos(unaPartida.getCantidadMovimientos() - 1);
            }

            if (!dioenX) {//Si alguno de los jugadores quitea, no hago esta parte porque ya se seteo el ganador y perdedor
                if (unaPartida.getTableroActual().getMatriz()[6][6] == 'B') {
                    System.out.print("~~~~~~~~~• FIN DEL JUEGO •~~~~~~~~~ \nResultado: " + jugadorB.getAlias() + " es el ganador!");

                    jugadorB.setGanadas(jugadorB.getGanadas() + 1);
                    jugadorA.setPerdidas(jugadorA.getPerdidas() + 1);
                } else if (unaPartida.getTableroActual().getMatriz()[6][6] == 'N') {
                    System.out.print("~~~~~~~~~• FIN DEL JUEGO •~~~~~~~~~ \nResultado: " + jugadorA.getAlias() + " es el ganador!");

                    jugadorA.setGanadas(jugadorA.getGanadas() + 1);
                    jugadorB.setPerdidas(jugadorB.getPerdidas() + 1);
                } else {
                    System.out.print("~~~~~~~~~• FIN DEL JUEGO •~~~~~~~~~ \nResultado: Empate");

                    jugadorA.setEmpates(jugadorA.getEmpates() + 1);
                    jugadorB.setEmpates(jugadorB.getEmpates() + 1);
                }
            }

        } catch (Exception ex) {
            System.out.println("Ocurrió un error catastrófico: " + ex);
        }
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
                        System.out.print("\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯ \nIngrese una edad válida: ");
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
                                                System.out.print("\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯ \nIngrese una opción válida: ");
                                            }
                                        }
                                    } else {
                                        System.out.print("Opción incorrecta, elija otra: ");
                                    }
                                } else {
                                    System.out.print("\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯ \n Ingrese una opción válida: ");
                                }
                            }
                        } else {
                            System.out.print("Opción incorrecta, elija otra: ");
                        }
                    } else {
                        System.out.print("\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯ \n Ingrese una opción válida: ");
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
                            System.out.print("\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯ \n Ingrese una opción válida: ");
                        }
                    }
                } else {
                    System.out.print("Jugador no existe, elija un jugador de la lista: ");
                }
            } else {
                System.out.print("\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯ \n Ingrese una opción válida: ");
            }
        }

        return resultado;
    }

    private static void mostrarRanking(Juego unJuego) {

        System.out.println("\n~~~~~~~~~~•~~~~~~~~~~•~~~~~~~~~~~");
        System.out.println("ᕦ(ò_óˇ)ᕤ Ranking de Jugadores");
        if (unJuego.getListaDeJugadores().isEmpty()) {
            System.out.println("\nNo existen jugadores.");
        } else {
            for (int i = 0; i < unJuego.getListaDeJugadores().size(); i++) {
                Jugador j = unJuego.getListaDeJugadores().get(i);
                System.out.println(j.toString() + " || " + "Ganadas: " + j.getGanadas()
                        + " | Empatadas: " + j.getEmpates()
                        + " | Perdidas: " + j.getPerdidas());
            }
        }
    }

    private static void replicarPartida(Scanner scr, Juego unJuego) {
        System.out.println("\n~~~~~~~~~~•~~~~~~~~~~•~~~~~~~~~~");
        System.out.println("(⌐■_■) Replicar partida");

        if (unJuego.getListaDePartidas().size() > 0) {
            ArrayList<Partida> miListadePartidas = unJuego.getListaDePartidas();
            ArrayList<Partida> nuevaListaPartidas = new ArrayList<Partida>();

            for (int i = 0; i < miListadePartidas.size(); i++) {
                if (miListadePartidas.get(i).getCantidadMovimientos() < 10) {
                    //Obtengo solo las partidas en las cuales se hayan realizado al menos un movimiento
                    nuevaListaPartidas.add(miListadePartidas.get(i));
                }
            }

            if (nuevaListaPartidas.size() > 0) {
                System.out.println("\n****Lista de partidas****\n");
                for (int i = 0; i < nuevaListaPartidas.size(); i++) {

                    System.out.println(i + 1 + ". " + nuevaListaPartidas.get(i).getJugadorA().getAlias() + " vs " + nuevaListaPartidas.get(i).getJugadorB().getAlias());
                }

                Partida partidaAReplicar;
                ArrayList<Tablero> tablerosPartida;
                String textVar;
                int partidaElejida;
                scr.nextLine();
                boolean bandera = false;

                System.out.print("  -> Elija una partida: ");

                while (!bandera) {
                    textVar = scr.nextLine();

                    if (Pattern.matches("[0-9]+", textVar)) {
                        partidaElejida = Integer.parseInt(textVar);

                        if (partidaElejida > 0 && partidaElejida <= nuevaListaPartidas.size()) {
                            partidaAReplicar = nuevaListaPartidas.get(partidaElejida - 1);
                            tablerosPartida = partidaAReplicar.getListaDeTableros();

                            for (int i = 0; i < tablerosPartida.size(); i++) {
                                mostrarTablero(tablerosPartida.get(i).getMatriz());

                                if (tablerosPartida.get(i).getAutorMovimiento() != null) {
                                    System.out.println("• Movimiento realizado por: " + tablerosPartida.get(i).getAutorMovimiento().getAlias());
                                } else {
                                    System.out.println("• Configuración inicial de la partida");
                                }

                                System.out.println(tablerosPartida.get(i).getResultadoAccion());

                                System.out.println("\nPresione enter para seguir viendo paso a paso las jugadas...");
                                leoComando();
                            }

                            if (partidaAReplicar.getGanador() != null) {
                                System.out.println("• El ganador fue: " + partidaAReplicar.getGanador());
                            } else {
                                System.out.println("• La partida termino en empate.");
                            }

                            bandera = true;
                        } else {
                            System.out.print("Partida no existe, elija una partida de la lista: ");
                        }
                    } else {
                        System.out.print("\n¡Error!, sólo números son permitidos...  ¯\\_(ツ)_/¯ \n Ingrese una opción válida: ");
                    }
                }

            } else {
                System.out.println("\nNo existen partidas finalizadas.");
            }
        } else {
            System.out.println("\nNo existen registros de partidas.");
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
