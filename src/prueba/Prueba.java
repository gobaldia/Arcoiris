/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import javax.swing.JOptionPane;
import Interfaz.Marco;

/**
 *
 * @author Usuario
 */
public class Prueba {
    public static void main(String[] args) {
        
        // Se crea el modelo
        Marco marco = new Marco();
        
        

        // Se crea la ventana y se le pasa el modelo por el constructor
//        VentanaPrincipal ventana = new VentanaPrincipal(casa);
        
        // Opcional: se asignar look and feel
        asignarLookAndFeel();
        
        //Se hace visible la ventana
        marco.setVisible(true);

    }
    
    public static void asignarLookAndFeel()
    {
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
