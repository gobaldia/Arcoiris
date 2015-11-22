package Interfaz;

import ArcoirisMainPackage.Juego;
import ArcoirisMainPackage.Partida;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlblTituloRanking.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblTituloRanking.setText("Ranking");

        javax.swing.GroupLayout jPanelRankingLayout = new javax.swing.GroupLayout(jPanelRanking);
        jPanelRanking.setLayout(jPanelRankingLayout);
        jPanelRankingLayout.setHorizontalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRankingLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jlblTituloRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanelRankingLayout.setVerticalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRankingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTituloRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRanking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRanking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelRanking;
    private javax.swing.JLabel jlblTituloRanking;
    // End of variables declaration//GEN-END:variables
}
