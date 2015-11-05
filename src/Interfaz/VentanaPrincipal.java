package Interfaz;

import ArcoirisMainPackage.Juego;

public class VentanaPrincipal extends javax.swing.JFrame {
    private Juego modelo;
    
    public VentanaPrincipal(Juego unJuego) {
        initComponents();
        this.setModelo(unJuego);
    }
    
    public Juego getModelo() {
        return modelo;
    }
    public void setModelo(Juego unModelo) {
        this.modelo = unModelo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jlblImagenPrincipal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuJugar = new javax.swing.JMenu();
        jMenuItemNuevaPartida = new javax.swing.JMenuItem();
        jMenuItemVolveraJugar = new javax.swing.JMenuItem();
        jMenuHistorial = new javax.swing.JMenu();
        jMenuItemRanking = new javax.swing.JMenuItem();
        jMenuItemRepetirPartida = new javax.swing.JMenuItem();
        jMenuConfiguraciones = new javax.swing.JMenu();
        jIMenuItemConfigurarNuevaPartida = new javax.swing.JMenuItem();
        jMenuItemRegistroJugador = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(800, 600));

        jlblImagenPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgArcoiris2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jlblImagenPrincipal)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblImagenPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuJugar.setText("Jugar");

        jMenuItemNuevaPartida.setText("Nueva Partida");
        jMenuItemNuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevaPartidaActionPerformed(evt);
            }
        });
        jMenuJugar.add(jMenuItemNuevaPartida);

        jMenuItemVolveraJugar.setText("Volver a Jugar");
        jMenuItemVolveraJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVolveraJugarActionPerformed(evt);
            }
        });
        jMenuJugar.add(jMenuItemVolveraJugar);

        jMenuBar1.add(jMenuJugar);

        jMenuHistorial.setText("Historial");

        jMenuItemRanking.setText("Ranking");
        jMenuItemRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRankingActionPerformed(evt);
            }
        });
        jMenuHistorial.add(jMenuItemRanking);

        jMenuItemRepetirPartida.setText("Repetición de Partidas");
        jMenuItemRepetirPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRepetirPartidaActionPerformed(evt);
            }
        });
        jMenuHistorial.add(jMenuItemRepetirPartida);

        jMenuBar1.add(jMenuHistorial);

        jMenuConfiguraciones.setText("Configuraciónes");

        jIMenuItemConfigurarNuevaPartida.setText("Configurar Nueva Partida");
        jIMenuItemConfigurarNuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIMenuItemConfigurarNuevaPartidaActionPerformed(evt);
            }
        });
        jMenuConfiguraciones.add(jIMenuItemConfigurarNuevaPartida);

        jMenuItemRegistroJugador.setText("Registrar Nuevo Jugador");
        jMenuItemRegistroJugador.setToolTipText("");
        jMenuItemRegistroJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistroJugadorActionPerformed(evt);
            }
        });
        jMenuConfiguraciones.add(jMenuItemRegistroJugador);

        jMenuBar1.add(jMenuConfiguraciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(806, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemVolveraJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVolveraJugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemVolveraJugarActionPerformed

    private void jIMenuItemConfigurarNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIMenuItemConfigurarNuevaPartidaActionPerformed
        VentanaConfiguracionPartida ventana = new VentanaConfiguracionPartida(this.getModelo());
        ventana.setVisible(true);
    }//GEN-LAST:event_jIMenuItemConfigurarNuevaPartidaActionPerformed

    private void jMenuItemNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevaPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemNuevaPartidaActionPerformed

    private void jMenuItemRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRankingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemRankingActionPerformed

    private void jMenuItemRepetirPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRepetirPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemRepetirPartidaActionPerformed

    private void jMenuItemRegistroJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistroJugadorActionPerformed
        VentanaRegistroJugador ventana = new VentanaRegistroJugador(this.getModelo());
        ventana.setVisible(true);
    }//GEN-LAST:event_jMenuItemRegistroJugadorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jIMenuItemConfigurarNuevaPartida;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConfiguraciones;
    private javax.swing.JMenu jMenuHistorial;
    private javax.swing.JMenuItem jMenuItemNuevaPartida;
    private javax.swing.JMenuItem jMenuItemRanking;
    private javax.swing.JMenuItem jMenuItemRegistroJugador;
    private javax.swing.JMenuItem jMenuItemRepetirPartida;
    private javax.swing.JMenuItem jMenuItemVolveraJugar;
    private javax.swing.JMenu jMenuJugar;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JLabel jlblImagenPrincipal;
    // End of variables declaration//GEN-END:variables

}
