package ArcoirisMainPackage;

import java.util.ArrayList;
import java.util.StringTokenizer;

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
    private Jugador ganador;//Si queda en null es porque fue empate

    public int getId(){
        return this.idPartida;
    }
    
    public Jugador getGanador(){
        return this.ganador;
    }
    
    public void setGanador(Jugador unJugador){
        this.ganador = unJugador;
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
            tableroInicio.setMatriz(tableroInicio.generarMatrizConFichasEnI(marcoInicial));
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
    
    public String[] ValidarPosicionesExisten(String datoOrigenyDestino) {
        boolean resultado = true;
        String noSpaces;
        noSpaces = datoOrigenyDestino.replaceAll("\\s+", "");//Quito los espacios que puedan llegar a existir en el string

        int count = 0;
        String[] auxArray = new String[2];

        if (noSpaces.contains("-")) {//Si el string contiene '-' continuo la verificacion
            StringTokenizer tokenizer = new StringTokenizer(noSpaces, "-");
            String aux;

            while (tokenizer.hasMoreTokens()) {
                aux = tokenizer.nextToken();
                if (count <= 1) {
                    auxArray[count] = aux;
                }
                count++;
            }

            //Valido que solo exista un '-' en el string para que el string se divida en 2 partes unicamente
            if (count == 2) {
                if (auxArray[0].length() >= 2 && auxArray[0].length() <= 3) {
                    char[] auxChars1 = auxArray[0].toCharArray();

                    if (auxChars1[0] >= 'A' && auxChars1[0] <= 'M') {
                        resultado = true;
                    } else {
                        resultado = false;
                    }

                    if (resultado) {
                        if (auxChars1.length == 3) {
                            if (auxChars1[1] == '1' && (auxChars1[2] >= '1' && auxChars1[2] <= '3')) {
                                resultado = true;
                            } else {
                                resultado = false;
                            }
                        } else if (auxChars1.length == 2) {
                             if(auxChars1[1] >= '1' && auxChars1[1] <= '9'){
                                 resultado = true;
                             } else {
                                 resultado = false;
                             }
                        } else {
                            resultado = false;
                        }
                    } else {
                        resultado = false;
                    }
                } else {
                    resultado = false;
                }

                //Si el primer valor es correcto, sigo verificando el segundo
                if (resultado) {
                    if (auxArray[1].length() >= 2 && auxArray[1].length() <= 3) {
                        char[] auxChars2 = auxArray[1].toCharArray();

                        if (auxChars2[0] >= 'A' && auxChars2[0] <= 'M') {
                            resultado = true;
                        } else {
                            resultado = false;
                        }

                        if (resultado) {
                            if (auxChars2.length == 3) {
                                if (auxChars2[1] == '1' && (auxChars2[2] >= '1' && auxChars2[2] <= '3')) {
                                    resultado = true;
                                } else {
                                    resultado = false;
                                }
                            } else if (auxChars2.length == 2) {
                                if (auxChars2[1] >= '1' && auxChars2[1] <= '9') {
                                    resultado = true;
                                } else {
                                    resultado = false;
                                }
                            } else {
                                resultado = false;
                            }
                        } else {
                            resultado = false;
                        }
                    } else {
                        resultado = false;
                    }
                }
            } else {
                resultado = false;
            }
        } else {
            resultado = false;
        }

        if (!resultado) {//Si el formato no era el correcto devuelvo el array vacio
            auxArray[0] = "";
            auxArray[1] = "";
        }

        return auxArray;
    }
    
    
    public int[] convertirColumnaFila(String unaPosicion){
        int[] resultArray = new int[2];
        
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
        int[] numeros = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        
        String aux = unaPosicion.substring(0, 1);
        for(int i = 0; i < letras.length; i++){
            if(letras[i] == aux.toCharArray()[0]){
                resultArray[0] = numeros[i];
            }
        }
        
        String aux2 = unaPosicion.substring(1, unaPosicion.length());
        resultArray[1] = Integer.parseInt(aux2);
        
        return resultArray;
    }
    
}
