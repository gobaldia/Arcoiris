package ArcoirisMainPackage;

import java.io.Serializable;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Juego implements Serializable {

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

    //*************************************************************************//
    //****************** CONSTRUCTOR ***********************************//
    public Juego() {
        this.setListaDeJugadores(new ArrayList<Jugador>());
        this.setListaDePartidas(new ArrayList<Partida>());
    }
    
    //*************************************************************************//
    //******************   MOSTRAR JUEGO  ***********************************//
    public void agregarJugador(Jugador unJugador) {
        this.getListaDeJugadores().add(unJugador);
    }

    public void agregarPartida(Partida unaPartida) {
        this.getListaDePartidas().add(unaPartida);
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
            @Override
            public int compare(Jugador j2, Jugador j1) {
                return j1.getGanadas() - j2.getGanadas();
            }
        });
        return this.listaDeJugadores;
    }

    public ArrayList<Partida> ordenarPartidasDesc() {
        Collections.sort(this.getListaDePartidas());
        return this.getListaDePartidas();
    }

}
