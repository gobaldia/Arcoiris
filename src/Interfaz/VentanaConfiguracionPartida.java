package Interfaz;

import ArcoirisMainPackage.Juego;
import ArcoirisMainPackage.Jugador;
import ArcoirisMainPackage.Partida;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class VentanaConfiguracionPartida extends javax.swing.JFrame {

    private Juego modelo;
    private VentanaPrincipal framePrincipal;
    private Jugador jugadorA;
    private Jugador jugadorB;
    private ArrayList<Jugador> listaSinJugadorSeleccionado;

    public VentanaConfiguracionPartida(Juego unJuego, VentanaPrincipal ventanaPrincipal) {
        initComponents();
        this.setModelo(unJuego);
        this.setVentanaPrincipal(ventanaPrincipal);
        this.setAlwaysOnTop(true);
        listaSinJugadorSeleccionado = new ArrayList<Jugador>();
        
        
        //A modo de situar los JFrames centrados en la pantalla utilizo lo siguiente
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 4 - this.getSize().width / 4, dim.height / 2 - this.getSize().height / 2);

        //Agrego evento para manejar el hacer click en la X al cerrar el JFrame actual y asi poder volver a habilitar el menu
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                getVentanaPrincipal().UpdateMenu(true);
                dispose();
            }
        });

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

    private VentanaPrincipal getVentanaPrincipal() {
        return this.framePrincipal;
    }

    private void setVentanaPrincipal(VentanaPrincipal unaVentana) {
        this.framePrincipal = unaVentana;
    }

    private void setJugadorA(Jugador unJugador) {
        this.jugadorA = unJugador;
    }

    private Jugador getJugadorA() {
        return this.jugadorA;
    }

    private void setJugadorB(Jugador unJugador) {
        this.jugadorB = unJugador;
    }

    private Jugador getJugadorB() {
        return this.jugadorB;
    }

    private void deshabilitarPanel() {
        this.jListJugadores.setEnabled(false);
        this.jbtnGuardar.setEnabled(false);
        this.jchkTimer.setEnabled(false);
        this.jcmbDistribucionFichas.setEnabled(false);
        this.jcmbMarcoInicio.setEnabled(false);
        this.jrbPrimeroOcuparCentro.setEnabled(false);
        this.jrbSinFichas.setEnabled(false);
        this.jbtnAgregarJugador.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTerminar = new javax.swing.ButtonGroup();
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
        jbtnAgregarJugador = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jcmbCantidadMovimientos = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 500));
        setResizable(false);

        jPanelConfiguracionPartida.setPreferredSize(new java.awt.Dimension(750, 500));

        jListJugadores.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListJugadores);

        jlbltitulo.setText("Lista de jugadores");

        jlblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblTitulo.setText("Configuracion de Partida");

        jbtnGuardar.setText("Guardar");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

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

        buttonGroupTerminar.add(jrbSinFichas);
        jrbSinFichas.setSelected(true);
        jrbSinFichas.setText("Ambos jugadores se quedan sin jugadas.");
        jrbSinFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSinFichasActionPerformed(evt);
            }
        });

        buttonGroupTerminar.add(jrbPrimeroOcuparCentro);
        jrbPrimeroOcuparCentro.setText("Primero en ocupar el centro.");
        jrbPrimeroOcuparCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPrimeroOcuparCentroActionPerformed(evt);
            }
        });

        jLabel4.setText("Jugar con timer:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel5.setText("(1 es el marco más externo)");

        jbtnAgregarJugador.setText("Agregar");
        jbtnAgregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarJugadorActionPerformed(evt);
            }
        });

        jLabel6.setText("Cantidad de movimientos:");

        jcmbCantidadMovimientos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "14", "16", "20", "24" }));

        javax.swing.GroupLayout jPanelConfiguracionPartidaLayout = new javax.swing.GroupLayout(jPanelConfiguracionPartida);
        jPanelConfiguracionPartida.setLayout(jPanelConfiguracionPartidaLayout);
        jPanelConfiguracionPartidaLayout.setHorizontalGroup(
            jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfiguracionPartidaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jchkTimer)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcmbCantidadMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcmbDistribucionFichas, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                        .addComponent(jbtnAgregarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jlblJugador1)
                                        .addGap(32, 32, 32)
                                        .addComponent(jlblVS)
                                        .addGap(29, 29, 29)
                                        .addComponent(jlblJugador2))
                                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                        .addComponent(jcmbMarcoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfiguracionPartidaLayout.createSequentialGroup()
                            .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbSinFichas)
                            .addComponent(jrbPrimeroOcuparCentro))))
                .addContainerGap(41, Short.MAX_VALUE))
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
                                .addGap(3, 3, 3)
                                .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlblJugador1)
                                    .addComponent(jlblJugador2)
                                    .addComponent(jbtnAgregarJugador)))
                            .addComponent(jlblVS))
                        .addGap(32, 32, 32)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jcmbMarcoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcmbDistribucionFichas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(20, 20, 20)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanelConfiguracionPartidaLayout.createSequentialGroup()
                                .addComponent(jrbSinFichas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbPrimeroOcuparCentro)))
                        .addGap(14, 14, 14)
                        .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelConfiguracionPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jchkTimer)
                            .addComponent(jcmbCantidadMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
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

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        this.getVentanaPrincipal().UpdateMenu(true);
        this.dispose();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarJugadorActionPerformed
        int index = jListJugadores.getSelectedIndex();
        
        if (index >= 0) {
            if (this.getJugadorA() == null) {
                int nroJugador = Integer.parseInt(jListJugadores.getSelectedValue().toString().substring(0,1));                
                ((DefaultListModel)jListJugadores.getModel()).removeElementAt(index);
                
                for(int i = 0; i < this.getModelo().getListaDeJugadores().size(); i++){
                    if(i == (nroJugador -1)){
                        this.setJugadorA(this.getModelo().getListaDeJugadores().get(i));
                        jlblJugador1.setText(this.getModelo().getListaDeJugadores().get(i).getAlias());
                    }
                }
            } else if (this.getJugadorB() == null) {
                int nroJugador = Integer.parseInt(jListJugadores.getSelectedValue().toString().substring(0,1));                
                ((DefaultListModel)jListJugadores.getModel()).removeElementAt(index);
                
                for(int i = 0; i < this.getModelo().getListaDeJugadores().size(); i++){
                    if(i == (nroJugador -1)){
                        this.setJugadorB(this.getModelo().getListaDeJugadores().get(i));
                        jlblJugador2.setText(this.getModelo().getListaDeJugadores().get(i).getAlias());
                    }
                }
            } else {
                jListJugadores.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jbtnAgregarJugadorActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        try {
            if (this.getJugadorA() != null && this.getJugadorB() != null) {
                Partida unaPartida = new Partida();
                
                unaPartida.agregarJugadorA(this.getJugadorA());
                unaPartida.agregarJugadorB(this.getJugadorB());
                unaPartida.setMarcoInicio(jcmbMarcoInicio.getSelectedIndex() + 1);
                unaPartida.setDistribucionInicialFichas(jcmbDistribucionFichas.getSelectedIndex() + 1);
                
                if(jrbPrimeroOcuparCentro.isSelected()){
                    unaPartida.setTipoFinPartida(2);
                    unaPartida.setCantidadMovimientos(100);
                } else {
                    unaPartida.setTipoFinPartida(1);
                    unaPartida.setCantidadMovimientos(((Integer)jcmbCantidadMovimientos.getSelectedItem()).intValue());
                }
                
                if(jchkTimer.isSelected()){
                    unaPartida.setTimer(true);
                }
                
                this.getModelo().agregarPartida(unaPartida);
                JOptionPane.showMessageDialog(this, "Se configuró la partida correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccionar 2 jugadores.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this, "Ocurrio un error al querer guardar la partida", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jrbPrimeroOcuparCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPrimeroOcuparCentroActionPerformed
        jcmbCantidadMovimientos.setSelectedIndex(0);
        jcmbCantidadMovimientos.setEnabled(false);
    }//GEN-LAST:event_jrbPrimeroOcuparCentroActionPerformed

    private void jrbSinFichasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSinFichasActionPerformed
        jcmbCantidadMovimientos.setSelectedIndex(0);
        jcmbCantidadMovimientos.setEnabled(true);
    }//GEN-LAST:event_jrbSinFichasActionPerformed

    private void listarJugadores() {
        ArrayList<Jugador> auxListaJugadores = this.getModelo().getListaDeJugadores();

        DefaultListModel modeloLista = new DefaultListModel();
        for (int i = 0; i < auxListaJugadores.size(); i++) {
            modeloLista.addElement(i + 1 + ". " + auxListaJugadores.get(i).toString());
        }

        jListJugadores.setModel(modeloLista);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTerminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jListJugadores;
    private javax.swing.JPanel jPanelConfiguracionPartida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAgregarJugador;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JCheckBox jchkTimer;
    private javax.swing.JComboBox jcmbCantidadMovimientos;
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
