package Interfaz;

import ArcoirisMainPackage.Juego;
import java.awt.Dimension;
import java.awt.Toolkit;

public class VentanaRegistroJugador extends javax.swing.JFrame {

    private Juego modelo;
    
    public VentanaRegistroJugador(Juego unJuego) {
        initComponents();
        this.setFocusableWindowState(true);
        setModelo(unJuego);       
        
        

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
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

        jPanelRegistroJugador = new javax.swing.JPanel();
        jbtnGuardarJuegador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jtxtAlias = new javax.swing.JTextField();
        jcmbEdad = new javax.swing.JComboBox();
        jlblErrorAlias = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        jPanelRegistroJugador.setPreferredSize(new java.awt.Dimension(600, 400));

        jbtnGuardarJuegador.setText("Guardar Jugador");

        jLabel1.setText("Nombre: ");

        jLabel2.setText("Alias: ");

        jLabel3.setText("Edad: ");

        jcmbEdad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione edad...", "Item 2", "Item 3", "Item 4" }));
        jcmbEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbEdadActionPerformed(evt);
            }
        });

        jlblErrorAlias.setForeground(new java.awt.Color(255, 51, 51));
        jlblErrorAlias.setText("* Error alias repetido");

        javax.swing.GroupLayout jPanelRegistroJugadorLayout = new javax.swing.GroupLayout(jPanelRegistroJugador);
        jPanelRegistroJugador.setLayout(jPanelRegistroJugadorLayout);
        jPanelRegistroJugadorLayout.setHorizontalGroup(
            jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroJugadorLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistroJugadorLayout.createSequentialGroup()
                        .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(31, 31, 31)
                        .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtAlias)
                            .addComponent(jtxtNombre)
                            .addComponent(jlblErrorAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelRegistroJugadorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(jcmbEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistroJugadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnGuardarJuegador, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanelRegistroJugadorLayout.setVerticalGroup(
            jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroJugadorLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblErrorAlias)
                .addGap(26, 26, 26)
                .addGroup(jPanelRegistroJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcmbEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jbtnGuardarJuegador, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
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

    private void jcmbEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbEdadActionPerformed
        //Aca debemos guardar la edad seleccionada por el usuario del combobox
    }//GEN-LAST:event_jcmbEdadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelRegistroJugador;
    private javax.swing.JButton jbtnGuardarJuegador;
    private javax.swing.JComboBox jcmbEdad;
    private javax.swing.JLabel jlblErrorAlias;
    private javax.swing.JTextField jtxtAlias;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
