package Interfaz;

import ArcoirisMainPackage.Juego;
import ArcoirisMainPackage.Jugador;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class VentanaRanking extends javax.swing.JFrame {

    private Juego modelo;
    private VentanaPrincipal framePrincipal;

    public VentanaRanking(Juego unJuego, VentanaPrincipal ventanaPrincipal) {
        initComponents();
        this.setModelo(unJuego);
        this.setVentanaPrincipal(ventanaPrincipal);

        //Agrego evento para manejar el hacer click en la X al cerrar el JFrame actual y asi poder volver a habilitar el menu
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                getVentanaPrincipal().UpdateMenu(true);
                dispose();
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 3 - this.getSize().width / 3, dim.height / 3 - this.getSize().height / 3);

        if(getModelo().getListaDeJugadores().size() > 0){
            getModelo().obtenerRanking();
            mostrarRanking();
            
        } else {
            JOptionPane.showMessageDialog(this, "No existe jugadores registrados", "Error", JOptionPane.CANCEL_OPTION);
            jListRanking.setEnabled(false);
        }

        /*
        if (unJuego.getListaDeJugadores().isEmpty()) {
            System.out.println("\nNo existen jugadores.");
        } else {
            for (int i = 0; i < unJuego.getListaDeJugadores().size(); i++) {
                Jugador j = unJuego.getListaDeJugadores().get(i);
                System.out.println(j.toString() + " || " + "Ganadas: " + j.getGanadas()
                        + " | Empatadas: " + j.getEmpates()
                        + " | Perdidas: " + j.getPerdidas());
            }
        }
        */
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    private void setModelo(Juego unModelo) {
        this.modelo = unModelo;
    }

    private Juego getModelo() {
        return this.modelo;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return framePrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal unaVentana) {
        this.framePrincipal = unaVentana;
    }
    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRanking = new javax.swing.JPanel();
        jlblTituloRanking = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRanking = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jlblTituloRanking.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblTituloRanking.setText("Ranking");

        jScrollPane1.setViewportView(jListRanking);

        javax.swing.GroupLayout jPanelRankingLayout = new javax.swing.GroupLayout(jPanelRanking);
        jPanelRanking.setLayout(jPanelRankingLayout);
        jPanelRankingLayout.setHorizontalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRankingLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelRankingLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jlblTituloRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanelRankingLayout.setVerticalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRankingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTituloRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRanking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jListRanking;
    private javax.swing.JPanel jPanelRanking;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlblTituloRanking;
    // End of variables declaration//GEN-END:variables


    private void mostrarRanking(){
         ArrayList<Jugador> auxListaJugadores = this.getModelo().getListaDeJugadores();
         String aux = "";
         
        DefaultListModel modeloLista = new DefaultListModel();
        for (int i = 0; i < auxListaJugadores.size(); i++) {
            
            Jugador j = auxListaJugadores.get(i);
            aux = j.toString() + " || " + "Ganadas: " + j.getGanadas()
                        + " | Empatadas: " + j.getEmpates()
                        + " | Perdidas: " + j.getPerdidas();
            
            
            modeloLista.addElement(i + 1 + ". " + aux);
        }

        jListRanking.setModel(modeloLista);
    }
}
