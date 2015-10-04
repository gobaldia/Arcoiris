package ArcoirisMainPackage;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> listaDeJugadores;
    private ArrayList<Partida> listaDePartidas;
    
    public ArrayList<Jugador> getListaDeJugadores(){
        return this.listaDeJugadores;
    }
    public ArrayList<Partida> getListaDePartidas(){
        return this.listaDePartidas;
    }
    
    public void setListaDeJugadores(ArrayList<Jugador> unaLista){
        this.listaDeJugadores = unaLista;
    }
    
    public void setListaDePartidas(ArrayList<Partida> unaLista){
        this.listaDePartidas = unaLista;
    }
    
    public Juego(){
        this.setListaDeJugadores(new ArrayList<Jugador>());
        this.setListaDePartidas(new ArrayList<Partida>());        
    }    
    
    
    public void agregarJugador(Jugador unJugador) {
        this.getListaDeJugadores().add(unJugador);
    }
    
    public boolean existeJugador(String unAlias) {
        boolean existe = false;
        for (int i = 0; i < this.getListaDeJugadores().size(); i++) {
            if (this.getListaDeJugadores().get(i).getAlias().equals(unAlias)) {
                existe = true;
            }
        }
        return existe;
    }
}
