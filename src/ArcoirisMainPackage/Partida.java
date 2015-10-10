package ArcoirisMainPackage;

import java.util.ArrayList;

public class Partida {
    private ArrayList<Tablero> listaDeTableros;
    private Jugador jugadorA;
    private Jugador jugadorB;
    private int cantidadMovimientos;
    private int marcoInicio;
    private int tipoFinPartida;
    private int distribucionInicialFichas; //1-Azar, 2-En I, 3-En L
    private Tablero tableroActual;    

    public ArrayList<Tablero> getListaDeTableros() {
        return this.listaDeTableros;
    }

    public void setListaDeTableros(ArrayList<Tablero> unaListaTableros) {
        this.listaDeTableros = unaListaTableros;
    }

    public void setDistribucionInicialFichas(int unaDistribucion){
        this.distribucionInicialFichas = unaDistribucion;
    }
    
    public int getDistribucionInicialFichas(){
        return this.distribucionInicialFichas;
    }
    
    public void setMarcoInicio(int unMarco){
        this.marcoInicio = unMarco;
    }
    
    public int getMarcoInicio(){
        return this.marcoInicio;
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
    
    public Partida(){
        this.setListaDeTableros(new ArrayList<Tablero>());
    }
    
    
    public void agregarJugadorA(Jugador unJugador){
        this.setJugadorA(unJugador);
    }
    
    public void agregarJugadorB(Jugador unJugador){
        this.setJugadorB(unJugador);
    }
    
}
