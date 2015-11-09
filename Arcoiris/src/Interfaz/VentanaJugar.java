package Interfaz;

import ArcoirisMainPackage.Juego;
import ArcoirisMainPackage.Partida;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VentanaJugar extends javax.swing.JFrame {

    private Juego modelo;
    private VentanaPrincipal framePrincipal;
    private Partida partidaActual;
    private Partida proximaPartida;
    private JButton[][] botones;
    private JButton[] btnColumnas;
    private JButton[] btnFilas;

    public VentanaJugar(Juego unJuego, VentanaPrincipal ventanaPrincipal) {
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

        if (getModelo().getListaDePartidas().size() > 0) {
            ArrayList<Partida> listaDePartidas = this.getModelo().ordenarPartidasDesc();
            this.setPartidaActual(listaDePartidas.get(0));//Obtengo la ultima partida configurada.           

            this.getPartidaActual().getJugadorA().setTipoFicha('N');
            this.getPartidaActual().getJugadorB().setTipoFicha('B');

            //Genero una nueva partida en caso de quere volver a jugar antes de configurar una nueva.
            Partida proximaPartida = new Partida();
            proximaPartida.setJugadorA(this.getPartidaActual().getJugadorA());
            proximaPartida.setJugadorB(this.getPartidaActual().getJugadorB());
            proximaPartida.setMarcoInicio(this.getPartidaActual().getMarcoInicio());
            proximaPartida.setDistribucionInicialFichas(this.getPartidaActual().getDistribucionInicialFichas());
            proximaPartida.setTipoFinPartida(this.getPartidaActual().getTipoFinPartida());
            proximaPartida.generarTableroInicial(this.getPartidaActual().getDistribucionInicialFichas(), this.getPartidaActual().getMarcoInicio());
            proximaPartida.setCantidadMovimientos(this.getPartidaActual().getCantidadMovimientos());
            proximaPartida.setTimer(this.getPartidaActual().getTimer());

            jlblJugadorA.setText(this.getPartidaActual().getJugadorA().getAlias());
            jlblJugadorB.setText(this.getPartidaActual().getJugadorB().getAlias());

            generarIndicesFilaColumna();
            mostrarTablero(this.getPartidaActual().getListaDeTableros().get(0).getMatriz());
            
//            generarGrilla();

        } else {
            JOptionPane.showMessageDialog(this, "No existen partidas configuradas.", "Error", JOptionPane.CANCEL_OPTION);
            //Deshabilito todas las opciones del panel.
            dispose();
        }
    }

    private void setModelo(Juego unModelo) {
        this.modelo = unModelo;
    }

    private Juego getModelo() {
        return this.modelo;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return framePrincipal;
    }

    private void setPartidaActual(Partida unaPartida) {
        this.partidaActual = unaPartida;
    }

    private Partida getPartidaActual() {
        return this.partidaActual;
    }

    private Partida getProximaPartida() {
        return this.proximaPartida;
    }

    private void setProximaPartida(Partida unaPartida) {
        this.proximaPartida = unaPartida;
    }

    public void setVentanaPrincipal(VentanaPrincipal unaVentana) {
        this.framePrincipal = unaVentana;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelJugar = new javax.swing.JPanel();
        jPanelColumnas = new javax.swing.JPanel();
        jPanelFilas = new javax.swing.JPanel();
        jPanelDetalle = new javax.swing.JPanel();
        jlblJugadorA = new javax.swing.JLabel();
        jlblJugadorB = new javax.swing.JLabel();
        jlblVS = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanelJugar.setPreferredSize(new java.awt.Dimension(600, 500));

        javax.swing.GroupLayout jPanelJugarLayout = new javax.swing.GroupLayout(jPanelJugar);
        jPanelJugar.setLayout(jPanelJugarLayout);
        jPanelJugarLayout.setHorizontalGroup(
            jPanelJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanelJugarLayout.setVerticalGroup(
            jPanelJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        jPanelColumnas.setPreferredSize(new java.awt.Dimension(600, 40));

        javax.swing.GroupLayout jPanelColumnasLayout = new javax.swing.GroupLayout(jPanelColumnas);
        jPanelColumnas.setLayout(jPanelColumnasLayout);
        jPanelColumnasLayout.setHorizontalGroup(
            jPanelColumnasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanelColumnasLayout.setVerticalGroup(
            jPanelColumnasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanelFilas.setPreferredSize(new java.awt.Dimension(40, 500));

        javax.swing.GroupLayout jPanelFilasLayout = new javax.swing.GroupLayout(jPanelFilas);
        jPanelFilas.setLayout(jPanelFilasLayout);
        jPanelFilasLayout.setHorizontalGroup(
            jPanelFilasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanelFilasLayout.setVerticalGroup(
            jPanelFilasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jlblJugadorA.setText("_______");

        jlblJugadorB.setText("_______");

        jlblVS.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblVS.setText("vs");

        javax.swing.GroupLayout jPanelDetalleLayout = new javax.swing.GroupLayout(jPanelDetalle);
        jPanelDetalle.setLayout(jPanelDetalleLayout);
        jPanelDetalleLayout.setHorizontalGroup(
            jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblJugadorA)
                .addGap(30, 30, 30)
                .addComponent(jlblVS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jlblJugadorB)
                .addGap(23, 23, 23))
        );
        jPanelDetalleLayout.setVerticalGroup(
            jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblJugadorA)
                    .addComponent(jlblJugadorB)
                    .addComponent(jlblVS))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanelFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelJugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarIndicesFilaColumna() {
        jPanelColumnas.setLayout(new FlowLayout(13));
        btnColumnas = new JButton[13];

        for (int i = 0; i < btnColumnas.length; i++) {
            JButton nuevoBoton = new JButton();
            nuevoBoton.setPreferredSize(new Dimension(40, 30));
            nuevoBoton.setFont(new Font("Arial", Font.BOLD, 10));
            nuevoBoton.setText(i + 1 + "");
            nuevoBoton.setBackground(Color.GRAY);
            jPanelColumnas.add(nuevoBoton);
            btnColumnas[i] = nuevoBoton;
        }

        jPanelFilas.setLayout(new FlowLayout(13));
        btnFilas = new JButton[13];

        for (int i = 0; i < btnFilas.length; i++) {
            JButton nuevoBoton = new JButton();
            nuevoBoton.setPreferredSize(new Dimension(40, 30));
            nuevoBoton.setFont(new Font("Arial", Font.BOLD, 10));
            nuevoBoton.setBackground(Color.GRAY);
            nuevoBoton.setText(i + 1 + "");
            //nuevoBoton.setEnabled(false);
            jPanelFilas.add(nuevoBoton);
            btnFilas[i] = nuevoBoton;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelColumnas;
    private javax.swing.JPanel jPanelDetalle;
    private javax.swing.JPanel jPanelFilas;
    private javax.swing.JPanel jPanelJugar;
    private javax.swing.JLabel jlblJugadorA;
    private javax.swing.JLabel jlblJugadorB;
    private javax.swing.JLabel jlblVS;
    // End of variables declaration//GEN-END:variables

    private void mostrarTablero(char[][] unTablero) {
        try {
            jPanelJugar.setLayout(new GridLayout(13, 13));
            botones = new JButton[14][14];

            ImageIcon neg = new ImageIcon(new File(".").getCanonicalPath() + "\\src\\Imagenes\\negra.png");
            Image negra = neg.getImage();
            Image fichaNegra = negra.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            neg = new ImageIcon(fichaNegra);

            ImageIcon blan = new ImageIcon(new File(".").getCanonicalPath() + "\\src\\Imagenes\\blanca.png");
            Image blanca = blan.getImage();
            Image fichaBlanca = blanca.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
            blan = new ImageIcon(fichaBlanca);

            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 13; j++) {
                    JButton jButton = new JButton();
                    jButton.addActionListener(new ListenerBoton(i, j));
                    jButton.setPreferredSize(new Dimension(20, 20));
                    jButton.setFont(new Font("Arial", Font.PLAIN, 10));
                    jPanelJugar.add(jButton);
                    botones[i][j] = jButton;

                    if (medirDistanciaMarco(i, j, 1)) {
                        if (unTablero[i][j] == 'B') {
                            botones[i][j].setIcon(blan);
                        } else if (unTablero[i][j] == 'N') {
                            botones[i][j].setIcon(neg);
                        } else {
                            botones[i][j].setBackground(Color.RED);
                        }
                    } else if (medirDistanciaMarco(i, j, 2)) {
                        if (unTablero[i][j] == 'B') {
                            botones[i][j].setIcon(blan);
                        } else if (unTablero[i][j] == 'N') {
                            botones[i][j].setIcon(neg);
                        } else {
                            botones[i][j].setBackground(Color.ORANGE);
                        }
                    } else if (medirDistanciaMarco(i, j, 3)) {
                        if (unTablero[i][j] == 'B') {
                            botones[i][j].setIcon(blan);
                        } else if (unTablero[i][j] == 'N') {
                            botones[i][j].setIcon(neg);
                        } else {
                            botones[i][j].setBackground(Color.YELLOW);
                        }
                    } else if (medirDistanciaMarco(i, j, 4)) {
                        if (unTablero[i][j] == 'B') {
                            botones[i][j].setIcon(blan);
                        } else if (unTablero[i][j] == 'N') {
                            botones[i][j].setIcon(neg);
                        } else {
                            botones[i][j].setBackground(Color.GREEN);
                        }
                    } else if (medirDistanciaMarco(i, j, 5)) {
                        if (unTablero[i][j] == 'B') {
                            botones[i][j].setIcon(blan);
                        } else if (unTablero[i][j] == 'N') {
                            botones[i][j].setIcon(neg);
                        } else {
                            botones[i][j].setBackground(Color.CYAN);
                        }
                    } else if (medirDistanciaMarco(i, j, 6)) {
                        if (unTablero[i][j] == 'B') {
                            botones[i][j].setIcon(blan);
                        } else if (unTablero[i][j] == 'N') {
                            botones[i][j].setIcon(neg);
                        } else {
                            botones[i][j].setBackground(Color.BLUE);
                        }
                    } else {
                        botones[i][j].setBackground(Color.WHITE);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(VentanaJugar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        private boolean medirDistanciaMarco(int fila, int columna, int marcoAPintar) {
        boolean bandera = false;

        switch (marcoAPintar) {
            case 1:
                if ((fila == 0 && (columna >= 0 && columna <= 12))
                        || (columna == 0 && (fila >= 0 && fila <= 12))) {
                    bandera = true;
                } else if ((fila == 12 && (columna >= 0 && columna <= 12))
                        || (columna == 12 && (fila >= 0 && fila <= 12))) {
                    bandera = true;
                }
                break;
            case 2:
                if ((fila == 1 && (columna >= 1 && columna <= 11))
                        || (columna == 1 && (fila >= 1 && fila <= 11))) {
                    bandera = true;
                } else if ((fila == 11 && (columna >= 1 && columna <= 11))
                        || (columna == 11 && (fila >= 1 && fila <= 11))) {
                    bandera = true;
                }
                break;
            case 3:
                if ((fila == 2 && (columna >= 2 && columna <= 10))
                        || (columna == 2 && (fila >= 2 && fila <= 10))) {
                    bandera = true;
                } else if ((fila == 10 && (columna >= 2 && columna <= 10))
                        || (columna == 10 && (fila >= 2 && fila <= 10))) {
                    bandera = true;
                }
                break;
            case 4:
                if ((fila == 3 && (columna >= 3 && columna <= 9))
                        || (columna == 3 && (fila >= 3 && fila <= 9))) {
                    bandera = true;
                } else if ((fila == 9 && (columna >= 3 && columna <= 9))
                        || (columna == 9 && (fila >= 3 && fila <= 9))) {
                    bandera = true;
                }
                break;
            case 5:
                if ((fila == 4 && (columna >= 4 && columna <= 8))
                        || (columna == 4 && (fila >= 4 && fila <= 8))) {
                    bandera = true;
                } else if ((fila == 8 && (columna >= 4 && columna <= 8))
                        || (columna == 8 && (fila >= 4 && fila <= 8))) {
                    bandera = true;
                }
                break;
            case 6:
                if ((fila == 5 && (columna >= 5 && columna <= 7))
                        || (columna == 5 && (fila >= 5 && fila <= 7))) {
                    bandera = true;
                } else if ((fila == 7 && (columna >= 5 && columna <= 7))
                        || (columna == 7 && (fila >= 5 && fila <= 7))) {
                    bandera = true;
                }
                break;
            default:
                break;
        }

        return bandera;
    }
    
    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
            // en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
            // cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);
        }

        private void clickBoton(int fila, int columna) {
            // Método a completar!.
            // En fila y columna se reciben las coordenas donde presionó el usuario, relativas al comienzo de la grilla
            // fila 1 y columna 1 corresponden a la posición de arriba a la izquierda.
            // Debe indicarse cómo responder al click de ese botón.
        }
    }
}
