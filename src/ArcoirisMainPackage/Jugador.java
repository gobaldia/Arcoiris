package ArcoirisMainPackage;

public class Jugador {
    String nombre;
    String alias;
    int edad;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
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

    public Jugador(String unNombre, String unAlias, int unaEdad) {
        this.setNombre(unNombre);
        this.setAlias(unAlias);
        this.setEdad(unaEdad);
    }
    
    public Jugador(){
        this.setNombre("Sin nombre");
        this.setAlias("Sin alias");
        this.setEdad(0);
    }
    
    
}
