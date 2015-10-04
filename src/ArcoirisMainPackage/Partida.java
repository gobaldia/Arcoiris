package ArcoirisMainPackage;

import java.util.ArrayList;

public class Partida {
    private ArrayList<Tablero> listaDeTableros;
    private Jugador jugadorA;
    private Jugador jugadorB;
    private int cantidadMovimientos;
    private Tablero tableroActual;
    private int tipoFinPartida;

    public ArrayList<Tablero> getListaDeTableros() {
        return this.listaDeTableros;
    }

    public void setListaDeTableros(ArrayList<Tablero> unaListaTableros) {
        this.listaDeTableros = unaListaTableros;
    }

    public Jugador getJugadorA() {
        return this.jugadorA;
    }

    public void setJugadorA(Jugador unJugadorA) {
        this.jugadorA = unJugadorA;
    }

    public Jugador getJugadorB() {
        return this.jugadorB;
    }

    public void setJugadorB(Jugador unJugadorB) {
        this.jugadorB = unJugadorB;
    }

    public int getCantidadMovimientos() {
        return this.cantidadMovimientos;
    }

    public void setCantidadMovimientos(int unaCantidadDeMovimientos) {
        this.cantidadMovimientos = unaCantidadDeMovimientos;
    }

    public Tablero getTableroActual() {
        return this.tableroActual;
    }

    public void setTableroActual(Tablero unTablero) {
        this.tableroActual = unTablero;
    }
    
    public int getTipoFinPartida(){
        return this.tipoFinPartida;
    }
    
    public void setTipoFinPartida(int unTipoFinPartida){
        this.tipoFinPartida = unTipoFinPartida;
    }
    
    
}
