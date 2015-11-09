package Interfaz;

import ArcoirisMainPackage.Juego;
import ArcoirisMainPackage.Jugador;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class VentanaRegistroJugador extends javax.swing.JFrame {

    private Juego modelo;
    private VentanaPrincipal framePrincipal;

    public VentanaRegistroJugador(Juego unJuego, VentanaPrincipal ventanaPrincipal) {
        initComponents();
        this.setModelo(unJuego);
        this.setVentanaPrincipal(ventanaPrincipal);

        for (int i = 3; i <= 90; i++) {
            jcmbEdad.addItem(i + " años");
        }

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        //Agrego evento para manejar el hacer click en la X al cerrar el JFrame actual y asi poder volver a habilitar el menu
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                getVentanaPrincipal().UpdateMenu(true);
                dispose();
            }
        });
    }

    public Juego getModelo() {
        return modelo;
    }

    public void setModelo(Juego unModelo) {
        this.modelo = unModelo;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return framePrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal unaVentana) {
        this.framePrincipal = unaVentana;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRegistroJugador = new javax.swing.JPanel();
        jbtnGuardarJuegador = new javax.swing.JButton();
        jlblNombre = new javax.swing.JLabel();
        jlblAlias = new javax.swing.JLabel();
        jlblEdad = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jtxtAlias = new javax.swing.JTextField();
        jcmbEdad = new javax.swing.JComboBox();
        jlblErrorAlias = new javax.swing.JLabel();
        jbtnGuardarJuegador1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        jPanelRegistroJugador.setPreferredSize(new java.awt.Dimension(600, 400));

        jbtnGuardarJuegador.setText("Cancelar");
        jbtnGuardarJuegador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jlblNombre.setText("Nombre: ");

        jlblAlias.setText("Alias: ");

        jlblEdad.setText("Edad: ");

        jcmbEdad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione edad..." }));

        jlblErrorAlias.setForeground(new java.awt.Color(255, 51, 51));

        jbtnGuardarJuegador1.setText("Guardar");
        jbtnGuardarJuegador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Registro de nuevo jugador");

        javax.swing.GroupLayout jPanelRegistroJugadorLayout = new javax.swing.GroupLayout(jPanelRegistroJugador);
        jPanelRegistroJugador.setLayout(jPanelRegistroJugadorLayout);
        jPanelRegistroJugadorLayout.setHorizontalGroup(
            jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroJugadorLayout.createSequentialGroup()
                .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistroJugadorLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblEdad)
                            .addComponent(jlblAlias)
                            .addComponent(jlblNombre))
                        .addGap(31, 31, 31)
                        .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxtAlias)
                                .addComponent(jtxtNombre)
                                .addComponent(jlblErrorAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcmbEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelRegistroJugadorLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistroJugadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnGuardarJuegador1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jbtnGuardarJuegador, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanelRegistroJugadorLayout.setVerticalGroup(
            jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroJugadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistroJugadorLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblNombre))
                        .addGap(26, 26, 26)
                        .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblAlias))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblErrorAlias)
                        .addGap(24, 24, 24)
                        .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblEdad)
                            .addComponent(jcmbEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 162, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistroJugadorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnGuardarJuegador1)
                            .addComponent(jbtnGuardarJuegador))
                        .addGap(46, 46, 46))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRegistroJugador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRegistroJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        this.getVentanaPrincipal().UpdateMenu(true);
        this.dispose();

    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        if (!jtxtNombre.getText().isEmpty() && !jtxtAlias.getText().isEmpty() && jcmbEdad.getSelectedIndex() > 0) {

            Jugador unJugador = new Jugador();
            unJugador.setNombre(jtxtNombre.getText());

            /*El Index 0 es "Seleccione una opcion..." por lo que 
             el 1 va ser "3 años", y para no tener que hacer splits
             ni parseos le sumo 2 al seleccionado y se soluciona el problema.*/
            unJugador.setEdad(jcmbEdad.getSelectedIndex() + 2);

            unJugador.setAlias(jtxtAlias.getText());

            if (!this.getModelo().existeJugador(unJugador)) {
                this.getModelo().getListaDeJugadores().add(unJugador);
                JOptionPane.showMessageDialog(this, "Se creo correctamente el jugador.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();

                //this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Alias ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar todos los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnGuardarActionPerformed


    private void limpiarCampos(){
        this.jcmbEdad.setSelectedIndex(0);
        this.jtxtAlias.setText("");
        this.jtxtNombre.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelRegistroJugador;
    private javax.swing.JButton jbtnGuardarJuegador;
    private javax.swing.JButton jbtnGuardarJuegador1;
    private javax.swing.JComboBox jcmbEdad;
    private javax.swing.JLabel jlblAlias;
    private javax.swing.JLabel jlblEdad;
    private javax.swing.JLabel jlblErrorAlias;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JTextField jtxtAlias;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
