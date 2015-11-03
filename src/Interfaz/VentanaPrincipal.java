package Interfaz;

public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        try {
            initComponents();

           
        } catch (Exception e) {
            //Ver como manejar excepciones
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jImage = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuJugar = new javax.swing.JMenu();
        jMenuItemNuevaPartida = new javax.swing.JMenuItem();
        jMenuItemVolveraJugar = new javax.swing.JMenuItem();
        jMenuHistorial = new javax.swing.JMenu();
        jMenuItemRanking = new javax.swing.JMenuItem();
        jMenuItemRepetirPartida = new javax.swing.JMenuItem();
        jMenuConfiguraciones = new javax.swing.JMenu();
        jIMenuItemConfigurarNuevaPartida = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jImage.setText("jLabel1");

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jImage, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jImage, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
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

        jMenuBar1.add(jMenuConfiguraciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(500, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemVolveraJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVolveraJugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemVolveraJugarActionPerformed

    private void jIMenuItemConfigurarNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIMenuItemConfigurarNuevaPartidaActionPerformed
        // TODO add your handling code here:
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jIMenuItemConfigurarNuevaPartida;
    private javax.swing.JLabel jImage;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConfiguraciones;
    private javax.swing.JMenu jMenuHistorial;
    private javax.swing.JMenuItem jMenuItemNuevaPartida;
    private javax.swing.JMenuItem jMenuItemRanking;
    private javax.swing.JMenuItem jMenuItemRepetirPartida;
    private javax.swing.JMenuItem jMenuItemVolveraJugar;
    private javax.swing.JMenu jMenuJugar;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables

}
