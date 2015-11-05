package Interfaz;

import ArcoirisMainPackage.Juego;
import ArcoirisMainPackage.Jugador;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class VentanaConfiguracionPartida extends javax.swing.JFrame {

    private Juego modelo;

    public VentanaConfiguracionPartida(Juego unJuego) {
        initComponents();
        this.setModelo(unJuego);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 4 - this.getSize().width / 4, dim.height / 2 - this.getSize().height / 2);

        if (this.getModelo().getListaDeJugadores().size() >= 2) {
            listarJugadores();

        } else {
            JOptionPane.showMessageDialog(this, "No existe la cantidad minima de jugadores (2).\nVaya a 'Registro de Jugadores'", "Error", JOptionPane.CANCEL_OPTION);
            //Deshabilito todas las opciones del panel.
            deshabilitarPanel();
        }
    }

    private void setModelo(Juego unModelo) {
        this.modelo = unModelo;
    }

    private Juego getModelo() {
        return this.modelo;
    }

    private void deshabilitarPanel() {
        this.jListJugadores.setEnabled(false);
        this.jbtnGuardar.setEnabled(false);
        this.jchkTimer.setEnabled(false);
        this.jcmbDistribucionFichas.setEnabled(false);
        this.jcmbMarcoInicio.setEnabled(false);
        this.jrbPrimeroOcuparCentro.setEnabled(false);
        this.jrbSinFichas.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelConfiguracionPartida = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListJugadores = new javax.swing.JList();
        jlbltitulo = new javax.swing.JLabel();
        jlblTitulo = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jlblVS = new javax.swing.JLabel();
        jlblJugador1 = new javax.swing.JLabel();
        jlblJugador2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcmbMarcoInicio = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jcmbDistribucionFichas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jrbSinFichas = new javax.swing.JRadioButton();
        jrbPrimeroOcuparCentro = new javax.swing.JRadioButton();
        jchkTimer = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 500));
        setResizable(false);

        jPanelConfiguracionPartida.setPreferredSize(new java.awt.Dimension(750, 500));

        jListJugadores.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListJugadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListJugadores);

        jlbltitulo.setText("Lista de jugadores");

        jlblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblTitulo.setText("Configuracion de Partida");

        jbtnGuardar.setText("Guardar");

        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jlblVS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblVS.setText("vs");

        jlblJugador1.setText("___________");

        jlblJugador2.setText("___________");

        jLabel1.setText("Marco inicial: ");

        jcmbMarcoInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        jLabel2.setText("Distribucion de fichas:");

        jcmbDistribucionFichas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Al azar", "En 'I', borde superior e inferior en negro N y bordes laterales blancos B", "En 'L', borde izquierdo e inferior blanco, borde superior y derecho negro" }));
        jcmbDistribucionFichas.setMinimumSize(new java.awt.Dimension(460, 22));

        jLabel3.setText("Formas de terminar:");

        jrbSinFichas.setText("Ambos jugadores se quedan sin jugadas.");

        jrbPrimeroOcuparCentro.setText("Primero en ocupar el centro.");

        jLabel4.setText("Jugar con timer:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel5.setText("(1 es el marco más externo)");

        javax.swing.GroupLayout jPanelConfiguracionPartidaLayout = new javax.swing.GroupLayout(jPanelConfiguracionPartida);
        jPanelConfiguracionPartida.setLayout(jPanelConfiguracionPartidaLayout);
        jPanelConfiguracionPartidaLayout.setHorizontalGroup(
            jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfiguracionPartidaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)))
                .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jchkTimer)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jlblJugador1)
                                .addGap(44, 44, 44)
                                .addComponent(jlblVS)
                                .addGap(43, 43, 43)
                                .addComponent(jlblJugador2))
                            .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(jcmbMarcoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel5))
                                        .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(jcmbDistribucionFichas, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jrbSinFichas)
                                            .addComponent(jrbPrimeroOcuparCentro)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                        .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(47, Short.MAX_VALUE))))
        );
        jPanelConfiguracionPartidaLayout.setVerticalGroup(
            jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfiguracionPartidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jlbltitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlblJugador1)
                                    .addComponent(jlblJugador2)))
                            .addComponent(jlblVS))
                        .addGap(37, 37, 37)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jcmbMarcoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcmbDistribucionFichas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbSinFichas)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbPrimeroOcuparCentro)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jchkTimer)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConfiguracionPartida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConfiguracionPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListJugadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListJugadoresMouseClicked
        JList listaDeJugadores = (JList) evt.getSource();

        if (evt.getClickCount() == 2) {
            int index = listaDeJugadores.locationToIndex(evt.getPoint());
            //System.out.println("index: " + index);
        }
    }//GEN-LAST:event_jListJugadoresMouseClicked

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void listarJugadores() {
        ArrayList<Jugador> auxListaJugadores = this.getModelo().getListaDeJugadores();
       
        DefaultListModel modeloLista = new DefaultListModel();
        for (int i = 0; i < auxListaJugadores.size(); i++) {
            modeloLista.addElement(i + 1 + ". " + auxListaJugadores.get(i).toString());           
        }
        
        jListJugadores.setModel(modeloLista);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jListJugadores;
    private javax.swing.JPanel jPanelConfiguracionPartida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JCheckBox jchkTimer;
    private javax.swing.JComboBox jcmbDistribucionFichas;
    private javax.swing.JComboBox jcmbMarcoInicio;
    private javax.swing.JLabel jlblJugador1;
    private javax.swing.JLabel jlblJugador2;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblVS;
    private javax.swing.JLabel jlbltitulo;
    private javax.swing.JRadioButton jrbPrimeroOcuparCentro;
    private javax.swing.JRadioButton jrbSinFichas;
    // End of variables declaration//GEN-END:variables

  
}
