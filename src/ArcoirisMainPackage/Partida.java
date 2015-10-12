package ArcoirisMainPackage;

import java.util.ArrayList;

public class Partida implements Comparable<Partida> {
    private static int idGeneral = 0;
    private int idPartida;
    private ArrayList<Tablero> listaDeTableros;
    private Jugador jugadorA;
    private Jugador jugadorB;
    private int cantidadMovimientos;
    private int marcoInicio;
    private int tipoFinPartida;//1-No hay mas movimientos, 2- Primero en ocupar el centro
    private int distribucionInicialFichas; //1-Azar, 2-En I, 3-En L
    private Tablero tableroActual;    

    public int getId(){
        return this.idPartida;
    }
    
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
        this.setCantidadMovimientos(10);
        
        
        //Para poder mantener un orden
        idPartida = idGeneral++;//Primero lo agrego a idPartida luego lo incremento.
    }
    
    
    
    
    public void agregarJugadorA(Jugador unJugador){
        this.setJugadorA(unJugador);
    }
    
    public void agregarJugadorB(Jugador unJugador){
        this.setJugadorB(unJugador);
    }
    
    public void generarTableroInicial(int tipoDistribucionFichas, int marcoInicial){
        Tablero tableroInicio = new Tablero();
        
        if(tipoDistribucionFichas == 1){
            tableroInicio.setMatriz(tableroInicio.generarMatrizConFichasAlAzar(marcoInicial));
        } else if (tipoDistribucionFichas == 2){
            
        } else if(tipoDistribucionFichas == 3){
            tableroInicio.setMatriz(tableroInicio.generarMatrizConFichasEnL(marcoInicial));
        }
        
        this.getListaDeTableros().add(tableroInicio);
    }
    
    public String obtenerTipoFinDePartida(){
        String retorno;
        
        if(this.getTipoFinPartida() == 1){
            retorno = "Cuando se terminen los " + this.getCantidadMovimientos() + " movimientos el jugador que este ocupando el centro en ese momento ganara. \nEn caso de que ninguno haya ocupado el centro la partida terminara en empate.";
        } else {
            retorno = "El primer jugador en ocupar el centro gana.";
        }
        
        return retorno;
    }
    
    @Override
    public int compareTo(Partida unaPartida){
        int result;
        if (unaPartida.getId() < this.getId()){
            result = -1;
        }else{
            result = 1;
        }
        
        return result;
    }
}
