package Prueba;

import ArcoirisMainPackage.Juego;
import javax.swing.JOptionPane;
import Interfaz.VentanaPrincipal;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Inicio implements Serializable {
    public static void main(String[] args) throws IOException {

        try {
            Juego miJuego;

            File archivoGuardados = new File("archivos/juegoGuardado.txt");
            if (archivoGuardados.exists() && !archivoGuardados.isDirectory()) {//Si el archivo existe, lo levanto
                FileInputStream fa = new FileInputStream(archivoGuardados);
                BufferedInputStream ba = new BufferedInputStream(fa);
                ObjectInputStream sa = new ObjectInputStream(ba);

                miJuego = (Juego) sa.readObject();
                sa.close();
            } else {// Si no existe creo un nuevo Juego, el cual generara el archivo cuando  se cierre el programa
                miJuego = new Juego();
            }

            //Se crea el modelo
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(miJuego);
            // Opcional: se asignar look and feel
            asignarLookAndFeel();
            //Se hace visible la ventana
            ventanaPrincipal.setVisible(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
