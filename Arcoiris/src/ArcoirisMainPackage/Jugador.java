package ArcoirisMainPackage;

import java.io.Serializable;

public class Jugador implements Comparable<Jugador>, Serializable {

    private String nombre;
    private String alias;
    private int edad;
    private int ganadas;
    private int perdidas;
    private int empates;
    private char tipoFicha;//B = Blancas, N = Negras

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public char getTipoFicha() {
        return this.tipoFicha;
    }

    public void setTipoFicha(char unTipoFicha) {
        this.tipoFicha = unTipoFicha;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public int getGanadas() {
        return this.ganadas;
    }

    public int getPerdidas() {
        return this.perdidas;
    }

    public int getEmpates() {
        return this.empates;
    }

    public void setGanadas(int valorGanadas) {
        this.ganadas = valorGanadas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public Jugador(String unNombre, String unAlias, int unaEdad) {
        this.setNombre(unNombre);
        this.setAlias(unAlias);
        this.setEdad(unaEdad);
        this.setGanadas(0);
        this.setPerdidas(0);
        this.setEmpates(0);
    }

    public Jugador() {
        this.setNombre("Sin nombre");
        this.setAlias("Sin alias");
        this.setEdad(0);
        this.setGanadas(0);
        this.setPerdidas(0);
        this.setEmpates(0);
    }

    @Override
    public String toString() {
        return "Alias: " + this.getAlias() + " | Nombre: " + this.getNombre() + " | Edad: " + this.getEdad();
    }

    @Override
    public int compareTo(Jugador unJugador) {
        return this.getAlias().compareTo(unJugador.getAlias());
    }

    @Override
    public boolean equals(Object unObjeto) {
        return (((Jugador) unObjeto).getAlias().toUpperCase().equals(this.getAlias().toUpperCase()));
    }
}
