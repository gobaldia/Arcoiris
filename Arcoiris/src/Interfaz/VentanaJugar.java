package Interfaz;

import ArcoirisMainPackage.Juego;
import ArcoirisMainPackage.Partida;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
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
import javax.swing.Timer;

public class VentanaJugar extends javax.swing.JFrame {

    private Juego modelo;
    private VentanaPrincipal framePrincipal;
    private Partida partidaActual;
    private Partida proximaPartida;
    private JButton[][] botones;
    private JButton[] btnColumnas;
    private JButton[] btnFilas;
    private Timer timer;

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

            if (this.getPartidaActual().getTimer()) {
                jlblFin.setVisible(true);
                jlblInicio.setVisible(true);
                jProgressBarTimer.setVisible(true);
                ejecutarTimer();
                timer.start();
            } else {
                jProgressBarTimer.setVisible(false);
                jlblFin.setVisible(false);
                jlblInicio.setVisible(false);
            }

            generarIndicesFilaColumna();
            mostrarTablero(this.getPartidaActual().getListaDeTableros().get(0).getMatriz());

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
        jlblVS = new javax.swing.JLabel();
        jlblJugadorB = new javax.swing.JLabel();
        jlblTitulo = new javax.swing.JLabel();
        jProgressBarTimer = new javax.swing.JProgressBar();
        jlblInicio = new javax.swing.JLabel();
        jlblFin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlblTurnoDe = new javax.swing.JLabel();
        jlblDetalleJugadasTitulo = new javax.swing.JLabel();
        jlblDetalleJugadas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1100, 600));
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

        jPanelColumnas.setMaximumSize(new java.awt.Dimension(400000, 400000));
        jPanelColumnas.setPreferredSize(new java.awt.Dimension(600, 40));

        javax.swing.GroupLayout jPanelColumnasLayout = new javax.swing.GroupLayout(jPanelColumnas);
        jPanelColumnas.setLayout(jPanelColumnasLayout);
        jPanelColumnasLayout.setHorizontalGroup(
            jPanelColumnasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelColumnasLayout.setVerticalGroup(
            jPanelColumnasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jPanelFilas.setPreferredSize(new java.awt.Dimension(40, 500));

        javax.swing.GroupLayout jPanelFilasLayout = new javax.swing.GroupLayout(jPanelFilas);
        jPanelFilas.setLayout(jPanelFilasLayout);
        jPanelFilasLayout.setHorizontalGroup(
            jPanelFilasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );
        jPanelFilasLayout.setVerticalGroup(
            jPanelFilasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jlblJugadorA.setText("__________");

        jlblVS.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblVS.setText("vs");

        jlblJugadorB.setText("__________");

        jlblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblTitulo.setText("Partida Actual");

        jProgressBarTimer.setToolTipText("..Tic..Tac..");

        jlblInicio.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jlblInicio.setText("INICIO");

        jlblFin.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jlblFin.setText("FIN");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Turno de:");

        jlblTurnoDe.setText("__________");

        jlblDetalleJugadasTitulo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblDetalleJugadasTitulo.setText("< Detalle de Jugadas >");

        jlblDetalleJugadas.setText("__________________");

        javax.swing.GroupLayout jPanelDetalleLayout = new javax.swing.GroupLayout(jPanelDetalle);
        jPanelDetalle.setLayout(jPanelDetalleLayout);
        jPanelDetalleLayout.setHorizontalGroup(
            jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetalleLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jlblJugadorA, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblVS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jlblJugadorB)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBarTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblFin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelDetalleLayout.createSequentialGroup()
                .addGroup(jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDetalleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlblTurnoDe, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDetalleLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jlblDetalleJugadasTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblDetalleJugadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetalleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblTitulo)
                .addGap(87, 87, 87))
        );
        jPanelDetalleLayout.setVerticalGroup(
            jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTitulo)
                .addGap(30, 30, 30)
                .addGroup(jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblJugadorB)
                    .addGroup(jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblJugadorA)
                        .addComponent(jlblVS)))
                .addGap(22, 22, 22)
                .addGroup(jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblInicio)
                    .addComponent(jlblFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBarTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlblTurnoDe))
                .addGap(18, 18, 18)
                .addComponent(jlblDetalleJugadasTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblDetalleJugadas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelColumnas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jPanelColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelFilas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelJugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addComponent(jPanelDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ejecutarTimer() {
        this.timer = new Timer(1000, new ActionListener() {
            private int counter = 1;

            @Override
            public void actionPerformed(ActionEvent ae) {
                int val = jProgressBarTimer.getValue();
                if (val >= 100) {
                    timer.stop();
                    return;
                }
                jProgressBarTimer.setValue(++val);
            }
        });
    }

    private void generarIndicesFilaColumna() {
        jPanelColumnas.setLayout(new GridLayout(1, 13));
        btnColumnas = new JButton[13];

        for (int i = 0; i < btnColumnas.length; i++) {
            JButton nuevoBoton = new JButton();
            nuevoBoton.setPreferredSize(new Dimension(30, 30));
            nuevoBoton.setFont(new Font("Arial", Font.BOLD, 15));
            nuevoBoton.setText(i + 1 + "");
            nuevoBoton.setBackground(Color.GRAY);

            jPanelColumnas.add(nuevoBoton);
            btnColumnas[i] = nuevoBoton;
        }

        jPanelFilas.setLayout(new GridLayout(13, 1));
        btnFilas = new JButton[13];
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};

        for (int i = 0; i < btnFilas.length; i++) {
            JButton nuevoBoton = new JButton();
            nuevoBoton.setPreferredSize(new Dimension(30, 30));
            nuevoBoton.setFont(new Font("Arial", Font.BOLD, 15));
            nuevoBoton.setBackground(Color.GRAY);
            nuevoBoton.setText(letras[i] + "");
            //nuevoBoton.setEnabled(false);
            jPanelFilas.add(nuevoBoton);
            btnFilas[i] = nuevoBoton;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelColumnas;
    private javax.swing.JPanel jPanelDetalle;
    private javax.swing.JPanel jPanelFilas;
    private javax.swing.JPanel jPanelJugar;
    private javax.swing.JProgressBar jProgressBarTimer;
    private javax.swing.JLabel jlblDetalleJugadas;
    private javax.swing.JLabel jlblDetalleJugadasTitulo;
    private javax.swing.JLabel jlblFin;
    private javax.swing.JLabel jlblInicio;
    private javax.swing.JLabel jlblJugadorA;
    private javax.swing.JLabel jlblJugadorB;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblTurnoDe;
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
                    jButton.setPreferredSize(new Dimension(30, 30));
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
