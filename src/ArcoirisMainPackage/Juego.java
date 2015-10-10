package ArcoirisMainPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Juego {

    private ArrayList<Jugador> listaDeJugadores;
    private ArrayList<Partida> listaDePartidas;

    public ArrayList<Jugador> getListaDeJugadores() {
        return this.listaDeJugadores;
    }

    public ArrayList<Partida> getListaDePartidas() {
        return this.listaDePartidas;
    }

    public void setListaDeJugadores(ArrayList<Jugador> unaLista) {
        this.listaDeJugadores = unaLista;
    }

    public void setListaDePartidas(ArrayList<Partida> unaLista) {
        this.listaDePartidas = unaLista;
    }

    public Juego() {
        this.setListaDeJugadores(new ArrayList<Jugador>());
        this.setListaDePartidas(new ArrayList<Partida>());
    }

    public void agregarJugador(Jugador unJugador) {
        this.getListaDeJugadores().add(unJugador);
    }

    public boolean existeJugador(Jugador unJugador) {
        boolean existe = false;
        Iterator<Jugador> it = this.getListaDeJugadores().iterator();

        while (it.hasNext()) {
            Jugador auxJugador = it.next();

            if (auxJugador.equals(unJugador)) {
                existe = true;
            }
        }
        return existe;
    }

    public ArrayList<Jugador> obtenerRanking() {
        Collections.sort(this.listaDeJugadores, new Comparator<Jugador>() {
            public int compare(Jugador j2, Jugador j1) {
                return j1.getGanadas() - j2.getGanadas();
            }
        });
        return this.listaDeJugadores;
    }
}
