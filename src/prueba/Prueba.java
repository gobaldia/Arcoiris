package prueba;

import ArcoirisMainPackage.Juego;
import javax.swing.JOptionPane;
import Interfaz.VentanaPrincipal;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prueba implements Serializable{
    public static void main(String[] args) throws IOException {
        Juego miJuego = new Juego();
        
        
        
        
        //Se crea el modelo
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(miJuego);

        //Se crea la ventana y se le pasa el modelo por el constructor
        //VentanaPrincipal ventana = new VentanaPrincipal();
        // Opcional: se asignar look and feel
        asignarLookAndFeel();

        //Se hace visible la ventana
        ventanaPrincipal.setVisible(true);
    }

    public static void asignarLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al asignar Look And Feel", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
